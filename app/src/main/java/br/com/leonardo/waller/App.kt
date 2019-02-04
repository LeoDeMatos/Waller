package br.com.leonardo.waller

import android.app.Application
import android.content.Context
import br.com.leonardo.core.di.network.NetworkModule
import br.com.leonardo.waller.di.AppComponent
import br.com.leonardo.waller.di.AppModule
import br.com.leonardo.waller.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco

//
//  App
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-20.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()

        // Init
        Fresco.initialize(this)
        appContext = this
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule(this))
            .build()
    }
}