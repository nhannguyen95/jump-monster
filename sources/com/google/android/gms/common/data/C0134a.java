package com.google.android.gms.common.data;

import com.google.android.gms.internal.fq;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.a */
public final class C0134a<T> implements Iterator<T> {
    private int BC = -1;
    private final DataBuffer<T> mDataBuffer;

    public C0134a(DataBuffer<T> dataBuffer) {
        this.mDataBuffer = (DataBuffer) fq.m986f(dataBuffer);
    }

    public boolean hasNext() {
        return this.BC < this.mDataBuffer.getCount() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.mDataBuffer;
            int i = this.BC + 1;
            this.BC = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.BC);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
