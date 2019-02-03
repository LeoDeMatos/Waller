package br.com.leonardo.waller.di.injector

import br.com.leonardo.core.di.network.NetworkModule
import br.com.leonardo.waller.model.dataManager.UnplashRepository
import dagger.Component
import javax.inject.Singleton

//
//  RepositoryInjector
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

@Singleton
@Component(modules = [NetworkModule::class])
interface RepositoryInjector {

    fun inject(baseRepository: UnplashRepository)

    @Component.Builder
    interface Builder {
        fun build(): RepositoryInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}