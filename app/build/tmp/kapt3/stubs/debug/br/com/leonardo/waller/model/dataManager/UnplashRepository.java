package br.com.leonardo.waller.model.dataManager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;", "Lbr/com/leonardo/waller/util/BaseRepository;", "()V", "unplashAPI", "Lbr/com/leonardo/core/UnplashAPI;", "getUnplashAPI", "()Lbr/com/leonardo/core/UnplashAPI;", "setUnplashAPI", "(Lbr/com/leonardo/core/UnplashAPI;)V", "getPhotos", "Lio/reactivex/Single;", "", "Lbr/com/leonardo/core/model/Photo;", "paginator", "Lbr/com/leonardo/core/util/Paginator;", "app_debug"})
public final class UnplashRepository extends br.com.leonardo.waller.util.BaseRepository {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public br.com.leonardo.core.UnplashAPI unplashAPI;
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.leonardo.core.UnplashAPI getUnplashAPI() {
        return null;
    }
    
    public final void setUnplashAPI(@org.jetbrains.annotations.NotNull()
    br.com.leonardo.core.UnplashAPI p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<br.com.leonardo.core.model.Photo>> getPhotos(@org.jetbrains.annotations.NotNull()
    br.com.leonardo.core.util.Paginator paginator) {
        return null;
    }
    
    public UnplashRepository() {
        super();
    }
}