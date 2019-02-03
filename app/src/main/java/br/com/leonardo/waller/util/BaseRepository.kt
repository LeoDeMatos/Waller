package br.com.leonardo.waller.util

import br.com.leonardo.core.di.network.NetworkModule
import br.com.leonardo.waller.App
import br.com.leonardo.waller.di.injector.DaggerRepositoryInjector
import br.com.leonardo.waller.di.injector.RepositoryInjector
import br.com.leonardo.waller.model.dataManager.UnplashRepository

//
//  BaseRepository
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

abstract class BaseRepository {
    private val injector: RepositoryInjector = DaggerRepositoryInjector
        .builder()
        .networkModule(NetworkModule(App.appContext))
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is UnplashRepository -> injector.inject(this)
        }
    }
}