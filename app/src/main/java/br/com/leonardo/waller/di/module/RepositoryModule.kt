package br.com.leonardo.waller.di.module

import br.com.leonardo.waller.model.dataManager.UnplashRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//
//  RepositoryModule
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun providesUnplashRepository(): UnplashRepository {
        return UnplashRepository()
    }
}