package br.com.leonardo.waller.di.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lbr/com/leonardo/waller/di/module/RepositoryModule;", "", "()V", "providesUnplashRepository", "Lbr/com/leonardo/waller/model/dataManager/UnplashRepository;", "app_debug"})
@dagger.Module()
public final class RepositoryModule {
    public static final br.com.leonardo.waller.di.module.RepositoryModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final br.com.leonardo.waller.model.dataManager.UnplashRepository providesUnplashRepository() {
        return null;
    }
    
    private RepositoryModule() {
        super();
    }
}