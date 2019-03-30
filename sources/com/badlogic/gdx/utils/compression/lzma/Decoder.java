package com.badlogic.gdx.utils.compression.lzma;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.compression.lz.OutWindow;
import com.badlogic.gdx.utils.compression.rangecoder.BitTreeDecoder;
import java.io.IOException;

public class Decoder {
    int m_DictionarySize = -1;
    int m_DictionarySizeCheck = -1;
    short[] m_IsMatchDecoders = new short[192];
    short[] m_IsRep0LongDecoders = new short[192];
    short[] m_IsRepDecoders = new short[12];
    short[] m_IsRepG0Decoders = new short[12];
    short[] m_IsRepG1Decoders = new short[12];
    short[] m_IsRepG2Decoders = new short[12];
    LenDecoder m_LenDecoder = new LenDecoder();
    LiteralDecoder m_LiteralDecoder = new LiteralDecoder();
    OutWindow m_OutWindow = new OutWindow();
    BitTreeDecoder m_PosAlignDecoder = new BitTreeDecoder(4);
    short[] m_PosDecoders = new short[114];
    BitTreeDecoder[] m_PosSlotDecoder = new BitTreeDecoder[4];
    int m_PosStateMask;
    com.badlogic.gdx.utils.compression.rangecoder.Decoder m_RangeDecoder = new com.badlogic.gdx.utils.compression.rangecoder.Decoder();
    LenDecoder m_RepLenDecoder = new LenDecoder();

    class LenDecoder {
        short[] m_Choice = new short[2];
        BitTreeDecoder m_HighCoder = new BitTreeDecoder(8);
        BitTreeDecoder[] m_LowCoder = new BitTreeDecoder[16];
        BitTreeDecoder[] m_MidCoder = new BitTreeDecoder[16];
        int m_NumPosStates = 0;

        LenDecoder() {
        }

        public void Create(int numPosStates) {
            while (this.m_NumPosStates < numPosStates) {
                this.m_LowCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
                this.m_MidCoder[this.m_NumPosStates] = new BitTreeDecoder(3);
                this.m_NumPosStates++;
            }
        }

        public void Init() {
            com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Choice);
            for (int posState = 0; posState < this.m_NumPosStates; posState++) {
                this.m_LowCoder[posState].Init();
                this.m_MidCoder[posState].Init();
            }
            this.m_HighCoder.Init();
        }

        public int Decode(com.badlogic.gdx.utils.compression.rangecoder.Decoder rangeDecoder, int posState) throws IOException {
            if (rangeDecoder.DecodeBit(this.m_Choice, 0) == 0) {
                return this.m_LowCoder[posState].Decode(rangeDecoder);
            }
            if (rangeDecoder.DecodeBit(this.m_Choice, 1) == 0) {
                return 8 + this.m_MidCoder[posState].Decode(rangeDecoder);
            }
            return 8 + (this.m_HighCoder.Decode(rangeDecoder) + 8);
        }
    }

    class LiteralDecoder {
        Decoder2[] m_Coders;
        int m_NumPosBits;
        int m_NumPrevBits;
        int m_PosMask;

        class Decoder2 {
            short[] m_Decoders = new short[GL20.GL_SRC_COLOR];

            Decoder2() {
            }

            public void Init() {
                com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_Decoders);
            }

            public byte DecodeNormal(com.badlogic.gdx.utils.compression.rangecoder.Decoder rangeDecoder) throws IOException {
                int symbol = 1;
                do {
                    symbol = (symbol << 1) | rangeDecoder.DecodeBit(this.m_Decoders, symbol);
                } while (symbol < 256);
                return (byte) symbol;
            }

            public byte DecodeWithMatchByte(com.badlogic.gdx.utils.compression.rangecoder.Decoder rangeDecoder, byte matchByte) throws IOException {
                int symbol = 1;
                do {
                    int matchBit = (matchByte >> 7) & 1;
                    matchByte = (byte) (matchByte << 1);
                    int bit = rangeDecoder.DecodeBit(this.m_Decoders, ((matchBit + 1) << 8) + symbol);
                    symbol = (symbol << 1) | bit;
                    if (matchBit != bit) {
                        while (symbol < 256) {
                            symbol = (symbol << 1) | rangeDecoder.DecodeBit(this.m_Decoders, symbol);
                        }
                    }
                    return (byte) symbol;
                } while (symbol < 256);
                return (byte) symbol;
            }
        }

        LiteralDecoder() {
        }

        public void Create(int numPosBits, int numPrevBits) {
            if (this.m_Coders == null || this.m_NumPrevBits != numPrevBits || this.m_NumPosBits != numPosBits) {
                this.m_NumPosBits = numPosBits;
                this.m_PosMask = (1 << numPosBits) - 1;
                this.m_NumPrevBits = numPrevBits;
                int numStates = 1 << (this.m_NumPrevBits + this.m_NumPosBits);
                this.m_Coders = new Decoder2[numStates];
                for (int i = 0; i < numStates; i++) {
                    this.m_Coders[i] = new Decoder2();
                }
            }
        }

        public void Init() {
            int numStates = 1 << (this.m_NumPrevBits + this.m_NumPosBits);
            for (int i = 0; i < numStates; i++) {
                this.m_Coders[i].Init();
            }
        }

        Decoder2 GetDecoder(int pos, byte prevByte) {
            return this.m_Coders[((this.m_PosMask & pos) << this.m_NumPrevBits) + ((prevByte & 255) >>> (8 - this.m_NumPrevBits))];
        }
    }

    public Decoder() {
        for (int i = 0; i < 4; i++) {
            this.m_PosSlotDecoder[i] = new BitTreeDecoder(6);
        }
    }

    boolean SetDictionarySize(int dictionarySize) {
        if (dictionarySize < 0) {
            return false;
        }
        if (this.m_DictionarySize == dictionarySize) {
            return true;
        }
        this.m_DictionarySize = dictionarySize;
        this.m_DictionarySizeCheck = Math.max(this.m_DictionarySize, 1);
        this.m_OutWindow.Create(Math.max(this.m_DictionarySizeCheck, 4096));
        return true;
    }

    boolean SetLcLpPb(int lc, int lp, int pb) {
        if (lc > 8 || lp > 4 || pb > 4) {
            return false;
        }
        this.m_LiteralDecoder.Create(lp, lc);
        int numPosStates = 1 << pb;
        this.m_LenDecoder.Create(numPosStates);
        this.m_RepLenDecoder.Create(numPosStates);
        this.m_PosStateMask = numPosStates - 1;
        return true;
    }

    void Init() throws IOException {
        this.m_OutWindow.Init(false);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsMatchDecoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRep0LongDecoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepDecoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG0Decoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG1Decoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_IsRepG2Decoders);
        com.badlogic.gdx.utils.compression.rangecoder.Decoder.InitBitModels(this.m_PosDecoders);
        this.m_LiteralDecoder.Init();
        for (int i = 0; i < 4; i++) {
            this.m_PosSlotDecoder[i].Init();
        }
        this.m_LenDecoder.Init();
        this.m_RepLenDecoder.Init();
        this.m_PosAlignDecoder.Init();
        this.m_RangeDecoder.Init();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Code(java.io.InputStream r21, java.io.OutputStream r22, long r23) throws java.io.IOException {
        /*
        r20 = this;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r17;
        r1 = r21;
        r0.SetStream(r1);
        r0 = r20;
        r0 = r0.m_OutWindow;
        r17 = r0;
        r0 = r17;
        r1 = r22;
        r0.SetStream(r1);
        r20.Init();
        r16 = com.badlogic.gdx.utils.compression.lzma.Base.StateInit();
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r6 = 0;
        r11 = 0;
    L_0x0028:
        r17 = 0;
        r17 = (r23 > r17 ? 1 : (r23 == r17 ? 0 : -1));
        if (r17 < 0) goto L_0x0032;
    L_0x002e:
        r17 = (r6 > r23 ? 1 : (r6 == r23 ? 0 : -1));
        if (r17 >= 0) goto L_0x01f2;
    L_0x0032:
        r0 = (int) r6;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_PosStateMask;
        r18 = r0;
        r10 = r17 & r18;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_IsMatchDecoders;
        r18 = r0;
        r19 = r16 << 4;
        r19 = r19 + r10;
        r17 = r17.DecodeBit(r18, r19);
        if (r17 != 0) goto L_0x00a5;
    L_0x0053:
        r0 = r20;
        r0 = r0.m_LiteralDecoder;
        r17 = r0;
        r0 = (int) r6;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r3 = r0.GetDecoder(r1, r11);
        r17 = com.badlogic.gdx.utils.compression.lzma.Base.StateIsCharState(r16);
        if (r17 != 0) goto L_0x0098;
    L_0x006a:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_OutWindow;
        r18 = r0;
        r0 = r18;
        r18 = r0.GetByte(r12);
        r0 = r17;
        r1 = r18;
        r11 = r3.DecodeWithMatchByte(r0, r1);
    L_0x0084:
        r0 = r20;
        r0 = r0.m_OutWindow;
        r17 = r0;
        r0 = r17;
        r0.PutByte(r11);
        r16 = com.badlogic.gdx.utils.compression.lzma.Base.StateUpdateChar(r16);
        r17 = 1;
        r6 = r6 + r17;
        goto L_0x0028;
    L_0x0098:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r17;
        r11 = r3.DecodeNormal(r0);
        goto L_0x0084;
    L_0x00a5:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_IsRepDecoders;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r2 = r16;
        r17 = r0.DecodeBit(r1, r2);
        r18 = 1;
        r0 = r17;
        r1 = r18;
        if (r0 != r1) goto L_0x0161;
    L_0x00c3:
        r5 = 0;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_IsRepG0Decoders;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r2 = r16;
        r17 = r0.DecodeBit(r1, r2);
        if (r17 != 0) goto L_0x0127;
    L_0x00dc:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_IsRep0LongDecoders;
        r18 = r0;
        r19 = r16 << 4;
        r19 = r19 + r10;
        r17 = r17.DecodeBit(r18, r19);
        if (r17 != 0) goto L_0x00f7;
    L_0x00f2:
        r16 = com.badlogic.gdx.utils.compression.lzma.Base.StateUpdateShortRep(r16);
        r5 = 1;
    L_0x00f7:
        if (r5 != 0) goto L_0x0113;
    L_0x00f9:
        r0 = r20;
        r0 = r0.m_RepLenDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r17 = r0.Decode(r1, r10);
        r5 = r17 + 2;
        r16 = com.badlogic.gdx.utils.compression.lzma.Base.StateUpdateRep(r16);
    L_0x0113:
        r0 = (long) r12;
        r17 = r0;
        r17 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1));
        if (r17 >= 0) goto L_0x0124;
    L_0x011a:
        r0 = r20;
        r0 = r0.m_DictionarySizeCheck;
        r17 = r0;
        r0 = r17;
        if (r12 < r0) goto L_0x0218;
    L_0x0124:
        r17 = 0;
    L_0x0126:
        return r17;
    L_0x0127:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_IsRepG1Decoders;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r2 = r16;
        r17 = r0.DecodeBit(r1, r2);
        if (r17 != 0) goto L_0x0143;
    L_0x013f:
        r4 = r13;
    L_0x0140:
        r13 = r12;
        r12 = r4;
        goto L_0x00f7;
    L_0x0143:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_IsRepG2Decoders;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r2 = r16;
        r17 = r0.DecodeBit(r1, r2);
        if (r17 != 0) goto L_0x015e;
    L_0x015b:
        r4 = r14;
    L_0x015c:
        r14 = r13;
        goto L_0x0140;
    L_0x015e:
        r4 = r15;
        r15 = r14;
        goto L_0x015c;
    L_0x0161:
        r15 = r14;
        r14 = r13;
        r13 = r12;
        r0 = r20;
        r0 = r0.m_LenDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r17 = r0.Decode(r1, r10);
        r5 = r17 + 2;
        r16 = com.badlogic.gdx.utils.compression.lzma.Base.StateUpdateMatch(r16);
        r0 = r20;
        r0 = r0.m_PosSlotDecoder;
        r17 = r0;
        r18 = com.badlogic.gdx.utils.compression.lzma.Base.GetLenToPosState(r5);
        r17 = r17[r18];
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r18 = r0;
        r9 = r17.Decode(r18);
        r17 = 4;
        r0 = r17;
        if (r9 < r0) goto L_0x0215;
    L_0x019a:
        r17 = r9 >> 1;
        r8 = r17 + -1;
        r17 = r9 & 1;
        r17 = r17 | 2;
        r12 = r17 << r8;
        r17 = 14;
        r0 = r17;
        if (r9 >= r0) goto L_0x01c8;
    L_0x01aa:
        r0 = r20;
        r0 = r0.m_PosDecoders;
        r17 = r0;
        r18 = r12 - r9;
        r18 = r18 + -1;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r19 = r0;
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r17 = com.badlogic.gdx.utils.compression.rangecoder.BitTreeDecoder.ReverseDecode(r0, r1, r2, r8);
        r12 = r12 + r17;
        goto L_0x0113;
    L_0x01c8:
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r18 = r8 + -4;
        r17 = r17.DecodeDirectBits(r18);
        r17 = r17 << 4;
        r12 = r12 + r17;
        r0 = r20;
        r0 = r0.m_PosAlignDecoder;
        r17 = r0;
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r18 = r0;
        r17 = r17.ReverseDecode(r18);
        r12 = r12 + r17;
        if (r12 >= 0) goto L_0x0113;
    L_0x01ec:
        r17 = -1;
        r0 = r17;
        if (r12 != r0) goto L_0x0211;
    L_0x01f2:
        r0 = r20;
        r0 = r0.m_OutWindow;
        r17 = r0;
        r17.Flush();
        r0 = r20;
        r0 = r0.m_OutWindow;
        r17 = r0;
        r17.ReleaseStream();
        r0 = r20;
        r0 = r0.m_RangeDecoder;
        r17 = r0;
        r17.ReleaseStream();
        r17 = 1;
        goto L_0x0126;
    L_0x0211:
        r17 = 0;
        goto L_0x0126;
    L_0x0215:
        r12 = r9;
        goto L_0x0113;
    L_0x0218:
        r0 = r20;
        r0 = r0.m_OutWindow;
        r17 = r0;
        r0 = r17;
        r0.CopyBlock(r12, r5);
        r0 = (long) r5;
        r17 = r0;
        r6 = r6 + r17;
        r0 = r20;
        r0 = r0.m_OutWindow;
        r17 = r0;
        r18 = 0;
        r11 = r17.GetByte(r18);
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.compression.lzma.Decoder.Code(java.io.InputStream, java.io.OutputStream, long):boolean");
    }

    public boolean SetDecoderProperties(byte[] properties) {
        if (properties.length < 5) {
            return false;
        }
        int val = properties[0] & 255;
        int lc = val % 9;
        int remainder = val / 9;
        int lp = remainder % 5;
        int pb = remainder / 5;
        int dictionarySize = 0;
        for (int i = 0; i < 4; i++) {
            dictionarySize += (properties[i + 1] & 255) << (i * 8);
        }
        if (SetLcLpPb(lc, lp, pb)) {
            return SetDictionarySize(dictionarySize);
        }
        return false;
    }
}
