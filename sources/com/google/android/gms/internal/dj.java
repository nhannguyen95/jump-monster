package com.google.android.gms.internal;

import android.os.Bundle;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public class dj {
    private static final dj qJ = new dj();
    public static final String qK = qJ.qL;
    private final Object li = new Object();
    public final String qL = br();
    private final dk qM = new dk(this.qL);
    private BigInteger qN = BigInteger.ONE;
    private final HashSet<di> qO = new HashSet();
    private final HashMap<String, dm> qP = new HashMap();

    private dj() {
    }

    /* renamed from: a */
    public static Bundle m762a(dl dlVar, String str) {
        return qJ.m766b(dlVar, str);
    }

    /* renamed from: b */
    public static void m763b(HashSet<di> hashSet) {
        qJ.m767c(hashSet);
    }

    public static dj bq() {
        return qJ;
    }

    private static String br() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public static String bs() {
        return qJ.bt();
    }

    public static dk bu() {
        return qJ.bv();
    }

    /* renamed from: a */
    public void m764a(di diVar) {
        synchronized (this.li) {
            this.qO.add(diVar);
        }
    }

    /* renamed from: a */
    public void m765a(String str, dm dmVar) {
        synchronized (this.li) {
            this.qP.put(str, dmVar);
        }
    }

    /* renamed from: b */
    public Bundle m766b(dl dlVar, String str) {
        Bundle bundle;
        synchronized (this.li) {
            bundle = new Bundle();
            bundle.putBundle("app", this.qM.m769q(str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.qP.keySet()) {
                bundle2.putBundle(str2, ((dm) this.qP.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.qO.iterator();
            while (it.hasNext()) {
                arrayList.add(((di) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            dlVar.mo3163a(this.qO);
            this.qO.clear();
        }
        return bundle;
    }

    public String bt() {
        String bigInteger;
        synchronized (this.li) {
            bigInteger = this.qN.toString();
            this.qN = this.qN.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public dk bv() {
        dk dkVar;
        synchronized (this.li) {
            dkVar = this.qM;
        }
        return dkVar;
    }

    /* renamed from: c */
    public void m767c(HashSet<di> hashSet) {
        synchronized (this.li) {
            this.qO.addAll(hashSet);
        }
    }
}
