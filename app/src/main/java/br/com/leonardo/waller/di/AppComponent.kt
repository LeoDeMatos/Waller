package br.com.leonardo.waller.di

import br.com.leonardo.core.di.network.NetworkModule
import br.com.leonardo.waller.view.WallActivity
import dagger.Component
import javax.inject.Singleton

//
//  AppComponent
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-21.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(wallActivity: WallActivity)
}