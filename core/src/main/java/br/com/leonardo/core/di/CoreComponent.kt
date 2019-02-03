package br.com.leonardo.core.di

import android.app.Application
import br.com.leonardo.core.di.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

//
//  CoreComponent
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-26.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

@Singleton
@Component(modules = [NetworkModule::class])
interface CoreComponent {
    fun inject(application: Application)
}