package br.com.leonardo.waller.view.fragment;

import java.lang.System;

/**
 * * Created by Leonardo on 22/10/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0018\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lbr/com/leonardo/waller/view/fragment/MainWallFragment;", "Lbr/com/leonardo/waller/view/fragment/BaseFragment;", "Lbr/com/leonardo/waller/view/WallView;", "()V", "viewModel", "Lbr/com/leonardo/waller/presenter/MainWallViewModel;", "bindView", "", "configureView", "configureViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPhotosLoaded", "photos", "", "Lbr/com/leonardo/core/model/Photo;", "onViewCreated", "view", "savePhotos", "", "Lbr/com/leonardo/waller/model/BaseWallModel;", "app_debug"})
public final class MainWallFragment extends br.com.leonardo.waller.view.fragment.BaseFragment implements br.com.leonardo.waller.view.WallView {
    private br.com.leonardo.waller.presenter.MainWallViewModel viewModel;
    
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