package br.com.leonardo.waller.view.fragment;

import java.lang.System;

/**
 * * Created by Leonardo on 22/10/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u001b\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lbr/com/leonardo/waller/view/fragment/MainWallFragment;", "Lbr/com/leonardo/waller/view/fragment/BaseFragment;", "Lbr/com/leonardo/waller/view/WallView;", "()V", "autoScroll", "", "viewModel", "Lbr/com/leonardo/waller/presenter/MainWallViewModel;", "bindView", "", "configureView", "configureViewModel", "isViewVisible", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPhotosLoaded", "photos", "", "Lbr/com/leonardo/core/model/Photo;", "onViewCreated", "savePhotos", "", "Lbr/com/leonardo/waller/model/BaseWallModel;", "app_debug"})
public final class MainWallFragment extends br.com.leonardo.waller.view.fragment.BaseFragment implements br.com.leonardo.waller.view.WallView {
    private br.com.leonardo.waller.presenter.MainWallViewModel viewModel;
    private boolean autoScroll;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void configureView() {
    }
    
    public final boolean isViewVisible(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        return false;
    }
    
    @java.lang.Override()
    public void configureViewModel() {
    }
    
    @java.lang.Override()
    public void bindView() {
    }
    
    private final void savePhotos(java.util.List<? extends br.com.leonardo.waller.model.BaseWallModel> photos) {
    }
    
    @java.lang.Override()
    public void onPhotosLoaded(@org.jetbrains.annotations.NotNull()
    java.util.List<br.com.leonardo.core.model.Photo> photos) {
    }
    
    public MainWallFragment() {
        super();
    }
}