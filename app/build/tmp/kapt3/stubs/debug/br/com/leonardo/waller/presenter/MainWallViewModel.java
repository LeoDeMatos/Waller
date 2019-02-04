package br.com.leonardo.waller.presenter;

import java.lang.System;

/**
 * * Created by Leonardo de Matos on 29/04/17.
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u001c\u001dB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lbr/com/leonardo/waller/presenter/MainWallViewModel;", "Lbr/com/leonardo/waller/util/BaseViewModel;", "Lbr/com/leonardo/core/LMRecyclerViewDataSource;", "Lbr/com/leonardo/waller/presenter/MainWallViewModel$WallListItem;", "()V", "disposeBag", "Lio/reactivex/disposables/CompositeDisposable;", "listItems", "", "paginator", "Lbr/com/leonardo/core/util/Paginator;", "photos", "Lbr/com/leonardo/core/model/Photo;", "unplashRepository", "Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;", "getUnplashRepository", "()Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;", "setUnplashRepository", "(Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;)V", "fetchPhotos", "", "getItemCount", "", "getItemFor", "position", "getViewTypeFor", "init", "loadNextPage", "ViewType", "WallListItem", "app_debug"})
public final class MainWallViewModel extends br.com.leonardo.waller.util.BaseViewModel implements br.com.leonardo.core.LMRecyclerViewDataSource<br.com.leonardo.waller.presenter.MainWallViewModel.WallListItem> {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public br.com.leonardo.waller.model.dataManager.UnplashRepository unplashRepository;
    private java.util.List<br.com.leonardo.waller.presenter.MainWallViewModel.WallListItem> listItems;
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
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public br.com.leonardo.waller.presenter.MainWallViewModel.WallListItem getItemFor(int position) {
        return null;
    }
    
    @java.lang.Override()
    public int getViewTypeFor(int position) {
        return 0;
    }
    
    public MainWallViewModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType;", "", "rawViewType", "", "(I)V", "getRawViewType", "()I", "Header", "Photo", "Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType$Header;", "Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType$Photo;", "app_debug"})
    public static abstract class ViewType {
        private final int rawViewType = 0;
        
        public final int getRawViewType() {
            return 0;
        }
        
        private ViewType(int rawViewType) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType$Header;", "Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType;", "()V", "app_debug"})
        public static final class Header extends br.com.leonardo.waller.presenter.MainWallViewModel.ViewType {
            public static final br.com.leonardo.waller.presenter.MainWallViewModel.ViewType.Header INSTANCE = null;
            
            private Header() {
                super(0);
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType$Photo;", "Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType;", "()V", "app_debug"})
        public static final class Photo extends br.com.leonardo.waller.presenter.MainWallViewModel.ViewType {
            public static final br.com.leonardo.waller.presenter.MainWallViewModel.ViewType.Photo INSTANCE = null;
            
            private Photo() {
                super(0);
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lbr/com/leonardo/waller/presenter/MainWallViewModel$WallListItem;", "", "viewType", "Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType;", "photo", "Lbr/com/leonardo/core/model/Photo;", "(Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType;Lbr/com/leonardo/core/model/Photo;)V", "getPhoto", "()Lbr/com/leonardo/core/model/Photo;", "getViewType", "()Lbr/com/leonardo/waller/presenter/MainWallViewModel$ViewType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class WallListItem {
        @org.jetbrains.annotations.NotNull()
        private final br.com.leonardo.waller.presenter.MainWallViewModel.ViewType viewType = null;
        @org.jetbrains.annotations.Nullable()
        private final br.com.leonardo.core.model.Photo photo = null;
        
        @org.jetbrains.annotations.NotNull()
        public final br.com.leonardo.waller.presenter.MainWallViewModel.ViewType getViewType() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final br.com.leonardo.core.model.Photo getPhoto() {
            return null;
        }
        
        public WallListItem(@org.jetbrains.annotations.NotNull()
        br.com.leonardo.waller.presenter.MainWallViewModel.ViewType viewType, @org.jetbrains.annotations.Nullable()
        br.com.leonardo.core.model.Photo photo) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final br.com.leonardo.waller.presenter.MainWallViewModel.ViewType component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final br.com.leonardo.core.model.Photo component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final br.com.leonardo.waller.presenter.MainWallViewModel.WallListItem copy(@org.jetbrains.annotations.NotNull()
        br.com.leonardo.waller.presenter.MainWallViewModel.ViewType viewType, @org.jetbrains.annotations.Nullable()
        br.com.leonardo.core.model.Photo photo) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}