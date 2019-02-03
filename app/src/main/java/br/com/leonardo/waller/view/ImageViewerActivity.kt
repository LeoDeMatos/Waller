package br.com.leonardo.waller.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import br.com.leonardo.waller.R
import br.com.leonardo.core.model.Photo
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson

/**
 * Created by Leonardo on 03/10/17.
 */
class ImageViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        intent.extras.getString(IMAGE_URL)?.let {
            val photo = Gson().fromJson(it, Photo::class.java)
            val imageView = findViewById<ImageView>(R.id.image_view)
            Glide.with(this)
                    .load(photo.urls.regular)
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView)

            findViewById<View>(R.id.close_button).setOnClickListener {
                onBackPressed()
            }
        }

    }

    companion object {
        val IMAGE_URL = "IMAGE_URL"
    }
}