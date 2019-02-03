package br.com.leonardo.waller.presenter;

import java.lang.System;

/**
 * * Created by Leonardo de Matos on 29/04/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lbr/com/leonardo/waller/presenter/MainWallViewModel;", "Lbr/com/leonardo/waller/util/BaseViewModel;", "()V", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "paginator", "Lbr/com/leonardo/core/util/Paginator;", "photos", "", "Lbr/com/leonardo/core/model/Photo;", "unplashRepository", "Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;", "getUnplashRepository", "()Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;", "setUnplashRepository", "(Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;)V", "fetchPhotos", "", "init", "loadNextPage", "app_debug"})
public final class MainWallViewModel extends br.com.leonardo.waller.util.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public br.com.leonardo.waller.model.dataManager.UnplashRepository unplashRepository;
    private java.util.List<br.com.leonardo.core.model.Photo> photos;
    private final br.com.leonardo.core.util.Paginator paginator = null;
    private final io.reactivex.disposables.CompositeDisposable disposeBag = null;
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.leonardo.waller.model.dataManager.UnplashRepository getUnplashRepository() {
        return null;
    }
    
    public final void setUnplashRepository(@org.jetbrains.annotations.NotNull()
    br.com.leonardo.waller.model.dataManager.UnplashRepository p0) {
    }
    
    public final void init() {
    }
    
    private final void fetchPhotos() {
    }
    
    public final void loadNextPage() {
    }
    
    public MainWallViewModel() {
        super();
    }
}