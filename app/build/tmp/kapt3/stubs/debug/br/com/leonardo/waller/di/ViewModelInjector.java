package br.com.leonardo.waller.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lbr/com/leonardo/waller/di/ViewModelInjector;", "", "inject", "", "viewModel", "Lbr/com/leonardo/waller/presenter/MainWallViewModel;", "Builder", "app_debug"})
@dagger.Component(modules = {br.com.leonardo.core.di.network.NetworkModule.class, br.com.leonardo.waller.di.module.RepositoryModule.class})
@javax.inject.Singleton()
public abstract interface ViewModelInjector {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    br.com.leonardo.waller.presenter.MainWallViewModel viewModel);
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lbr/com/leonardo/waller/di/ViewModelInjector$Builder;", "", "build", "Lbr/com/leonardo/waller/di/ViewModelInjector;", "networkModule", "Lbr/com/leonardo/core/di/network/NetworkModule;", "repositoryModule", "Lbr/com/leonardo/waller/di/module/RepositoryModule;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        public abstract br.com.leonardo.waller.di.ViewModelInjector build();
        
        @org.jetbrains.annotations.NotNull()
        public abstract br.com.leonardo.waller.di.ViewModelInjector.Builder networkModule(@org.jetbrains.annotations.NotNull()
        br.com.leonardo.core.di.network.NetworkModule networkModule);
        
        @org.jetbrains.annotations.NotNull()
        public abstract br.com.leonardo.waller.di.ViewModelInjector.Builder repositoryModule(@org.jetbrains.annotations.NotNull()
        br.com.leonardo.waller.di.module.RepositoryModule repositoryModule);
    }
}