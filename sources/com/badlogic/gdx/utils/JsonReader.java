package com.badlogic.gdx.utils;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonValue.ValueType;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonReader implements BaseJsonReader {
    private static final byte[] _json_actions = init__json_actions_0();
    private static final byte[] _json_eof_actions = init__json_eof_actions_0();
    private static final short[] _json_index_offsets = init__json_index_offsets_0();
    private static final byte[] _json_indicies = init__json_indicies_0();
    private static final short[] _json_key_offsets = init__json_key_offsets_0();
    private static final byte[] _json_range_lengths = init__json_range_lengths_0();
    private static final byte[] _json_single_lengths = init__json_single_lengths_0();
    private static final byte[] _json_trans_actions = init__json_trans_actions_0();
    private static final char[] _json_trans_keys = init__json_trans_keys_0();
    private static final byte[] _json_trans_targs = init__json_trans_targs_0();
    static final int json_en_array = 23;
    static final int json_en_main = 1;
    static final int json_en_object = 5;
    static final int json_error = 0;
    static final int json_first_final = 35;
    static final int json_start = 1;
    private JsonValue current;
    private final Array<JsonValue> elements = new Array(8);
    private final Array<JsonValue> lastChild = new Array(8);
    private JsonValue root;

    public JsonValue parse(String json) {
        char[] data = json.toCharArray();
        return parse(data, 0, data.length);
    }

    public JsonValue parse(Reader reader) {
        try {
            char[] data = new char[1024];
            int offset = 0;
            while (true) {
                int length = reader.read(data, offset, data.length - offset);
                if (length == -1) {
                    JsonValue parse = parse(data, 0, offset);
                    StreamUtils.closeQuietly(reader);
                    return parse;
                } else if (length == 0) {
                    char[] newData = new char[(data.length * 2)];
                    System.arraycopy(data, 0, newData, 0, data.length);
                    data = newData;
                } else {
                    offset += length;
                }
            }
        } catch (Throwable ex) {
            throw new SerializationException(ex);
        } catch (Throwable th) {
            StreamUtils.closeQuietly(reader);
        }
    }

    public JsonValue parse(InputStream input) {
        try {
            JsonValue parse = parse(new InputStreamReader(input, "UTF-8"));
            StreamUtils.closeQuietly(input);
            return parse;
        } catch (Throwable ex) {
            throw new SerializationException(ex);
        } catch (Throwable th) {
            StreamUtils.closeQuietly(input);
        }
    }

    public JsonValue parse(FileHandle file) {
        try {
            return parse(file.reader("UTF-8"));
        } catch (Exception ex) {
            throw new SerializationException("Error parsing file: " + file, ex);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.badlogic.gdx.utils.JsonValue parse(char[] r53, int r54, int r55) {
        /*
        r52 = this;
        r34 = r54;
        r37 = r55;
        r26 = r37;
        r44 = 0;
        r47 = 4;
        r0 = r47;
        r0 = new int[r0];
        r40 = r0;
        r39 = 0;
        r31 = new com.badlogic.gdx.utils.Array;
        r47 = 8;
        r0 = r31;
        r1 = r47;
        r0.<init>(r1);
        r32 = 0;
        r42 = 0;
        r43 = 0;
        r36 = 0;
        r24 = 0;
        if (r24 == 0) goto L_0x002e;
    L_0x0029:
        r47 = java.lang.System.out;
        r47.println();
    L_0x002e:
        r23 = 1;
        r44 = 0;
        r18 = 0;
        r11 = 0;
        r45 = r44;
    L_0x0037:
        switch(r11) {
            case 0: goto L_0x007a;
            case 1: goto L_0x0086;
            case 2: goto L_0x057b;
            case 3: goto L_0x003a;
            case 4: goto L_0x058b;
            default: goto L_0x003a;
        };
    L_0x003a:
        r44 = r45;
    L_0x003c:
        r0 = r52;
        r0 = r0.root;
        r38 = r0;
        r47 = 0;
        r0 = r47;
        r1 = r52;
        r1.root = r0;
        r47 = 0;
        r0 = r47;
        r1 = r52;
        r1.current = r0;
        r0 = r52;
        r0 = r0.lastChild;
        r47 = r0;
        r47.clear();
        r0 = r34;
        r1 = r37;
        if (r0 >= r1) goto L_0x07a1;
    L_0x0061:
        r29 = 1;
        r28 = 0;
    L_0x0065:
        r0 = r28;
        r1 = r34;
        if (r0 >= r1) goto L_0x075f;
    L_0x006b:
        r47 = r53[r28];
        r48 = 10;
        r0 = r47;
        r1 = r48;
        if (r0 != r1) goto L_0x0077;
    L_0x0075:
        r29 = r29 + 1;
    L_0x0077:
        r28 = r28 + 1;
        goto L_0x0065;
    L_0x007a:
        r0 = r34;
        r1 = r37;
        if (r0 != r1) goto L_0x0082;
    L_0x0080:
        r11 = 4;
        goto L_0x0037;
    L_0x0082:
        if (r23 != 0) goto L_0x0086;
    L_0x0084:
        r11 = 5;
        goto L_0x0037;
    L_0x0086:
        r47 = _json_key_offsets;	 Catch:{ RuntimeException -> 0x0468 }
        r12 = r47[r23];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = _json_index_offsets;	 Catch:{ RuntimeException -> 0x0468 }
        r18 = r47[r23];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = _json_single_lengths;	 Catch:{ RuntimeException -> 0x0468 }
        r13 = r47[r23];	 Catch:{ RuntimeException -> 0x0468 }
        if (r13 <= 0) goto L_0x00a0;
    L_0x0094:
        r14 = r12;
        r47 = r12 + r13;
        r19 = r47 + -1;
    L_0x0099:
        r0 = r19;
        if (r0 >= r14) goto L_0x00e4;
    L_0x009d:
        r12 = r12 + r13;
        r18 = r18 + r13;
    L_0x00a0:
        r47 = _json_range_lengths;	 Catch:{ RuntimeException -> 0x0468 }
        r13 = r47[r23];	 Catch:{ RuntimeException -> 0x0468 }
        if (r13 <= 0) goto L_0x00b3;
    L_0x00a6:
        r14 = r12;
        r47 = r13 << 1;
        r47 = r47 + r12;
        r19 = r47 + -2;
    L_0x00ad:
        r0 = r19;
        if (r0 >= r14) goto L_0x010d;
    L_0x00b1:
        r18 = r18 + r13;
    L_0x00b3:
        r47 = _json_indicies;	 Catch:{ RuntimeException -> 0x0468 }
        r18 = r47[r18];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = _json_trans_targs;	 Catch:{ RuntimeException -> 0x0468 }
        r23 = r47[r18];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = _json_trans_actions;	 Catch:{ RuntimeException -> 0x0468 }
        r47 = r47[r18];	 Catch:{ RuntimeException -> 0x0468 }
        if (r47 == 0) goto L_0x057b;
    L_0x00c1:
        r47 = _json_trans_actions;	 Catch:{ RuntimeException -> 0x0468 }
        r9 = r47[r18];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = _json_actions;	 Catch:{ RuntimeException -> 0x0468 }
        r10 = r9 + 1;
        r16 = r47[r9];	 Catch:{ RuntimeException -> 0x0468 }
        r17 = r16;
        r35 = r34;
    L_0x00cf:
        r16 = r17 + -1;
        if (r17 <= 0) goto L_0x0579;
    L_0x00d3:
        r47 = _json_actions;	 Catch:{ RuntimeException -> 0x01d7 }
        r9 = r10 + 1;
        r47 = r47[r10];	 Catch:{ RuntimeException -> 0x01d7 }
        switch(r47) {
            case 0: goto L_0x013e;
            case 1: goto L_0x0143;
            case 2: goto L_0x0302;
            case 3: goto L_0x0377;
            case 4: goto L_0x038e;
            case 5: goto L_0x0403;
            case 6: goto L_0x041a;
            case 7: goto L_0x0491;
            case 8: goto L_0x0554;
            default: goto L_0x00dc;
        };
    L_0x00dc:
        r34 = r35;
    L_0x00de:
        r17 = r16;
        r10 = r9;
        r35 = r34;
        goto L_0x00cf;
    L_0x00e4:
        r47 = r19 - r14;
        r47 = r47 >> 1;
        r15 = r14 + r47;
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = _json_trans_keys;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48[r15];	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r47;
        r1 = r48;
        if (r0 >= r1) goto L_0x00f9;
    L_0x00f6:
        r19 = r15 + -1;
        goto L_0x0099;
    L_0x00f9:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = _json_trans_keys;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48[r15];	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r47;
        r1 = r48;
        if (r0 <= r1) goto L_0x0108;
    L_0x0105:
        r14 = r15 + 1;
        goto L_0x0099;
    L_0x0108:
        r47 = r15 - r12;
        r18 = r18 + r47;
        goto L_0x00b3;
    L_0x010d:
        r47 = r19 - r14;
        r47 = r47 >> 1;
        r47 = r47 & -2;
        r15 = r14 + r47;
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = _json_trans_keys;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48[r15];	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r47;
        r1 = r48;
        if (r0 >= r1) goto L_0x0124;
    L_0x0121:
        r19 = r15 + -2;
        goto L_0x00ad;
    L_0x0124:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = _json_trans_keys;	 Catch:{ RuntimeException -> 0x0468 }
        r49 = r15 + 1;
        r48 = r48[r49];	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r47;
        r1 = r48;
        if (r0 <= r1) goto L_0x0136;
    L_0x0132:
        r14 = r15 + 2;
        goto L_0x00ad;
    L_0x0136:
        r47 = r15 - r12;
        r47 = r47 >> 1;
        r18 = r18 + r47;
        goto L_0x00b3;
    L_0x013e:
        r42 = 1;
        r34 = r35;
        goto L_0x00de;
    L_0x0143:
        r46 = new java.lang.String;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r35 - r39;
        r0 = r46;
        r1 = r53;
        r2 = r39;
        r3 = r47;
        r0.<init>(r1, r2, r3);	 Catch:{ RuntimeException -> 0x01d7 }
        if (r32 == 0) goto L_0x015c;
    L_0x0154:
        r0 = r52;
        r1 = r46;
        r46 = r0.unescape(r1);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x015c:
        if (r42 == 0) goto L_0x018d;
    L_0x015e:
        r42 = 0;
        if (r24 == 0) goto L_0x017e;
    L_0x0162:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "name: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r46;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x017e:
        r0 = r31;
        r1 = r46;
        r0.add(r1);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x0185:
        r43 = 0;
        r39 = r35;
        r34 = r35;
        goto L_0x00de;
    L_0x018d:
        r0 = r31;
        r0 = r0.size;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        if (r47 <= 0) goto L_0x01e0;
    L_0x0195:
        r47 = r31.pop();	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = (java.lang.String) r47;	 Catch:{ RuntimeException -> 0x01d7 }
        r30 = r47;
    L_0x019d:
        if (r43 == 0) goto L_0x0284;
    L_0x019f:
        r47 = "true";
        r47 = r46.equals(r47);	 Catch:{ RuntimeException -> 0x01d7 }
        if (r47 == 0) goto L_0x01e3;
    L_0x01a7:
        if (r24 == 0) goto L_0x01cb;
    L_0x01a9:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "boolean: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "=true";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x01cb:
        r47 = 1;
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.bool(r1, r2);	 Catch:{ RuntimeException -> 0x01d7 }
        goto L_0x0185;
    L_0x01d7:
        r27 = move-exception;
        r44 = r45;
        r34 = r35;
    L_0x01dc:
        r36 = r27;
        goto L_0x003c;
    L_0x01e0:
        r30 = 0;
        goto L_0x019d;
    L_0x01e3:
        r47 = "false";
        r47 = r46.equals(r47);	 Catch:{ RuntimeException -> 0x01d7 }
        if (r47 == 0) goto L_0x021c;
    L_0x01eb:
        if (r24 == 0) goto L_0x020f;
    L_0x01ed:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "boolean: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "=false";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x020f:
        r47 = 0;
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.bool(r1, r2);	 Catch:{ RuntimeException -> 0x01d7 }
        goto L_0x0185;
    L_0x021c:
        r47 = "null";
        r47 = r46.equals(r47);	 Catch:{ RuntimeException -> 0x01d7 }
        if (r47 == 0) goto L_0x0231;
    L_0x0224:
        r47 = 0;
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.string(r1, r2);	 Catch:{ RuntimeException -> 0x01d7 }
        goto L_0x0185;
    L_0x0231:
        r21 = 0;
        r22 = 1;
        r28 = r39;
    L_0x0237:
        r0 = r28;
        r1 = r35;
        if (r0 >= r1) goto L_0x0246;
    L_0x023d:
        r47 = r53[r28];	 Catch:{ RuntimeException -> 0x01d7 }
        switch(r47) {
            case 43: goto L_0x02bf;
            case 45: goto L_0x02bf;
            case 46: goto L_0x02bb;
            case 48: goto L_0x02bf;
            case 49: goto L_0x02bf;
            case 50: goto L_0x02bf;
            case 51: goto L_0x02bf;
            case 52: goto L_0x02bf;
            case 53: goto L_0x02bf;
            case 54: goto L_0x02bf;
            case 55: goto L_0x02bf;
            case 56: goto L_0x02bf;
            case 57: goto L_0x02bf;
            case 69: goto L_0x02bb;
            case 101: goto L_0x02bb;
            default: goto L_0x0242;
        };
    L_0x0242:
        r21 = 0;
        r22 = 0;
    L_0x0246:
        if (r21 == 0) goto L_0x02c3;
    L_0x0248:
        if (r24 == 0) goto L_0x0274;
    L_0x024a:
        r47 = java.lang.System.out;	 Catch:{ NumberFormatException -> 0x0283 }
        r48 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0283 }
        r48.<init>();	 Catch:{ NumberFormatException -> 0x0283 }
        r49 = "double: ";
        r48 = r48.append(r49);	 Catch:{ NumberFormatException -> 0x0283 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ NumberFormatException -> 0x0283 }
        r49 = "=";
        r48 = r48.append(r49);	 Catch:{ NumberFormatException -> 0x0283 }
        r49 = java.lang.Double.parseDouble(r46);	 Catch:{ NumberFormatException -> 0x0283 }
        r48 = r48.append(r49);	 Catch:{ NumberFormatException -> 0x0283 }
        r48 = r48.toString();	 Catch:{ NumberFormatException -> 0x0283 }
        r47.println(r48);	 Catch:{ NumberFormatException -> 0x0283 }
    L_0x0274:
        r47 = java.lang.Double.parseDouble(r46);	 Catch:{ NumberFormatException -> 0x0283 }
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.number(r1, r2);	 Catch:{ NumberFormatException -> 0x0283 }
        goto L_0x0185;
    L_0x0283:
        r47 = move-exception;
    L_0x0284:
        if (r24 == 0) goto L_0x02b0;
    L_0x0286:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "string: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "=";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r46;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x02b0:
        r0 = r52;
        r1 = r30;
        r2 = r46;
        r0.string(r1, r2);	 Catch:{ RuntimeException -> 0x01d7 }
        goto L_0x0185;
    L_0x02bb:
        r21 = 1;
        r22 = 0;
    L_0x02bf:
        r28 = r28 + 1;
        goto L_0x0237;
    L_0x02c3:
        if (r22 == 0) goto L_0x0284;
    L_0x02c5:
        if (r24 == 0) goto L_0x02f1;
    L_0x02c7:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "double: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "=";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = java.lang.Double.parseDouble(r46);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x02f1:
        r47 = java.lang.Long.parseLong(r46);	 Catch:{ NumberFormatException -> 0x0300 }
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.number(r1, r2);	 Catch:{ NumberFormatException -> 0x0300 }
        goto L_0x0185;
    L_0x0300:
        r47 = move-exception;
        goto L_0x0284;
    L_0x0302:
        r0 = r31;
        r0 = r0.size;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        if (r47 <= 0) goto L_0x0374;
    L_0x030a:
        r47 = r31.pop();	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = (java.lang.String) r47;	 Catch:{ RuntimeException -> 0x01d7 }
        r30 = r47;
    L_0x0312:
        if (r24 == 0) goto L_0x0330;
    L_0x0314:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "startObject: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x0330:
        r0 = r52;
        r1 = r30;
        r0.startObject(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r40;
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        r0 = r45;
        r1 = r47;
        if (r0 != r1) goto L_0x0367;
    L_0x0342:
        r0 = r40;
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        r47 = r47 * 2;
        r0 = r47;
        r0 = new int[r0];	 Catch:{ RuntimeException -> 0x01d7 }
        r33 = r0;
        r47 = 0;
        r48 = 0;
        r0 = r40;
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = r0;
        r0 = r40;
        r1 = r47;
        r2 = r33;
        r3 = r48;
        r4 = r49;
        java.lang.System.arraycopy(r0, r1, r2, r3, r4);	 Catch:{ RuntimeException -> 0x01d7 }
        r40 = r33;
    L_0x0367:
        r44 = r45 + 1;
        r40[r45] = r23;	 Catch:{ RuntimeException -> 0x0807 }
        r23 = 5;
        r11 = 2;
        r45 = r44;
        r34 = r35;
        goto L_0x0037;
    L_0x0374:
        r30 = 0;
        goto L_0x0312;
    L_0x0377:
        if (r24 == 0) goto L_0x0380;
    L_0x0379:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = "endObject";
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x0380:
        r52.pop();	 Catch:{ RuntimeException -> 0x01d7 }
        r44 = r45 + -1;
        r23 = r40[r44];	 Catch:{ RuntimeException -> 0x0807 }
        r11 = 2;
        r45 = r44;
        r34 = r35;
        goto L_0x0037;
    L_0x038e:
        r0 = r31;
        r0 = r0.size;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        if (r47 <= 0) goto L_0x0400;
    L_0x0396:
        r47 = r31.pop();	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = (java.lang.String) r47;	 Catch:{ RuntimeException -> 0x01d7 }
        r30 = r47;
    L_0x039e:
        if (r24 == 0) goto L_0x03bc;
    L_0x03a0:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x01d7 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = "startArray: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x01d7 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x03bc:
        r0 = r52;
        r1 = r30;
        r0.startArray(r1);	 Catch:{ RuntimeException -> 0x01d7 }
        r0 = r40;
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        r0 = r45;
        r1 = r47;
        if (r0 != r1) goto L_0x03f3;
    L_0x03ce:
        r0 = r40;
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x01d7 }
        r47 = r0;
        r47 = r47 * 2;
        r0 = r47;
        r0 = new int[r0];	 Catch:{ RuntimeException -> 0x01d7 }
        r33 = r0;
        r47 = 0;
        r48 = 0;
        r0 = r40;
        r0 = r0.length;	 Catch:{ RuntimeException -> 0x01d7 }
        r49 = r0;
        r0 = r40;
        r1 = r47;
        r2 = r33;
        r3 = r48;
        r4 = r49;
        java.lang.System.arraycopy(r0, r1, r2, r3, r4);	 Catch:{ RuntimeException -> 0x01d7 }
        r40 = r33;
    L_0x03f3:
        r44 = r45 + 1;
        r40[r45] = r23;	 Catch:{ RuntimeException -> 0x0807 }
        r23 = 23;
        r11 = 2;
        r45 = r44;
        r34 = r35;
        goto L_0x0037;
    L_0x0400:
        r30 = 0;
        goto L_0x039e;
    L_0x0403:
        if (r24 == 0) goto L_0x040c;
    L_0x0405:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = "endArray";
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x040c:
        r52.pop();	 Catch:{ RuntimeException -> 0x01d7 }
        r44 = r45 + -1;
        r23 = r40[r44];	 Catch:{ RuntimeException -> 0x0807 }
        r11 = 2;
        r45 = r44;
        r34 = r35;
        goto L_0x0037;
    L_0x041a:
        r41 = r35 + -1;
        r34 = r35 + 1;
        r47 = r53[r35];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = 47;
        r0 = r47;
        r1 = r48;
        if (r0 != r1) goto L_0x046d;
    L_0x0428:
        r0 = r34;
        r1 = r26;
        if (r0 == r1) goto L_0x043b;
    L_0x042e:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = 10;
        r0 = r47;
        r1 = r48;
        if (r0 == r1) goto L_0x043b;
    L_0x0438:
        r34 = r34 + 1;
        goto L_0x0428;
    L_0x043b:
        r34 = r34 + -1;
    L_0x043d:
        if (r24 == 0) goto L_0x00de;
    L_0x043f:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "comment ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = new java.lang.String;	 Catch:{ RuntimeException -> 0x0468 }
        r50 = r34 - r41;
        r0 = r49;
        r1 = r53;
        r2 = r41;
        r3 = r50;
        r0.<init>(r1, r2, r3);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
        goto L_0x00de;
    L_0x0468:
        r27 = move-exception;
        r44 = r45;
        goto L_0x01dc;
    L_0x046d:
        r47 = r34 + 1;
        r0 = r47;
        r1 = r26;
        if (r0 >= r1) goto L_0x047f;
    L_0x0475:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = 42;
        r0 = r47;
        r1 = r48;
        if (r0 != r1) goto L_0x048b;
    L_0x047f:
        r47 = r34 + 1;
        r47 = r53[r47];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = 47;
        r0 = r47;
        r1 = r48;
        if (r0 == r1) goto L_0x048e;
    L_0x048b:
        r34 = r34 + 1;
        goto L_0x046d;
    L_0x048e:
        r34 = r34 + 1;
        goto L_0x043d;
    L_0x0491:
        if (r24 == 0) goto L_0x049a;
    L_0x0493:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = "unquotedChars";
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x049a:
        r39 = r35;
        r32 = 0;
        r43 = 1;
        if (r42 == 0) goto L_0x0502;
    L_0x04a2:
        r34 = r35;
    L_0x04a4:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        switch(r47) {
            case 10: goto L_0x04d3;
            case 13: goto L_0x04d3;
            case 47: goto L_0x04e5;
            case 58: goto L_0x04d3;
            case 92: goto L_0x04e2;
            default: goto L_0x04a9;
        };	 Catch:{ RuntimeException -> 0x0468 }
    L_0x04a9:
        if (r24 == 0) goto L_0x04cb;
    L_0x04ab:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "unquotedChar (name): '";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "'";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x04cb:
        r34 = r34 + 1;
        r0 = r34;
        r1 = r26;
        if (r0 != r1) goto L_0x04a4;
    L_0x04d3:
        r34 = r34 + -1;
    L_0x04d5:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = 32;
        r0 = r47;
        r1 = r48;
        if (r0 != r1) goto L_0x00de;
    L_0x04df:
        r34 = r34 + -1;
        goto L_0x04d5;
    L_0x04e2:
        r32 = 1;
        goto L_0x04a9;
    L_0x04e5:
        r47 = r34 + 1;
        r0 = r47;
        r1 = r26;
        if (r0 == r1) goto L_0x04a9;
    L_0x04ed:
        r47 = r34 + 1;
        r20 = r53[r47];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = 47;
        r0 = r20;
        r1 = r47;
        if (r0 == r1) goto L_0x04d3;
    L_0x04f9:
        r47 = 42;
        r0 = r20;
        r1 = r47;
        if (r0 != r1) goto L_0x04a9;
    L_0x0501:
        goto L_0x04d3;
    L_0x0502:
        r34 = r35;
    L_0x0504:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        switch(r47) {
            case 10: goto L_0x04d3;
            case 13: goto L_0x04d3;
            case 44: goto L_0x04d3;
            case 47: goto L_0x0537;
            case 92: goto L_0x0534;
            case 93: goto L_0x04d3;
            case 125: goto L_0x04d3;
            default: goto L_0x0509;
        };	 Catch:{ RuntimeException -> 0x0468 }
    L_0x0509:
        if (r24 == 0) goto L_0x052b;
    L_0x050b:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "unquotedChar (value): '";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "'";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x052b:
        r34 = r34 + 1;
        r0 = r34;
        r1 = r26;
        if (r0 != r1) goto L_0x0504;
    L_0x0533:
        goto L_0x04d3;
    L_0x0534:
        r32 = 1;
        goto L_0x0509;
    L_0x0537:
        r47 = r34 + 1;
        r0 = r47;
        r1 = r26;
        if (r0 == r1) goto L_0x0509;
    L_0x053f:
        r47 = r34 + 1;
        r20 = r53[r47];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = 47;
        r0 = r20;
        r1 = r47;
        if (r0 == r1) goto L_0x04d3;
    L_0x054b:
        r47 = 42;
        r0 = r20;
        r1 = r47;
        if (r0 != r1) goto L_0x0509;
    L_0x0553:
        goto L_0x04d3;
    L_0x0554:
        if (r24 == 0) goto L_0x055d;
    L_0x0556:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x01d7 }
        r48 = "quotedChars";
        r47.println(r48);	 Catch:{ RuntimeException -> 0x01d7 }
    L_0x055d:
        r34 = r35 + 1;
        r39 = r34;
        r32 = 0;
    L_0x0563:
        r47 = r53[r34];	 Catch:{ RuntimeException -> 0x0468 }
        switch(r47) {
            case 34: goto L_0x0570;
            case 92: goto L_0x0574;
            default: goto L_0x0568;
        };	 Catch:{ RuntimeException -> 0x0468 }
    L_0x0568:
        r34 = r34 + 1;
        r0 = r34;
        r1 = r26;
        if (r0 != r1) goto L_0x0563;
    L_0x0570:
        r34 = r34 + -1;
        goto L_0x00de;
    L_0x0574:
        r32 = 1;
        r34 = r34 + 1;
        goto L_0x0568;
    L_0x0579:
        r34 = r35;
    L_0x057b:
        if (r23 != 0) goto L_0x0580;
    L_0x057d:
        r11 = 5;
        goto L_0x0037;
    L_0x0580:
        r34 = r34 + 1;
        r0 = r34;
        r1 = r37;
        if (r0 == r1) goto L_0x058b;
    L_0x0588:
        r11 = 1;
        goto L_0x0037;
    L_0x058b:
        r0 = r34;
        r1 = r26;
        if (r0 != r1) goto L_0x003a;
    L_0x0591:
        r47 = _json_eof_actions;	 Catch:{ RuntimeException -> 0x0468 }
        r5 = r47[r23];	 Catch:{ RuntimeException -> 0x0468 }
        r47 = _json_actions;	 Catch:{ RuntimeException -> 0x0468 }
        r6 = r5 + 1;
        r7 = r47[r5];	 Catch:{ RuntimeException -> 0x0468 }
        r8 = r7;
    L_0x059c:
        r7 = r8 + -1;
        if (r8 <= 0) goto L_0x003a;
    L_0x05a0:
        r47 = _json_actions;	 Catch:{ RuntimeException -> 0x0468 }
        r5 = r6 + 1;
        r47 = r47[r6];	 Catch:{ RuntimeException -> 0x0468 }
        switch(r47) {
            case 1: goto L_0x05ac;
            default: goto L_0x05a9;
        };	 Catch:{ RuntimeException -> 0x0468 }
    L_0x05a9:
        r8 = r7;
        r6 = r5;
        goto L_0x059c;
    L_0x05ac:
        r46 = new java.lang.String;	 Catch:{ RuntimeException -> 0x0468 }
        r47 = r34 - r39;
        r0 = r46;
        r1 = r53;
        r2 = r39;
        r3 = r47;
        r0.<init>(r1, r2, r3);	 Catch:{ RuntimeException -> 0x0468 }
        if (r32 == 0) goto L_0x05c5;
    L_0x05bd:
        r0 = r52;
        r1 = r46;
        r46 = r0.unescape(r1);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x05c5:
        if (r42 == 0) goto L_0x05f3;
    L_0x05c7:
        r42 = 0;
        if (r24 == 0) goto L_0x05e7;
    L_0x05cb:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "name: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r48;
        r1 = r46;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x05e7:
        r0 = r31;
        r1 = r46;
        r0.add(r1);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x05ee:
        r43 = 0;
        r39 = r34;
        goto L_0x05a9;
    L_0x05f3:
        r0 = r31;
        r0 = r0.size;	 Catch:{ RuntimeException -> 0x0468 }
        r47 = r0;
        if (r47 <= 0) goto L_0x063d;
    L_0x05fb:
        r47 = r31.pop();	 Catch:{ RuntimeException -> 0x0468 }
        r47 = (java.lang.String) r47;	 Catch:{ RuntimeException -> 0x0468 }
        r30 = r47;
    L_0x0603:
        if (r43 == 0) goto L_0x06e1;
    L_0x0605:
        r47 = "true";
        r47 = r46.equals(r47);	 Catch:{ RuntimeException -> 0x0468 }
        if (r47 == 0) goto L_0x0640;
    L_0x060d:
        if (r24 == 0) goto L_0x0631;
    L_0x060f:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "boolean: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "=true";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x0631:
        r47 = 1;
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.bool(r1, r2);	 Catch:{ RuntimeException -> 0x0468 }
        goto L_0x05ee;
    L_0x063d:
        r30 = 0;
        goto L_0x0603;
    L_0x0640:
        r47 = "false";
        r47 = r46.equals(r47);	 Catch:{ RuntimeException -> 0x0468 }
        if (r47 == 0) goto L_0x0679;
    L_0x0648:
        if (r24 == 0) goto L_0x066c;
    L_0x064a:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "boolean: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "=false";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x066c:
        r47 = 0;
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.bool(r1, r2);	 Catch:{ RuntimeException -> 0x0468 }
        goto L_0x05ee;
    L_0x0679:
        r47 = "null";
        r47 = r46.equals(r47);	 Catch:{ RuntimeException -> 0x0468 }
        if (r47 == 0) goto L_0x068e;
    L_0x0681:
        r47 = 0;
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.string(r1, r2);	 Catch:{ RuntimeException -> 0x0468 }
        goto L_0x05ee;
    L_0x068e:
        r21 = 0;
        r22 = 1;
        r28 = r39;
    L_0x0694:
        r0 = r28;
        r1 = r34;
        if (r0 >= r1) goto L_0x06a3;
    L_0x069a:
        r47 = r53[r28];	 Catch:{ RuntimeException -> 0x0468 }
        switch(r47) {
            case 43: goto L_0x071c;
            case 45: goto L_0x071c;
            case 46: goto L_0x0718;
            case 48: goto L_0x071c;
            case 49: goto L_0x071c;
            case 50: goto L_0x071c;
            case 51: goto L_0x071c;
            case 52: goto L_0x071c;
            case 53: goto L_0x071c;
            case 54: goto L_0x071c;
            case 55: goto L_0x071c;
            case 56: goto L_0x071c;
            case 57: goto L_0x071c;
            case 69: goto L_0x0718;
            case 101: goto L_0x0718;
            default: goto L_0x069f;
        };
    L_0x069f:
        r21 = 0;
        r22 = 0;
    L_0x06a3:
        if (r21 == 0) goto L_0x0720;
    L_0x06a5:
        if (r24 == 0) goto L_0x06d1;
    L_0x06a7:
        r47 = java.lang.System.out;	 Catch:{ NumberFormatException -> 0x06e0 }
        r48 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x06e0 }
        r48.<init>();	 Catch:{ NumberFormatException -> 0x06e0 }
        r49 = "double: ";
        r48 = r48.append(r49);	 Catch:{ NumberFormatException -> 0x06e0 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ NumberFormatException -> 0x06e0 }
        r49 = "=";
        r48 = r48.append(r49);	 Catch:{ NumberFormatException -> 0x06e0 }
        r49 = java.lang.Double.parseDouble(r46);	 Catch:{ NumberFormatException -> 0x06e0 }
        r48 = r48.append(r49);	 Catch:{ NumberFormatException -> 0x06e0 }
        r48 = r48.toString();	 Catch:{ NumberFormatException -> 0x06e0 }
        r47.println(r48);	 Catch:{ NumberFormatException -> 0x06e0 }
    L_0x06d1:
        r47 = java.lang.Double.parseDouble(r46);	 Catch:{ NumberFormatException -> 0x06e0 }
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.number(r1, r2);	 Catch:{ NumberFormatException -> 0x06e0 }
        goto L_0x05ee;
    L_0x06e0:
        r47 = move-exception;
    L_0x06e1:
        if (r24 == 0) goto L_0x070d;
    L_0x06e3:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "string: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "=";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r48;
        r1 = r46;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x070d:
        r0 = r52;
        r1 = r30;
        r2 = r46;
        r0.string(r1, r2);	 Catch:{ RuntimeException -> 0x0468 }
        goto L_0x05ee;
    L_0x0718:
        r21 = 1;
        r22 = 0;
    L_0x071c:
        r28 = r28 + 1;
        goto L_0x0694;
    L_0x0720:
        if (r22 == 0) goto L_0x06e1;
    L_0x0722:
        if (r24 == 0) goto L_0x074e;
    L_0x0724:
        r47 = java.lang.System.out;	 Catch:{ RuntimeException -> 0x0468 }
        r48 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0468 }
        r48.<init>();	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "double: ";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r0 = r48;
        r1 = r30;
        r48 = r0.append(r1);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = "=";
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r49 = java.lang.Double.parseDouble(r46);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.append(r49);	 Catch:{ RuntimeException -> 0x0468 }
        r48 = r48.toString();	 Catch:{ RuntimeException -> 0x0468 }
        r47.println(r48);	 Catch:{ RuntimeException -> 0x0468 }
    L_0x074e:
        r47 = java.lang.Long.parseLong(r46);	 Catch:{ NumberFormatException -> 0x075d }
        r0 = r52;
        r1 = r30;
        r2 = r47;
        r0.number(r1, r2);	 Catch:{ NumberFormatException -> 0x075d }
        goto L_0x05ee;
    L_0x075d:
        r47 = move-exception;
        goto L_0x06e1;
    L_0x075f:
        r47 = new com.badlogic.gdx.utils.SerializationException;
        r48 = new java.lang.StringBuilder;
        r48.<init>();
        r49 = "Error parsing JSON on line ";
        r48 = r48.append(r49);
        r0 = r48;
        r1 = r29;
        r48 = r0.append(r1);
        r49 = " near: ";
        r48 = r48.append(r49);
        r49 = new java.lang.String;
        r50 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r51 = r37 - r34;
        r50 = java.lang.Math.min(r50, r51);
        r0 = r49;
        r1 = r53;
        r2 = r34;
        r3 = r50;
        r0.<init>(r1, r2, r3);
        r48 = r48.append(r49);
        r48 = r48.toString();
        r0 = r47;
        r1 = r48;
        r2 = r36;
        r0.<init>(r1, r2);
        throw r47;
    L_0x07a1:
        r0 = r52;
        r0 = r0.elements;
        r47 = r0;
        r0 = r47;
        r0 = r0.size;
        r47 = r0;
        if (r47 == 0) goto L_0x07dc;
    L_0x07af:
        r0 = r52;
        r0 = r0.elements;
        r47 = r0;
        r25 = r47.peek();
        r25 = (com.badlogic.gdx.utils.JsonValue) r25;
        r0 = r52;
        r0 = r0.elements;
        r47 = r0;
        r47.clear();
        if (r25 == 0) goto L_0x07d4;
    L_0x07c6:
        r47 = r25.isObject();
        if (r47 == 0) goto L_0x07d4;
    L_0x07cc:
        r47 = new com.badlogic.gdx.utils.SerializationException;
        r48 = "Error parsing JSON, unmatched brace.";
        r47.<init>(r48);
        throw r47;
    L_0x07d4:
        r47 = new com.badlogic.gdx.utils.SerializationException;
        r48 = "Error parsing JSON, unmatched bracket.";
        r47.<init>(r48);
        throw r47;
    L_0x07dc:
        if (r36 == 0) goto L_0x0806;
    L_0x07de:
        r47 = new com.badlogic.gdx.utils.SerializationException;
        r48 = new java.lang.StringBuilder;
        r48.<init>();
        r49 = "Error parsing JSON: ";
        r48 = r48.append(r49);
        r49 = new java.lang.String;
        r0 = r49;
        r1 = r53;
        r0.<init>(r1);
        r48 = r48.append(r49);
        r48 = r48.toString();
        r0 = r47;
        r1 = r48;
        r2 = r36;
        r0.<init>(r1, r2);
        throw r47;
    L_0x0806:
        return r38;
    L_0x0807:
        r27 = move-exception;
        r34 = r35;
        goto L_0x01dc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.JsonReader.parse(char[], int, int):com.badlogic.gdx.utils.JsonValue");
    }

    private static byte[] init__json_actions_0() {
        return new byte[]{(byte) 0, (byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 1, (byte) 3, (byte) 1, (byte) 4, (byte) 1, (byte) 5, (byte) 1, (byte) 6, (byte) 1, (byte) 7, (byte) 1, (byte) 8, (byte) 2, (byte) 0, (byte) 7, (byte) 2, (byte) 0, (byte) 8, (byte) 2, (byte) 1, (byte) 3, (byte) 2, (byte) 1, (byte) 5};
    }

    private static short[] init__json_key_offsets_0() {
        return new short[]{(short) 0, (short) 0, (short) 11, (short) 13, (short) 14, (short) 16, (short) 25, (short) 31, (short) 37, (short) 39, (short) 50, (short) 57, (short) 64, (short) 73, (short) 74, (short) 83, (short) 85, (short) 87, (short) 96, (short) 98, (short) 100, (short) 101, (short) 103, (short) 105, (short) 116, (short) 123, (short) 130, (short) 141, (short) 142, (short) 153, (short) 155, (short) 157, (short) 168, (short) 170, (short) 172, (short) 174, (short) 179, (short) 184, (short) 184};
    }

    private static char[] init__json_trans_keys_0() {
        return new char[]{'\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '\"', '*', '/', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', '}', '\t', '\n', '\r', ' ', ',', '/', '}', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '\"', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\"', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', ']', '\t', '\n', '\r', ' ', ',', '/', ']', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\"', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '\"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '*', '/', '\r', ' ', '/', '\t', '\n', '\r', ' ', '/', '\t', '\n', '\u0000'};
    }

    private static byte[] init__json_single_lengths_0() {
        return new byte[]{(byte) 0, (byte) 9, (byte) 2, (byte) 1, (byte) 2, (byte) 7, (byte) 4, (byte) 4, (byte) 2, (byte) 9, (byte) 7, (byte) 7, (byte) 7, (byte) 1, (byte) 7, (byte) 2, (byte) 2, (byte) 7, (byte) 2, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 9, (byte) 7, (byte) 7, (byte) 9, (byte) 1, (byte) 9, (byte) 2, (byte) 2, (byte) 9, (byte) 2, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 0, (byte) 0};
    }

    private static byte[] init__json_range_lengths_0() {
        return new byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 0, (byte) 0};
    }

    private static short[] init__json_index_offsets_0() {
        return new short[]{(short) 0, (short) 0, (short) 11, (short) 14, (short) 16, (short) 19, (short) 28, (short) 34, (short) 40, (short) 43, (short) 54, (short) 62, (short) 70, (short) 79, (short) 81, (short) 90, (short) 93, (short) 96, (short) 105, (short) 108, (short) 111, (short) 113, (short) 116, (short) 119, (short) 130, (short) 138, (short) 146, (short) 157, (short) 159, (short) 170, (short) 173, (short) 176, (short) 187, (short) 190, (short) 193, (short) 196, (short) 201, (short) 206, (short) 207};
    }

    private static byte[] init__json_indicies_0() {
        return new byte[]{(byte) 1, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 3, (byte) 5, (byte) 3, (byte) 6, (byte) 1, (byte) 0, (byte) 7, (byte) 7, (byte) 3, (byte) 8, (byte) 3, (byte) 9, (byte) 9, (byte) 3, (byte) 11, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 3, (byte) 15, (byte) 11, (byte) 10, (byte) 16, (byte) 16, (byte) 17, (byte) 18, (byte) 16, (byte) 3, (byte) 19, (byte) 19, (byte) 20, (byte) 21, (byte) 19, (byte) 3, (byte) 22, (byte) 22, (byte) 3, (byte) 21, (byte) 21, (byte) 24, (byte) 3, (byte) 25, (byte) 3, (byte) 26, (byte) 3, (byte) 27, (byte) 21, (byte) 23, (byte) 28, (byte) 29, (byte) 28, (byte) 28, (byte) 30, (byte) 31, (byte) 32, (byte) 3, (byte) 33, (byte) 34, (byte) 33, (byte) 33, (byte) 13, (byte) 35, (byte) 15, (byte) 3, (byte) 34, (byte) 34, (byte) 12, (byte) 36, (byte) 37, (byte) 3, (byte) 15, (byte) 34, (byte) 10, (byte) 16, (byte) 3, (byte) 36, (byte) 36, (byte) 12, (byte) 3, (byte) 38, (byte) 3, (byte) 3, (byte) 36, (byte) 10, (byte) 39, (byte) 39, (byte) 3, (byte) 40, (byte) 40, (byte) 3, (byte) 13, (byte) 13, (byte) 12, (byte) 3, (byte) 41, (byte) 3, (byte) 15, (byte) 13, (byte) 10, (byte) 42, (byte) 42, (byte) 3, (byte) 43, (byte) 43, (byte) 3, (byte) 28, (byte) 3, (byte) 44, (byte) 44, (byte) 3, (byte) 45, (byte) 45, (byte) 3, (byte) 47, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 3, (byte) 51, (byte) 52, (byte) 53, (byte) 47, (byte) 46, (byte) 54, (byte) 55, (byte) 54, (byte) 54, (byte) 56, (byte) 57, (byte) 58, (byte) 3, (byte) 59, (byte) 60, (byte) 59, (byte) 59, (byte) 49, (byte) 61, (byte) 52, (byte) 3, (byte) 60, (byte) 60, (byte) 48, (byte) 62, (byte) 63, (byte) 3, (byte) 51, (byte) 52, (byte) 53, (byte) 60, (byte) 46, (byte) 54, (byte) 3, (byte) 62, (byte) 62, (byte) 48, (byte) 3, (byte) 64, (byte) 3, (byte) 51, (byte) 3, (byte) 53, (byte) 62, (byte) 46, (byte) 65, (byte) 65, (byte) 3, (byte) 66, (byte) 66, (byte) 3, (byte) 49, (byte) 49, (byte) 48, (byte) 3, (byte) 67, (byte) 3, (byte) 51, (byte) 52, (byte) 53, (byte) 49, (byte) 46, (byte) 68, (byte) 68, (byte) 3, (byte) 69, (byte) 69, (byte) 3, (byte) 70, (byte) 70, (byte) 3, (byte) 8, (byte) 8, (byte) 71, (byte) 8, (byte) 3, (byte) 72, (byte) 72, (byte) 73, (byte) 72, (byte) 3, (byte) 3, (byte) 3, (byte) 0};
    }

    private static byte[] init__json_trans_targs_0() {
        return new byte[]{(byte) 35, (byte) 1, (byte) 3, (byte) 0, (byte) 4, (byte) 36, (byte) 36, (byte) 36, (byte) 36, (byte) 1, (byte) 6, (byte) 5, (byte) 13, (byte) 17, (byte) 22, (byte) 37, (byte) 7, (byte) 8, (byte) 9, (byte) 7, (byte) 8, (byte) 9, (byte) 7, (byte) 10, (byte) 20, (byte) 21, (byte) 11, (byte) 11, (byte) 11, (byte) 12, (byte) 17, (byte) 19, (byte) 37, (byte) 11, (byte) 12, (byte) 19, (byte) 14, (byte) 16, (byte) 15, (byte) 14, (byte) 12, (byte) 18, (byte) 17, (byte) 11, (byte) 9, (byte) 5, (byte) 24, (byte) 23, (byte) 27, (byte) 31, (byte) 34, (byte) 25, (byte) 38, (byte) 25, (byte) 25, (byte) 26, (byte) 31, (byte) 33, (byte) 38, (byte) 25, (byte) 26, (byte) 33, (byte) 28, (byte) 30, (byte) 29, (byte) 28, (byte) 26, (byte) 32, (byte) 31, (byte) 25, (byte) 23, (byte) 2, (byte) 36, (byte) 2};
    }

    private static byte[] init__json_trans_actions_0() {
        return new byte[]{(byte) 13, (byte) 0, (byte) 15, (byte) 0, (byte) 0, (byte) 7, (byte) 3, (byte) 11, (byte) 1, (byte) 11, (byte) 17, (byte) 0, (byte) 20, (byte) 0, (byte) 0, (byte) 5, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 11, (byte) 13, (byte) 15, (byte) 0, (byte) 7, (byte) 3, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 23, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 11, (byte) 11, (byte) 0, (byte) 11, (byte) 11, (byte) 11, (byte) 11, (byte) 13, (byte) 0, (byte) 15, (byte) 0, (byte) 0, (byte) 7, (byte) 9, (byte) 3, (byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 26, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 11, (byte) 11, (byte) 0, (byte) 11, (byte) 11, (byte) 11, (byte) 1, (byte) 0, (byte) 0};
    }

    private static byte[] init__json_eof_actions_0() {
        return new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0};
    }

    private void addChild(String name, JsonValue child) {
        child.setName(name);
        if (this.current == null) {
            this.current = child;
            this.root = child;
        } else if (this.current.isArray() || this.current.isObject()) {
            if (this.current.size == 0) {
                this.current.child = child;
            } else {
                JsonValue last = (JsonValue) this.lastChild.pop();
                last.next = child;
                child.prev = last;
            }
            this.lastChild.add(child);
            JsonValue jsonValue = this.current;
            jsonValue.size++;
        } else {
            this.root = this.current;
        }
    }

    protected void startObject(String name) {
        JsonValue value = new JsonValue(ValueType.object);
        if (this.current != null) {
            addChild(name, value);
        }
        this.elements.add(value);
        this.current = value;
    }

    protected void startArray(String name) {
        JsonValue value = new JsonValue(ValueType.array);
        if (this.current != null) {
            addChild(name, value);
        }
        this.elements.add(value);
        this.current = value;
    }

    protected void pop() {
        this.root = (JsonValue) this.elements.pop();
        if (this.current.size > 0) {
            this.lastChild.pop();
        }
        this.current = this.elements.size > 0 ? (JsonValue) this.elements.peek() : null;
    }

    protected void string(String name, String value) {
        addChild(name, new JsonValue(value));
    }

    protected void number(String name, double value) {
        addChild(name, new JsonValue(value));
    }

    protected void number(String name, long value) {
        addChild(name, new JsonValue(value));
    }

    protected void bool(String name, boolean value) {
        addChild(name, new JsonValue(value));
    }

    private String unescape(String value) {
        int i;
        int length = value.length();
        StringBuilder buffer = new StringBuilder(length + 16);
        int i2 = 0;
        while (i2 < length) {
            i = i2 + 1;
            char c = value.charAt(i2);
            if (c != '\\') {
                buffer.append(c);
                i2 = i;
            } else if (i == length) {
                return buffer.toString();
            } else {
                i2 = i + 1;
                c = value.charAt(i);
                if (c == 'u') {
                    buffer.append(Character.toChars(Integer.parseInt(value.substring(i2, i2 + 4), 16)));
                    i2 += 4;
                } else {
                    switch (c) {
                        case Keys.f10F /*34*/:
                        case Keys.f23S /*47*/:
                        case Keys.PAGE_UP /*92*/:
                            break;
                        case Keys.BUTTON_C /*98*/:
                            c = '\b';
                            break;
                        case 'f':
                            c = '\f';
                            break;
                        case Keys.BUTTON_MODE /*110*/:
                            c = '\n';
                            break;
                        case 'r':
                            c = '\r';
                            break;
                        case 't':
                            c = '\t';
                            break;
                        default:
                            throw new SerializationException("Illegal escaped character: \\" + c);
                    }
                    buffer.append(c);
                }
            }
        }
        i = i2;
        return buffer.toString();
    }
}
