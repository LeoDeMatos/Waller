package br.com.leonardo.waller.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lbr/com/leonardo/waller/di/AppModule;", "", "app", "Lbr/com/leonardo/waller/App;", "(Lbr/com/leonardo/waller/App;)V", "getApp", "()Lbr/com/leonardo/waller/App;", "providesApplication", "providesApplicationContext", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    private final br.com.leonardo.waller.App app = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final br.com.leonardo.waller.App providesApplication() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final android.content.Context providesApplicationContext(@org.jetbrains.annotations.NotNull()
    br.com.leonardo.waller.App app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.leonardo.waller.App getApp() {
        return null;
    }
    
    public AppModule(@org.jetbrains.annotations.NotNull()
    br.com.leonardo.waller.App app) {
        super();
    }
}