package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.k */
abstract class C0097k<T extends C0095j> {
    Context mContext;
    C0096a<T> sy;

    /* renamed from: com.google.android.gms.analytics.k$a */
    public interface C0096a<U extends C0095j> {
        /* renamed from: a */
        void mo1005a(String str, int i);

        /* renamed from: a */
        void mo1006a(String str, String str2);

        /* renamed from: b */
        void mo1007b(String str, String str2);

        /* renamed from: c */
        void mo1008c(String str, boolean z);

        U cg();
    }

    public C0097k(Context context, C0096a<T> c0096a) {
        this.mContext = context;
        this.sy = c0096a;
    }

    /* renamed from: a */
    private T m59a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.sy.mo1006a(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.sy.mo1007b(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.sy.mo1008c(r0, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                aa.m33w("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.sy.mo1005a(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                aa.m33w("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            aa.m33w("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            aa.m33w("Error parsing tracker configuration file: " + e4);
        }
        return this.sy.cg();
    }

    /* renamed from: p */
    public T m60p(int i) {
        try {
            return m59a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            aa.m36z("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
