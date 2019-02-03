package br.com.leonardo.core.util

//
//  ActivityNavigationHelper
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-31.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

const val PACKAGE_NAME = "br.com.leonardo"
sealed class AddressableActivity(val className: String)

object UnplashSettings : AddressableActivity(className = "$PACKAGE_NAME.unplash.UnplashSettingsActivity")
