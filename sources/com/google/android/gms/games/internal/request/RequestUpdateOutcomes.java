package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] LN = new String[]{"requestId", "outcome"};
    private final int Ah;
    private final HashMap<String, Integer> LO;

    public static final class Builder {
        private int Ah = 0;
        private HashMap<String, Integer> LO = new HashMap();

        public Builder bm(int i) {
            this.Ah = i;
            return this;
        }

        public RequestUpdateOutcomes hB() {
            return new RequestUpdateOutcomes(this.Ah, this.LO);
        }

        /* renamed from: s */
        public Builder m573s(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.LO.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.Ah = statusCode;
        this.LO = outcomeMap;
    }

    /* renamed from: J */
    public static RequestUpdateOutcomes m574J(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.bm(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int G = dataHolder.m1681G(i);
            builder.m573s(dataHolder.getString("requestId", i, G), dataHolder.getInteger("outcome", i, G));
        }
        return builder.hB();
    }

    public Set<String> getRequestIds() {
        return this.LO.keySet();
    }

    public int getRequestOutcome(String requestId) {
        fq.m985b(this.LO.containsKey(requestId), "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.LO.get(requestId)).intValue();
    }
}
