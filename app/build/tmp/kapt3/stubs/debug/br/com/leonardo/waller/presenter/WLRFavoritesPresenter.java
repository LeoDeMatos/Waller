package br.com.leonardo.waller.presenter;

import java.lang.System;

/**
 * * Created by Leonardo de Matos on 29/04/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lbr/com/leonardo/waller/presenter/WLRFavoritesPresenter;", "", "context", "Landroid/content/Context;", "mView", "Lbr/com/leonardo/waller/presenter/view/WLRFavoritesView;", "(Landroid/content/Context;Lbr/com/leonardo/waller/presenter/view/WLRFavoritesView;)V", "getContext", "()Landroid/content/Context;", "dataManager", "Lbr/com/leonardo/waller/model/dataManager/WLRPhotosDataManager;", "favorites", "", "Lbr/com/leonardo/core/model/Photo;", "getFavorites", "()Ljava/util/List;", "setFavorites", "(Ljava/util/List;)V", "fetchFavorites", "", "app_debug"})
public final class WLRFavoritesPresenter {
    private final br.com.leonardo.waller.model.dataManager.WLRPhotosDataManager dataManager = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<br.com.leonardo.core.model.Photo> favorites;
    @org.jetbrains.annotations.Nullable()
    private final android.content.Context context = null;
    private final br.com.leonardo.waller.presenter.view.WLRFavoritesView mView = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<br.com.leonardo.core.model.Photo> getFavorites() {
        return null;
    }
    
    public final void setFavorites(@org.jetbrains.annotations.Nullable()
    java.util.List<br.com.leonardo.core.model.Photo> p0) {
    }
    
    public final void fetchFavorites() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getContext() {
        return null;
    }
    
    public WLRFavoritesPresenter(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    br.com.leonardo.waller.presenter.view.WLRFavoritesView mView) {
        super();
    }
}