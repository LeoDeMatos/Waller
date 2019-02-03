package br.com.leonardo.waller.di

import br.com.leonardo.core.di.network.NetworkModule
import br.com.leonardo.waller.di.module.RepositoryModule
import br.com.leonardo.waller.presenter.MainWallViewModel
import dagger.Component
import javax.inject.Singleton

//
//  ViewModelInjector
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-31.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface ViewModelInjector {

    fun inject(viewModel: MainWallViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }
}