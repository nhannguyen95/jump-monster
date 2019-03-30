package com.google.android.gms.tagmanager;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.net.HttpStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] Xp = "gtm.lifetime".toString().split("\\.");
    private static final Pattern Xq = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<C0370b, Integer> Xr;
    private final Map<String, Object> Xs;
    private final ReentrantLock Xt;
    private final LinkedList<Map<String, Object>> Xu;
    private final C0372c Xv;
    private final CountDownLatch Xw;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$a */
    static final class C0369a {
        public final String Xy;
        public final Object Xz;

        C0369a(String str, Object obj) {
            this.Xy = str;
            this.Xz = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C0369a)) {
                return false;
            }
            C0369a c0369a = (C0369a) o;
            return this.Xy.equals(c0369a.Xy) && this.Xz.equals(c0369a.Xz);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.Xy.hashCode()), Integer.valueOf(this.Xz.hashCode())});
        }

        public String toString() {
            return "Key: " + this.Xy + " value: " + this.Xz.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$b */
    interface C0370b {
        /* renamed from: y */
        void mo2236y(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$c */
    interface C0372c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer$c$a */
        public interface C0371a {
            /* renamed from: a */
            void mo2235a(List<C0369a> list);
        }

        /* renamed from: a */
        void mo2232a(C0371a c0371a);

        /* renamed from: a */
        void mo2233a(List<C0369a> list, long j);

        void bx(String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$1 */
    class C08111 implements C0372c {
        C08111() {
        }

        /* renamed from: a */
        public void mo2232a(C0371a c0371a) {
            c0371a.mo2235a(new ArrayList());
        }

        /* renamed from: a */
        public void mo2233a(List<C0369a> list, long j) {
        }

        public void bx(String str) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$2 */
    class C08122 implements C0371a {
        final /* synthetic */ DataLayer Xx;

        C08122(DataLayer dataLayer) {
            this.Xx = dataLayer;
        }

        /* renamed from: a */
        public void mo2235a(List<C0369a> list) {
            for (C0369a c0369a : list) {
                this.Xx.m1336A(this.Xx.m1349c(c0369a.Xy, c0369a.Xz));
            }
            this.Xx.Xw.countDown();
        }
    }

    DataLayer() {
        this(new C08111());
    }

    DataLayer(C0372c persistentStore) {
        this.Xv = persistentStore;
        this.Xr = new ConcurrentHashMap();
        this.Xs = new HashMap();
        this.Xt = new ReentrantLock();
        this.Xu = new LinkedList();
        this.Xw = new CountDownLatch(1);
        ko();
    }

    /* renamed from: A */
    private void m1336A(Map<String, Object> map) {
        this.Xt.lock();
        try {
            this.Xu.offer(map);
            if (this.Xt.getHoldCount() == 1) {
                kp();
            }
            m1337B(map);
        } finally {
            this.Xt.unlock();
        }
    }

    /* renamed from: B */
    private void m1337B(Map<String, Object> map) {
        Long C = m1338C(map);
        if (C != null) {
            List E = m1340E(map);
            E.remove("gtm.lifetime");
            this.Xv.mo2233a(E, C.longValue());
        }
    }

    /* renamed from: C */
    private Long m1338C(Map<String, Object> map) {
        Object D = m1339D(map);
        return D == null ? null : bw(D.toString());
    }

    /* renamed from: D */
    private Object m1339D(Map<String, Object> map) {
        String[] strArr = Xp;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    /* renamed from: E */
    private List<C0369a> m1340E(Map<String, Object> map) {
        Object arrayList = new ArrayList();
        m1345a(map, "", arrayList);
        return arrayList;
    }

    /* renamed from: F */
    private void m1341F(Map<String, Object> map) {
        synchronized (this.Xs) {
            for (String str : map.keySet()) {
                m1348a(m1349c(str, map.get(str)), this.Xs);
            }
        }
        m1342G(map);
    }

    /* renamed from: G */
    private void m1342G(Map<String, Object> map) {
        for (C0370b y : this.Xr.keySet()) {
            y.mo2236y(map);
        }
    }

    /* renamed from: a */
    private void m1345a(Map<String, Object> map, String str, Collection<C0369a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m1345a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C0369a(str2, entry.getValue()));
            }
        }
    }

    static Long bw(String str) {
        Matcher matcher = Xq.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.m1388z("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.m1386x("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case 'h':
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case Keys.BUTTON_SELECT /*109*/:
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.m1388z("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.m1386x("unknown _lifetime: " + str);
        return null;
    }

    private void ko() {
        this.Xv.mo2232a(new C08122(this));
    }

    private void kp() {
        int i = 0;
        while (true) {
            Map map = (Map) this.Xu.poll();
            if (map != null) {
                m1341F(map);
                int i2 = i + 1;
                if (i2 > HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    this.Xu.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    public static List<Object> listOf(Object... objects) {
        List<Object> arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map<String, Object> hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    void m1346a(C0370b c0370b) {
        this.Xr.put(c0370b, Integer.valueOf(0));
    }

    /* renamed from: a */
    void m1347a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m1347a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m1348a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    /* renamed from: a */
    void m1348a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m1347a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m1348a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void bv(String str) {
        push(str, null);
        this.Xv.bx(str);
    }

    /* renamed from: c */
    Map<String, Object> m1349c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    public Object get(String key) {
        synchronized (this.Xs) {
            Map map = this.Xs;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(m1349c(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.Xw.await();
        } catch (InterruptedException e) {
            bh.m1388z("DataLayer.push: unexpected InterruptedException");
        }
        m1336A(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }
}
