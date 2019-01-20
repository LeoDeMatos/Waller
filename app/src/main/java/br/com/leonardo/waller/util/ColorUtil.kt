package br.com.leonardo.waller.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import br.com.leonardo.waller.R
import android.graphics.drawable.GradientDrawable
import android.R.attr.shape





/**
 * Created by Leonardo de Matos on 16/06/17.
 */

object ColorUtil {
    fun extractColor(bitmap: Bitmap?, completion: (palette: Palette) -> Unit) {
        if (bitmap != null && !bitmap.isRecycled) {
            Palette.from(bitmap).generate {
                completion(it)
            }
        }
    }

    fun presentColors(context: Context, colorContainer: ViewGroup, palette: Palette) {

        var view = TextView(context)

        val colorList = ArrayList<Int>()
        var color = palette.getLightVibrantColor(-1)
        if (color != -1) {
            view = createView(context, color)
            colorList.add(color)
            colorContainer.addView(view)
        }

        color = palette.getDominantColor(-1)
        if (color != -1 && !colorList.contains(color)) {
            colorList.add(color)
            view = createView(context,color)
            colorContainer.addView(view)
        }

        color = palette.getDarkMutedColor(-1)
        if (color != -1 && !colorList.contains(color)) {
            colorList.add(color)
            view = createView(context, color)
            colorContainer.addView(view)
        }
        color = palette.getDarkVibrantColor(-1)
        if (color != -1 && !colorList.contains(color)) {
            colorList.add(color)
            view = createView(context, color)
            colorContainer.addView(view)
        }

        color = palette.getLightMutedColor(-1)
        if (color != -1 && !colorList.contains(color)) {
            colorList.add(color)
            view = createView(context, color)
            colorContainer.addView(view)
        }

        color = palette.getVibrantColor(-1)
        if (color != -1 && !colorList.contains(color)) {
            colorList.add(color)
            view = createView(context, color)
            colorContainer.addView(view)
        }

        color = palette.getMutedColor(-1)
        if (color != -1 && !colorList.contains(color)) {
            colorList.add(color)
            view = createView(context, color)
            colorContainer.addView(view)
        }
        val estimatedWidth = colorContainer.width / colorContainer.childCount
        for (v in colorContainer.subviews()) {
            val params = LinearLayout.LayoutParams(estimatedWidth, 100)
            v.layoutParams = params
            if (v is TextView) {
                v.text = ""
            }
        }

        val firstVew = colorContainer.subviews().first()
        val fShape = firstVew.background as GradientDrawable
        fShape.cornerRadii = floatArrayOf(16f, 16f, 0f, 0f, 0f, 0f, 16f, 16f)


        val lastView = colorContainer.subviews().last()
        val lShape = lastView.background as GradientDrawable
        lShape.cornerRadii = floatArrayOf(0f, 0f, 16f, 16f, 16f, 15f, 0f, 0f)

    }

    private fun createView(context: Context,color: Int): TextView{
        val view = TextView(context)
        view.text = String.format("#%06X", 0xFFFFFF and color)
        val shape = GradientDrawable()
        shape.setColor(color)
        view.background = shape
        return view
    }

    fun ViewGroup.subviews(): MutableList<View> {
        var index = 0
        val subviews: MutableList<View> = ArrayList()
        while (index != childCount) {
            subviews.add(getChildAt(index))
            index++
        }
        return subviews
    }

}

