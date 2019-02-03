package br.com.leonardo.waller.di

import android.content.Context
import br.com.leonardo.waller.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//
//  AppModule
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-21.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun providesApplication(): App = app

    @Provides
    @Singleton
    fun providesApplicationContext(app: App): Context {
        return app.applicationContext
    }
}