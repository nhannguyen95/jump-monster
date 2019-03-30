package com.google.android.gms.internal;

import android.os.Parcel;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C0655a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ih extends ga implements SafeParcelable, Person {
    public static final ii CREATOR = new ii();
    private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
    private String HA;
    private final Set<Integer> UJ;
    private String VH;
    private C0986a VI;
    private String VJ;
    private String VK;
    private int VL;
    private C0989b VM;
    private String VN;
    private C0990c VO;
    private boolean VP;
    private String VQ;
    private C0991d VR;
    private String VS;
    private int VT;
    private List<C0992f> VU;
    private List<C0993g> VV;
    private int VW;
    private int VX;
    private String VY;
    private List<C0994h> VZ;
    private boolean Wa;
    private int lZ;
    private String ro;
    private String wp;
    private final int xH;

    /* renamed from: com.google.android.gms.internal.ih$e */
    public static class C0289e {
        public static int bi(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$a */
    public static final class C0986a extends ga implements SafeParcelable, AgeRange {
        public static final ij CREATOR = new ij();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private int Wb;
        private int Wc;
        private final int xH;

        static {
            UI.put("max", C0655a.m2221g("max", 2));
            UI.put("min", C0655a.m2221g("min", 3));
        }

        public C0986a() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C0986a(Set<Integer> set, int i, int i2, int i3) {
            this.UJ = set;
            this.xH = i;
            this.Wb = i2;
            this.Wc = i3;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 2:
                    return Integer.valueOf(this.Wb);
                case 3:
                    return Integer.valueOf(this.Wc);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            ij ijVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0986a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0986a c0986a = (C0986a) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0986a.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0986a.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0986a.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jD();
        }

        public int getMax() {
            return this.Wb;
        }

        public int getMin() {
            return this.Wc;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasMax() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C0986a jD() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ij ijVar = CREATOR;
            ij.m1081a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$b */
    public static final class C0989b extends ga implements SafeParcelable, Cover {
        public static final ik CREATOR = new ik();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private C0987a Wd;
        private C0988b We;
        private int Wf;
        private final int xH;

        /* renamed from: com.google.android.gms.internal.ih$b$a */
        public static final class C0987a extends ga implements SafeParcelable, CoverInfo {
            public static final il CREATOR = new il();
            private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
            private final Set<Integer> UJ;
            private int Wg;
            private int Wh;
            private final int xH;

            static {
                UI.put("leftImageOffset", C0655a.m2221g("leftImageOffset", 2));
                UI.put("topImageOffset", C0655a.m2221g("topImageOffset", 3));
            }

            public C0987a() {
                this.xH = 1;
                this.UJ = new HashSet();
            }

            C0987a(Set<Integer> set, int i, int i2, int i3) {
                this.UJ = set;
                this.xH = i;
                this.Wg = i2;
                this.Wh = i3;
            }

            /* renamed from: a */
            protected boolean mo2914a(C0655a c0655a) {
                return this.UJ.contains(Integer.valueOf(c0655a.ff()));
            }

            protected Object aq(String str) {
                return null;
            }

            protected boolean ar(String str) {
                return false;
            }

            /* renamed from: b */
            protected Object mo2915b(C0655a c0655a) {
                switch (c0655a.ff()) {
                    case 2:
                        return Integer.valueOf(this.Wg);
                    case 3:
                        return Integer.valueOf(this.Wh);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
                }
            }

            public int describeContents() {
                il ilVar = CREATOR;
                return 0;
            }

            public HashMap<String, C0655a<?, ?>> eY() {
                return UI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0987a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0987a c0987a = (C0987a) obj;
                for (C0655a c0655a : UI.values()) {
                    if (mo2914a(c0655a)) {
                        if (!c0987a.mo2914a(c0655a)) {
                            return false;
                        }
                        if (!mo2915b(c0655a).equals(c0987a.mo2915b(c0655a))) {
                            return false;
                        }
                    } else if (c0987a.mo2914a(c0655a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return jH();
            }

            public int getLeftImageOffset() {
                return this.Wg;
            }

            public int getTopImageOffset() {
                return this.Wh;
            }

            int getVersionCode() {
                return this.xH;
            }

            public boolean hasLeftImageOffset() {
                return this.UJ.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.UJ.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C0655a c0655a : UI.values()) {
                    int hashCode;
                    if (mo2914a(c0655a)) {
                        hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C0987a jH() {
                return this;
            }

            Set<Integer> ja() {
                return this.UJ;
            }

            public void writeToParcel(Parcel out, int flags) {
                il ilVar = CREATOR;
                il.m1083a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ih$b$b */
        public static final class C0988b extends ga implements SafeParcelable, CoverPhoto {
            public static final im CREATOR = new im();
            private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
            private final Set<Integer> UJ;
            private int kr;
            private int ks;
            private String ro;
            private final int xH;

            static {
                UI.put("height", C0655a.m2221g("height", 2));
                UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0655a.m2224j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                UI.put("width", C0655a.m2221g("width", 4));
            }

            public C0988b() {
                this.xH = 1;
                this.UJ = new HashSet();
            }

            C0988b(Set<Integer> set, int i, int i2, String str, int i3) {
                this.UJ = set;
                this.xH = i;
                this.ks = i2;
                this.ro = str;
                this.kr = i3;
            }

            /* renamed from: a */
            protected boolean mo2914a(C0655a c0655a) {
                return this.UJ.contains(Integer.valueOf(c0655a.ff()));
            }

            protected Object aq(String str) {
                return null;
            }

            protected boolean ar(String str) {
                return false;
            }

            /* renamed from: b */
            protected Object mo2915b(C0655a c0655a) {
                switch (c0655a.ff()) {
                    case 2:
                        return Integer.valueOf(this.ks);
                    case 3:
                        return this.ro;
                    case 4:
                        return Integer.valueOf(this.kr);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
                }
            }

            public int describeContents() {
                im imVar = CREATOR;
                return 0;
            }

            public HashMap<String, C0655a<?, ?>> eY() {
                return UI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C0988b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0988b c0988b = (C0988b) obj;
                for (C0655a c0655a : UI.values()) {
                    if (mo2914a(c0655a)) {
                        if (!c0988b.mo2914a(c0655a)) {
                            return false;
                        }
                        if (!mo2915b(c0655a).equals(c0988b.mo2915b(c0655a))) {
                            return false;
                        }
                    } else if (c0988b.mo2914a(c0655a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return jI();
            }

            public int getHeight() {
                return this.ks;
            }

            public String getUrl() {
                return this.ro;
            }

            int getVersionCode() {
                return this.xH;
            }

            public int getWidth() {
                return this.kr;
            }

            public boolean hasHeight() {
                return this.UJ.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.UJ.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.UJ.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C0655a c0655a : UI.values()) {
                    int hashCode;
                    if (mo2914a(c0655a)) {
                        hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                    } else {
                        hashCode = i;
                    }
                    i = hashCode;
                }
                return i;
            }

            public boolean isDataValid() {
                return true;
            }

            public C0988b jI() {
                return this;
            }

            Set<Integer> ja() {
                return this.UJ;
            }

            public void writeToParcel(Parcel out, int flags) {
                im imVar = CREATOR;
                im.m1084a(this, out, flags);
            }
        }

        static {
            UI.put("coverInfo", C0655a.m2218a("coverInfo", 2, C0987a.class));
            UI.put("coverPhoto", C0655a.m2218a("coverPhoto", 3, C0988b.class));
            UI.put("layout", C0655a.m2217a("layout", 4, new fx().m2215f("banner", 0), false));
        }

        public C0989b() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C0989b(Set<Integer> set, int i, C0987a c0987a, C0988b c0988b, int i2) {
            this.UJ = set;
            this.xH = i;
            this.Wd = c0987a;
            this.We = c0988b;
            this.Wf = i2;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 2:
                    return this.Wd;
                case 3:
                    return this.We;
                case 4:
                    return Integer.valueOf(this.Wf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            ik ikVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0989b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0989b c0989b = (C0989b) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0989b.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0989b.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0989b.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jG();
        }

        public CoverInfo getCoverInfo() {
            return this.Wd;
        }

        public CoverPhoto getCoverPhoto() {
            return this.We;
        }

        public int getLayout() {
            return this.Wf;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasCoverInfo() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        C0987a jE() {
            return this.Wd;
        }

        C0988b jF() {
            return this.We;
        }

        public C0989b jG() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ik ikVar = CREATOR;
            ik.m1082a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$c */
    public static final class C0990c extends ga implements SafeParcelable, Image {
        public static final in CREATOR = new in();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private String ro;
        private final int xH;

        static {
            UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0655a.m2224j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C0990c() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        public C0990c(String str) {
            this.UJ = new HashSet();
            this.xH = 1;
            this.ro = str;
            this.UJ.add(Integer.valueOf(2));
        }

        C0990c(Set<Integer> set, int i, String str) {
            this.UJ = set;
            this.xH = i;
            this.ro = str;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 2:
                    return this.ro;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            in inVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0990c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0990c c0990c = (C0990c) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0990c.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0990c.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0990c.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jJ();
        }

        public String getUrl() {
            return this.ro;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasUrl() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C0990c jJ() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            in inVar = CREATOR;
            in.m1085a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$d */
    public static final class C0991d extends ga implements SafeParcelable, Name {
        public static final io CREATOR = new io();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private String Vh;
        private String Vk;
        private String Wi;
        private String Wj;
        private String Wk;
        private String Wl;
        private final int xH;

        static {
            UI.put("familyName", C0655a.m2224j("familyName", 2));
            UI.put("formatted", C0655a.m2224j("formatted", 3));
            UI.put("givenName", C0655a.m2224j("givenName", 4));
            UI.put("honorificPrefix", C0655a.m2224j("honorificPrefix", 5));
            UI.put("honorificSuffix", C0655a.m2224j("honorificSuffix", 6));
            UI.put("middleName", C0655a.m2224j("middleName", 7));
        }

        public C0991d() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C0991d(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.UJ = set;
            this.xH = i;
            this.Vh = str;
            this.Wi = str2;
            this.Vk = str3;
            this.Wj = str4;
            this.Wk = str5;
            this.Wl = str6;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 2:
                    return this.Vh;
                case 3:
                    return this.Wi;
                case 4:
                    return this.Vk;
                case 5:
                    return this.Wj;
                case 6:
                    return this.Wk;
                case 7:
                    return this.Wl;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            io ioVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0991d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0991d c0991d = (C0991d) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0991d.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0991d.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0991d.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jK();
        }

        public String getFamilyName() {
            return this.Vh;
        }

        public String getFormatted() {
            return this.Wi;
        }

        public String getGivenName() {
            return this.Vk;
        }

        public String getHonorificPrefix() {
            return this.Wj;
        }

        public String getHonorificSuffix() {
            return this.Wk;
        }

        public String getMiddleName() {
            return this.Wl;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasFamilyName() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.UJ.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public C0991d jK() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            io ioVar = CREATOR;
            io.m1086a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$f */
    public static final class C0992f extends ga implements SafeParcelable, Organizations {
        public static final ip CREATOR = new ip();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private String EB;
        private String HD;
        private int LF;
        private final Set<Integer> UJ;
        private String Vg;
        private String Vw;
        private String Wm;
        private String Wn;
        private boolean Wo;
        private String mName;
        private final int xH;

        static {
            UI.put("department", C0655a.m2224j("department", 2));
            UI.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0655a.m2224j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            UI.put("endDate", C0655a.m2224j("endDate", 4));
            UI.put("location", C0655a.m2224j("location", 5));
            UI.put("name", C0655a.m2224j("name", 6));
            UI.put("primary", C0655a.m2223i("primary", 7));
            UI.put("startDate", C0655a.m2224j("startDate", 8));
            UI.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C0655a.m2224j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            UI.put("type", C0655a.m2217a("type", 10, new fx().m2215f("work", 0).m2215f("school", 1), false));
        }

        public C0992f() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C0992f(Set<Integer> set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.UJ = set;
            this.xH = i;
            this.Wm = str;
            this.HD = str2;
            this.Vg = str3;
            this.Wn = str4;
            this.mName = str5;
            this.Wo = z;
            this.Vw = str6;
            this.EB = str7;
            this.LF = i2;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 2:
                    return this.Wm;
                case 3:
                    return this.HD;
                case 4:
                    return this.Vg;
                case 5:
                    return this.Wn;
                case 6:
                    return this.mName;
                case 7:
                    return Boolean.valueOf(this.Wo);
                case 8:
                    return this.Vw;
                case 9:
                    return this.EB;
                case 10:
                    return Integer.valueOf(this.LF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            ip ipVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0992f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0992f c0992f = (C0992f) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0992f.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0992f.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0992f.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jL();
        }

        public String getDepartment() {
            return this.Wm;
        }

        public String getDescription() {
            return this.HD;
        }

        public String getEndDate() {
            return this.Vg;
        }

        public String getLocation() {
            return this.Wn;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.Vw;
        }

        public String getTitle() {
            return this.EB;
        }

        public int getType() {
            return this.LF;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasDepartment() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.UJ.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.UJ.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.UJ.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.UJ.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Wo;
        }

        public C0992f jL() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ip ipVar = CREATOR;
            ip.m1087a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$g */
    public static final class C0993g extends ga implements SafeParcelable, PlacesLived {
        public static final iq CREATOR = new iq();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private final Set<Integer> UJ;
        private boolean Wo;
        private String mValue;
        private final int xH;

        static {
            UI.put("primary", C0655a.m2223i("primary", 2));
            UI.put("value", C0655a.m2224j("value", 3));
        }

        public C0993g() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C0993g(Set<Integer> set, int i, boolean z, String str) {
            this.UJ = set;
            this.xH = i;
            this.Wo = z;
            this.mValue = str;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 2:
                    return Boolean.valueOf(this.Wo);
                case 3:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            iq iqVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0993g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0993g c0993g = (C0993g) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0993g.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0993g.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0993g.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jM();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasPrimary() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        public boolean isPrimary() {
            return this.Wo;
        }

        public C0993g jM() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            iq iqVar = CREATOR;
            iq.m1088a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$h */
    public static final class C0994h extends ga implements SafeParcelable, Urls {
        public static final ir CREATOR = new ir();
        private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
        private int LF;
        private final Set<Integer> UJ;
        private String Wp;
        private final int Wq;
        private String mValue;
        private final int xH;

        static {
            UI.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C0655a.m2224j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            UI.put("type", C0655a.m2217a("type", 6, new fx().m2215f("home", 0).m2215f("work", 1).m2215f("blog", 2).m2215f(Scopes.PROFILE, 3).m2215f("other", 4).m2215f("otherProfile", 5).m2215f("contributor", 6).m2215f("website", 7), false));
            UI.put("value", C0655a.m2224j("value", 4));
        }

        public C0994h() {
            this.Wq = 4;
            this.xH = 2;
            this.UJ = new HashSet();
        }

        C0994h(Set<Integer> set, int i, String str, int i2, String str2, int i3) {
            this.Wq = 4;
            this.UJ = set;
            this.xH = i;
            this.Wp = str;
            this.LF = i2;
            this.mValue = str2;
        }

        /* renamed from: a */
        protected boolean mo2914a(C0655a c0655a) {
            return this.UJ.contains(Integer.valueOf(c0655a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        /* renamed from: b */
        protected Object mo2915b(C0655a c0655a) {
            switch (c0655a.ff()) {
                case 4:
                    return this.mValue;
                case 5:
                    return this.Wp;
                case 6:
                    return Integer.valueOf(this.LF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
            }
        }

        public int describeContents() {
            ir irVar = CREATOR;
            return 0;
        }

        public HashMap<String, C0655a<?, ?>> eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0994h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0994h c0994h = (C0994h) obj;
            for (C0655a c0655a : UI.values()) {
                if (mo2914a(c0655a)) {
                    if (!c0994h.mo2914a(c0655a)) {
                        return false;
                    }
                    if (!mo2915b(c0655a).equals(c0994h.mo2915b(c0655a))) {
                        return false;
                    }
                } else if (c0994h.mo2914a(c0655a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jO();
        }

        public String getLabel() {
            return this.Wp;
        }

        public int getType() {
            return this.LF;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasLabel() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C0655a c0655a : UI.values()) {
                int hashCode;
                if (mo2914a(c0655a)) {
                    hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
                } else {
                    hashCode = i;
                }
                i = hashCode;
            }
            return i;
        }

        public boolean isDataValid() {
            return true;
        }

        @Deprecated
        public int jN() {
            return 4;
        }

        public C0994h jO() {
            return this;
        }

        Set<Integer> ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ir irVar = CREATOR;
            ir.m1089a(this, out, flags);
        }
    }

    static {
        UI.put("aboutMe", C0655a.m2224j("aboutMe", 2));
        UI.put("ageRange", C0655a.m2218a("ageRange", 3, C0986a.class));
        UI.put("birthday", C0655a.m2224j("birthday", 4));
        UI.put("braggingRights", C0655a.m2224j("braggingRights", 5));
        UI.put("circledByCount", C0655a.m2221g("circledByCount", 6));
        UI.put("cover", C0655a.m2218a("cover", 7, C0989b.class));
        UI.put("currentLocation", C0655a.m2224j("currentLocation", 8));
        UI.put("displayName", C0655a.m2224j("displayName", 9));
        UI.put("gender", C0655a.m2217a("gender", 12, new fx().m2215f("male", 0).m2215f("female", 1).m2215f("other", 2), false));
        UI.put("id", C0655a.m2224j("id", 14));
        UI.put("image", C0655a.m2218a("image", 15, C0990c.class));
        UI.put("isPlusUser", C0655a.m2223i("isPlusUser", 16));
        UI.put("language", C0655a.m2224j("language", 18));
        UI.put("name", C0655a.m2218a("name", 19, C0991d.class));
        UI.put("nickname", C0655a.m2224j("nickname", 20));
        UI.put("objectType", C0655a.m2217a("objectType", 21, new fx().m2215f("person", 0).m2215f("page", 1), false));
        UI.put("organizations", C0655a.m2219b("organizations", 22, C0992f.class));
        UI.put("placesLived", C0655a.m2219b("placesLived", 23, C0993g.class));
        UI.put("plusOneCount", C0655a.m2221g("plusOneCount", 24));
        UI.put("relationshipStatus", C0655a.m2217a("relationshipStatus", 25, new fx().m2215f("single", 0).m2215f("in_a_relationship", 1).m2215f("engaged", 2).m2215f("married", 3).m2215f("its_complicated", 4).m2215f("open_relationship", 5).m2215f("widowed", 6).m2215f("in_domestic_partnership", 7).m2215f("in_civil_union", 8), false));
        UI.put("tagline", C0655a.m2224j("tagline", 26));
        UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0655a.m2224j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        UI.put("urls", C0655a.m2219b("urls", 28, C0994h.class));
        UI.put("verified", C0655a.m2223i("verified", 29));
    }

    public ih() {
        this.xH = 2;
        this.UJ = new HashSet();
    }

    public ih(String str, String str2, C0990c c0990c, int i, String str3) {
        this.xH = 2;
        this.UJ = new HashSet();
        this.HA = str;
        this.UJ.add(Integer.valueOf(9));
        this.wp = str2;
        this.UJ.add(Integer.valueOf(14));
        this.VO = c0990c;
        this.UJ.add(Integer.valueOf(15));
        this.VT = i;
        this.UJ.add(Integer.valueOf(21));
        this.ro = str3;
        this.UJ.add(Integer.valueOf(27));
    }

    ih(Set<Integer> set, int i, String str, C0986a c0986a, String str2, String str3, int i2, C0989b c0989b, String str4, String str5, int i3, String str6, C0990c c0990c, boolean z, String str7, C0991d c0991d, String str8, int i4, List<C0992f> list, List<C0993g> list2, int i5, int i6, String str9, String str10, List<C0994h> list3, boolean z2) {
        this.UJ = set;
        this.xH = i;
        this.VH = str;
        this.VI = c0986a;
        this.VJ = str2;
        this.VK = str3;
        this.VL = i2;
        this.VM = c0989b;
        this.VN = str4;
        this.HA = str5;
        this.lZ = i3;
        this.wp = str6;
        this.VO = c0990c;
        this.VP = z;
        this.VQ = str7;
        this.VR = c0991d;
        this.VS = str8;
        this.VT = i4;
        this.VU = list;
        this.VV = list2;
        this.VW = i5;
        this.VX = i6;
        this.VY = str9;
        this.ro = str10;
        this.VZ = list3;
        this.Wa = z2;
    }

    /* renamed from: i */
    public static ih m3098i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ih aN = CREATOR.aN(obtain);
        obtain.recycle();
        return aN;
    }

    /* renamed from: a */
    protected boolean mo2914a(C0655a c0655a) {
        return this.UJ.contains(Integer.valueOf(c0655a.ff()));
    }

    protected Object aq(String str) {
        return null;
    }

    protected boolean ar(String str) {
        return false;
    }

    /* renamed from: b */
    protected Object mo2915b(C0655a c0655a) {
        switch (c0655a.ff()) {
            case 2:
                return this.VH;
            case 3:
                return this.VI;
            case 4:
                return this.VJ;
            case 5:
                return this.VK;
            case 6:
                return Integer.valueOf(this.VL);
            case 7:
                return this.VM;
            case 8:
                return this.VN;
            case 9:
                return this.HA;
            case 12:
                return Integer.valueOf(this.lZ);
            case 14:
                return this.wp;
            case 15:
                return this.VO;
            case 16:
                return Boolean.valueOf(this.VP);
            case 18:
                return this.VQ;
            case 19:
                return this.VR;
            case 20:
                return this.VS;
            case 21:
                return Integer.valueOf(this.VT);
            case 22:
                return this.VU;
            case 23:
                return this.VV;
            case 24:
                return Integer.valueOf(this.VW);
            case Keys.VOLUME_DOWN /*25*/:
                return Integer.valueOf(this.VX);
            case Keys.POWER /*26*/:
                return this.VY;
            case Keys.CAMERA /*27*/:
                return this.ro;
            case Keys.CLEAR /*28*/:
                return this.VZ;
            case Keys.f5A /*29*/:
                return Boolean.valueOf(this.Wa);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
        }
    }

    public int describeContents() {
        ii iiVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0655a<?, ?>> eY() {
        return UI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ih)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ih ihVar = (ih) obj;
        for (C0655a c0655a : UI.values()) {
            if (mo2914a(c0655a)) {
                if (!ihVar.mo2914a(c0655a)) {
                    return false;
                }
                if (!mo2915b(c0655a).equals(ihVar.mo2915b(c0655a))) {
                    return false;
                }
            } else if (ihVar.mo2914a(c0655a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return jC();
    }

    public String getAboutMe() {
        return this.VH;
    }

    public AgeRange getAgeRange() {
        return this.VI;
    }

    public String getBirthday() {
        return this.VJ;
    }

    public String getBraggingRights() {
        return this.VK;
    }

    public int getCircledByCount() {
        return this.VL;
    }

    public Cover getCover() {
        return this.VM;
    }

    public String getCurrentLocation() {
        return this.VN;
    }

    public String getDisplayName() {
        return this.HA;
    }

    public int getGender() {
        return this.lZ;
    }

    public String getId() {
        return this.wp;
    }

    public Image getImage() {
        return this.VO;
    }

    public String getLanguage() {
        return this.VQ;
    }

    public Name getName() {
        return this.VR;
    }

    public String getNickname() {
        return this.VS;
    }

    public int getObjectType() {
        return this.VT;
    }

    public List<Organizations> getOrganizations() {
        return (ArrayList) this.VU;
    }

    public List<PlacesLived> getPlacesLived() {
        return (ArrayList) this.VV;
    }

    public int getPlusOneCount() {
        return this.VW;
    }

    public int getRelationshipStatus() {
        return this.VX;
    }

    public String getTagline() {
        return this.VY;
    }

    public String getUrl() {
        return this.ro;
    }

    public List<Urls> getUrls() {
        return (ArrayList) this.VZ;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasAboutMe() {
        return this.UJ.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.UJ.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.UJ.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.UJ.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.UJ.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.UJ.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.UJ.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.UJ.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.UJ.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.UJ.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.UJ.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.UJ.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.UJ.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.UJ.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.UJ.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.UJ.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.UJ.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.UJ.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.UJ.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.UJ.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.UJ.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.UJ.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.UJ.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.UJ.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C0655a c0655a : UI.values()) {
            int hashCode;
            if (mo2914a(c0655a)) {
                hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isPlusUser() {
        return this.VP;
    }

    public boolean isVerified() {
        return this.Wa;
    }

    List<C0993g> jA() {
        return this.VV;
    }

    List<C0994h> jB() {
        return this.VZ;
    }

    public ih jC() {
        return this;
    }

    Set<Integer> ja() {
        return this.UJ;
    }

    C0986a jv() {
        return this.VI;
    }

    C0989b jw() {
        return this.VM;
    }

    C0990c jx() {
        return this.VO;
    }

    C0991d jy() {
        return this.VR;
    }

    List<C0992f> jz() {
        return this.VU;
    }

    public void writeToParcel(Parcel out, int flags) {
        ii iiVar = CREATOR;
        ii.m1080a(this, out, flags);
    }
}
