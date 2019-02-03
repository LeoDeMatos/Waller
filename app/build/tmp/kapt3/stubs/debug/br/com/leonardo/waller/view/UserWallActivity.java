package br.com.leonardo.waller.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lbr/com/leonardo/waller/view/UserWallActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lbr/com/leonardo/waller/view/WallView;", "()V", "mList", "Landroidx/recyclerview/widget/RecyclerView;", "mMainWallViewModel", "Lbr/com/leonardo/waller/presenter/MainWallViewModel;", "mTotalCollections", "Landroid/widget/TextView;", "mTotalLikes", "mTotalPhotos", "mUser", "Lbr/com/leonardo/core/model/User;", "getMUser", "()Lbr/com/leonardo/core/model/User;", "mUser$delegate", "Lkotlin/Lazy;", "bindUser", "", "configureViews", "getUser", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPhotosLoaded", "photos", "", "Lbr/com/leonardo/core/model/Photo;", "Companion", "app_debug"})
public final class UserWallActivity extends androidx.appcompat.app.AppCompatActivity implements br.com.leonardo.waller.view.WallView {
    private androidx.recyclerview.widget.RecyclerView mList;
    private android.widget.TextView mTotalLikes;
    private android.widget.TextView mTotalPhotos;
    private android.widget.TextView mTotalCollections;
    private br.com.leonardo.waller.presenter.MainWallViewModel mMainWallViewModel;
    private final kotlin.Lazy mUser$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String USER_EXTRA = "USER_EXTRA";
    public static final br.com.leonardo.waller.view.UserWallActivity.Companion Companion = null;
    
    private final br.com.leonardo.core.model.User getMUser() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void configureViews() {
    }
    
    private final void bindUser() {
    }
    
    private final br.com.leonardo.core.model.User getUser() {
        return null;
    }
    
    @java.lang.Override()
    public void onPhotosLoaded(@org.jetbrains.annotations.NotNull()
    java.util.List<br.com.leonardo.core.model.Photo> photos) {
    }
    
    public UserWallActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lbr/com/leonardo/waller/view/UserWallActivity$Companion;", "", "()V", "USER_EXTRA", "", "getUSER_EXTRA", "()Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUSER_EXTRA() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}