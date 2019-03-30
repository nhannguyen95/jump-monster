package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.C0189c.C0573a;

/* renamed from: com.google.android.gms.dynamic.b */
public final class C0925b extends C0573a {
    private Fragment Hv;

    private C0925b(Fragment fragment) {
        this.Hv = fragment;
    }

    /* renamed from: a */
    public static C0925b m2692a(Fragment fragment) {
        return fragment != null ? new C0925b(fragment) : null;
    }

    /* renamed from: b */
    public void mo1165b(C0190d c0190d) {
        this.Hv.registerForContextMenu((View) C0926e.m2695d(c0190d));
    }

    /* renamed from: c */
    public void mo1166c(C0190d c0190d) {
        this.Hv.unregisterForContextMenu((View) C0926e.m2695d(c0190d));
    }

    public C0190d fX() {
        return C0926e.m2696h(this.Hv.getActivity());
    }

    public C0189c fY() {
        return C0925b.m2692a(this.Hv.getParentFragment());
    }

    public C0190d fZ() {
        return C0926e.m2696h(this.Hv.getResources());
    }

    public C0189c ga() {
        return C0925b.m2692a(this.Hv.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Hv.getArguments();
    }

    public int getId() {
        return this.Hv.getId();
    }

    public boolean getRetainInstance() {
        return this.Hv.getRetainInstance();
    }

    public String getTag() {
        return this.Hv.getTag();
    }

    public int getTargetRequestCode() {
        return this.Hv.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Hv.getUserVisibleHint();
    }

    public C0190d getView() {
        return C0926e.m2696h(this.Hv.getView());
    }

    public boolean isAdded() {
        return this.Hv.isAdded();
    }

    public boolean isDetached() {
        return this.Hv.isDetached();
    }

    public boolean isHidden() {
        return this.Hv.isHidden();
    }

    public boolean isInLayout() {
        return this.Hv.isInLayout();
    }

    public boolean isRemoving() {
        return this.Hv.isRemoving();
    }

    public boolean isResumed() {
        return this.Hv.isResumed();
    }

    public boolean isVisible() {
        return this.Hv.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Hv.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Hv.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Hv.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Hv.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Hv.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Hv.startActivityForResult(intent, requestCode);
    }
}
