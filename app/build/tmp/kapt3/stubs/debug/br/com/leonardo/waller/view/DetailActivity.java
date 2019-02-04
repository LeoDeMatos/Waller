package br.com.leonardo.waller.view;

import java.lang.System;

/**
 * * Created by Leonardo de Matos on 09/04/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0012\u0010&\u001a\u00020\u001d2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u001dH\u0014J+\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u000201H\u0016\u00a2\u0006\u0002\u00102J\b\u00103\u001a\u00020\u001dH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lbr/com/leonardo/waller/view/DetailActivity;", "Landroid/app/Activity;", "()V", "isSave", "", "isWifiOn", "()Z", "mDownloadContainer", "Landroid/widget/FrameLayout;", "mFavoriteButton", "Lcom/like/LikeButton;", "mLoadedBitmap", "Landroid/graphics/Bitmap;", "mMainImageView", "Lcom/github/chrisbanes/photoview/PhotoView;", "getMMainImageView", "()Lcom/github/chrisbanes/photoview/PhotoView;", "mMainImageView$delegate", "Lkotlin/Lazy;", "mPhoto", "Lbr/com/leonardo/core/model/Photo;", "mUserImageView", "Landroid/widget/ImageView;", "getMUserImageView", "()Landroid/widget/ImageView;", "mUserImageView$delegate", "presenter", "Lbr/com/leonardo/waller/presenter/WLRWallDetailPresenter;", "applyImageZoom", "", "bindUnplashPhoto", "bindUser", "checkPermissions", "checkWifi", "configureView", "download", "handleLoading", "isLoading", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "ImageDownloadCallback", "app_debug"})
public final class DetailActivity extends android.app.Activity {
    private br.com.leonardo.core.model.Photo mPhoto;
    private android.graphics.Bitmap mLoadedBitmap;
    private boolean isSave;
    private final kotlin.Lazy mMainImageView$delegate = null;
    private final kotlin.Lazy mUserImageView$delegate = null;
    private com.like.LikeButton mFavoriteButton;
    private android.widget.FrameLayout mDownloadContainer;
    private final br.com.leonardo.waller.presenter.WLRWallDetailPresenter presenter = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.github.chrisbanes.photoview.PhotoView getMMainImageView() {
        return null;
    }
    
    private final android.widget.ImageView getMUserImageView() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    private final void configureView() {
    }
    
    private final void handleLoading(boolean isLoading) {
    }
    
    private final void bindUnplashPhoto() {
    }
    
    private final void applyImageZoom() {
    }
    
    private final void bindUser() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void checkWifi() {
    }
    
    private final void checkPermissions() {
    }
    
    private final void download(boolean isSave) {
    }
    
    private final boolean isWifiOn() {
        return false;
    }
    
    public DetailActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lbr/com/leonardo/waller/view/DetailActivity$ImageDownloadCallback;", "", "onFinish", "", "app_debug"})
    public static abstract interface ImageDownloadCallback {
        
        public abstract void onFinish();
    }
}