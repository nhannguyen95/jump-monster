package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class bz {
    /* renamed from: a */
    public static boolean m679a(Context context, cb cbVar, ci ciVar) {
        if (cbVar == null) {
            dw.m824z("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(cbVar.nO)) {
            dw.m824z("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(cbVar.mimeType)) {
            intent.setData(Uri.parse(cbVar.nO));
        } else {
            intent.setDataAndType(Uri.parse(cbVar.nO), cbVar.mimeType);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(cbVar.packageName)) {
            intent.setPackage(cbVar.packageName);
        }
        if (!TextUtils.isEmpty(cbVar.nP)) {
            String[] split = cbVar.nP.split("/", 2);
            if (split.length < 2) {
                dw.m824z("Could not parse component name from open GMSG: " + cbVar.nP);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            dw.m823y("Launching an intent: " + intent);
            context.startActivity(intent);
            ciVar.mo3155U();
            return true;
        } catch (ActivityNotFoundException e) {
            dw.m824z(e.getMessage());
            return false;
        }
    }
}
