package br.com.leonardo.unplash

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

//
//  UnplashSettingsActivity
//  Waller
//
//  Created by Leonardo de Matos on 2019-01-30.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

class UnplashSettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = View(this)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT)
        view.setBackgroundColor(Color.MAGENTA)
        view.layoutParams = params

        setContentView(view)
    }
}
