package br.com.leonardo.core.util

import android.content.Context
import android.util.DisplayMetrics

//
//  DensityConverter
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

object DensityConverter {
    fun toDp(context: Context, pixel: Float): Float {
        return pixel / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun toPixel(context: Context, dp: Float): Float {
        return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }
}