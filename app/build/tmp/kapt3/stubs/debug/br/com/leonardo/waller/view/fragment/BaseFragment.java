package br.com.leonardo.waller.view.fragment;

import java.lang.System;

/**
 * * Created by Leonardo on 22/10/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lbr/com/leonardo/waller/view/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "bindView", "", "configureView", "configureViewModel", "onStart", "app_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public android.view.ViewGroup mRootView;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.ViewGroup getMRootView() {
        return null;
    }
    
    public final void setMRootView(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup p0) {
    }
    
    public abstract void configureViewModel();
    
    public abstract void configureView();
    
    public abstract void bindView();
    
    @java.lang.Override()
    public void onStart() {
    }
    
    public BaseFragment() {
        super();
    }
}