package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C0189c.C0573a;

/* renamed from: com.google.android.gms.dynamic.h */
public final class C0927h extends C0573a {
    private Fragment Hz;

    private C0927h(Fragment fragment) {
        this.Hz = fragment;
    }

    /* renamed from: a */
    public static C0927h m2697a(Fragment fragment) {
        return fragment != null ? new C0927h(fragment) : null;
    }

    /* renamed from: b */
    public void mo1165b(C0190d c0190d) {
        this.Hz.registerForContextMenu((View) C0926e.m2695d(c0190d));
    }

    /* renamed from: c */
    public void mo1166c(C0190d c0190d) {
        this.Hz.unregisterForContextMenu((View) C0926e.m2695d(c0190d));
    }

    public C0190d fX() {
        return C0926e.m2696h(this.Hz.getActivity());
    }

    public C0189c fY() {
        return C0927h.m2697a(this.Hz.getParentFragment());
    }

    public C0190d fZ() {
        return C0926e.m2696h(this.Hz.getResources());
    }

    public C0189c ga() {
        return C0927h.m2697a(this.Hz.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Hz.getArguments();
    }

    public int getId() {
        return this.Hz.getId();
    }

    public boolean getRetainInstance() {
        return this.Hz.getRetainInstance();
    }

    public String getTag() {
        return this.Hz.getTag();
    }

    public int getTargetRequestCode() {
        return this.Hz.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Hz.getUserVisibleHint();
    }

    public C0190d getView() {
        return C0926e.m2696h(this.Hz.getView());
    }

    public boolean isAdded() {
        return this.Hz.isAdded();
    }

    public boolean isDetached() {
        return this.Hz.isDetached();
    }

    public boolean isHidden() {
        return this.Hz.isHidden();
    }

    public boolean isInLayout() {
        return this.Hz.isInLayout();
    }

    public boolean isRemoving() {
        return this.Hz.isRemoving();
    }

    public boolean isResumed() {
        return this.Hz.isResumed();
    }

    public boolean isVisible() {
        return this.Hz.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Hz.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Hz.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Hz.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Hz.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Hz.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Hz.startActivityForResult(intent, requestCode);
    }
}
