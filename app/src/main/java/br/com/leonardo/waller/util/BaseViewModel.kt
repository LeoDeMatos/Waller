package br.com.leonardo.waller.util

import br.com.leonardo.core.di.network.NetworkModule
import br.com.leonardo.core.util.LMViewModel
import br.com.leonardo.waller.App
import br.com.leonardo.waller.di.DaggerViewModelInjector
import br.com.leonardo.waller.di.ViewModelInjector
import br.com.leonardo.waller.di.module.RepositoryModule
import br.com.leonardo.waller.presenter.MainWallViewModel

//
//  BaseViewModel
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-31.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//
/*
*
* private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
*
* */
open class BaseViewModel : LMViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule(App.appContext))
        .repositoryModule(RepositoryModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainWallViewModel -> injector.inject(this)
        }
    }
}