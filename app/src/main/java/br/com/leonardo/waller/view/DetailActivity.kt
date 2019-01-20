package br.com.leonardo.waller.view

import android.Manifest
import android.app.Activity
import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomSheetBehavior
import android.transition.TransitionManager
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import br.com.leonardo.waller.ImageDownloadTask
import br.com.leonardo.waller.R
import br.com.leonardo.waller.model.Photo
import br.com.leonardo.waller.presenter.WLRWallDetailPresenter
import br.com.leonardo.waller.util.ColorUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.github.chrisbanes.photoview.PhotoView
import com.google.gson.Gson
import com.like.LikeButton
import com.like.OnLikeListener

/**
 * Created by Leonardo de Matos on 09/04/17.
 */

class DetailActivity : Activity() {

    private var mPhoto: Photo? = null
    private var mLoadedBitmap: Bitmap? = null
    private var isSave: Boolean = false

    private val mMainImageView: PhotoView by lazy {
        findViewById<PhotoView>(R.id.image)
    }
    private val mUserImageView: ImageView by lazy {
        findViewById<ImageView>(R.id.profile_image)
    }

    private lateinit var mFavoriteButton: LikeButton
    private lateinit var mDownloadContainer: FrameLayout

    private val presenter = WLRWallDetailPresenter()

    //MARK: Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        configureView()

        mPhoto = Gson().fromJson(intent.extras.getString("urls"), Photo::class.java)
        if (mPhoto != null) {
            bindUnplashPhoto()
        } else {
            this.finishAfterTransition()
        }

    }

    override fun onResume() {
        super.onResume()
        val w = window
        w.navigationBarColor = Color.BLACK
    }

    override fun onPause() {
        super.onPause()
        window.navigationBarColor = Color.TRANSPARENT
    }

    //MARK: View Binding
    private fun configureView() {
        mFavoriteButton = findViewById(R.id.favorite_button)
        mDownloadContainer = findViewById(R.id.download_container)

        val bottomView = findViewById<View>(R.id.bottom_sheet)
        val bottomSheet = BottomSheetBehavior.from<View>(bottomView)
        bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED

        val measurement = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90f, resources.displayMetrics)
        bottomView.y = bottomView.y + measurement
        bottomView.animate().translationY(bottomView.y - measurement)
                .duration = 1000

        mFavoriteButton.setOnClickListener { view ->
            mPhoto?.let {
                view.isSelected = !view.isSelected
                presenter.savePhotoToFavorites(this@DetailActivity, it)
            }
        }

        mDownloadContainer.setOnClickListener {
            isSave = false
            checkPermissions()
        }

        mFavoriteButton.setOnLikeListener(object: OnLikeListener{
            override fun liked(p0: LikeButton?) {

            }

            override fun unLiked(p0: LikeButton?) {
            }
        })

//        findViewById<View>(R.id.download_wallpaper).setOnClickListener {
//            isSave = true
//            checkWifi()
//        }
    }

    private fun handleLoading(isLoading: Boolean) {
        val loading = mDownloadContainer.getChildAt(0)
        val icon = mDownloadContainer.getChildAt(1)

        loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        icon.visibility = if (isLoading) View.GONE else View.VISIBLE
        TransitionManager.beginDelayedTransition(mDownloadContainer)
    }

    //MARK: Data flow
    private fun bindUnplashPhoto() {

        bindUser()

        Glide.with(this)
                .load(mPhoto!!.urls.regular)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(object : SimpleTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                        mMainImageView.setImageBitmap(resource)
                        applyImageZoom()
                        mLoadedBitmap = resource
                        ColorUtil.extractColor(mLoadedBitmap, { palette ->
                            val colorContainer = findViewById<ViewGroup>(R.id.color_container)
                            ColorUtil.presentColors(this@DetailActivity, colorContainer = colorContainer, palette = palette)
                        })
                    }
                })

    }

    private fun applyImageZoom() {
        Handler().postDelayed({
            mPhoto?.let {
                val factor: Float = if (it.width < it.height) 1.2f else 2.5f
                mMainImageView.setScale(factor, true)
            }
        }, 500)
    }

    private fun bindUser() {
        Glide.with(this)
                .load(mPhoto!!.user.profile_image.large)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mUserImageView)

        mUserImageView.setOnClickListener {
            val intent = Intent(this@DetailActivity, UserWallActivity::class.java)
            intent.putExtra(UserWallActivity.USER_EXTRA, Gson().toJson(mPhoto!!.user))

            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this, it,
                            "profile_target").toBundle())

        }

        (findViewById<TextView>(R.id.user_name) as TextView).text = mPhoto!!.user.name
        (findViewById<TextView>(R.id.username) as TextView).text = "@" + mPhoto!!.user.username

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        checkPermissions()
    }

    //MARK: Utils
    private fun checkWifi() {
        if (!isWifiOn) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Atenção")
            builder.setMessage("Você está no 3G deseja continuar o download?")
            builder.setCancelable(true)
            builder.setPositiveButton("DOWNLOAD") { _, _ -> checkPermissions() }
            builder.setNegativeButton("CANCELAR") { _, _ -> }
            builder.show()
        } else {
            checkPermissions()
        }
    }

    private fun checkPermissions() {
        val permissionCheckStorage = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
        val permissionCheckWriteStorage = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permissionCheckStorage != PackageManager.PERMISSION_GRANTED || permissionCheckWriteStorage != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    10)
        } else {
            download(isSave)
        }
    }

    private fun download(isSave: Boolean) {
        handleLoading(true)
        Glide.with(this@DetailActivity)
                .load(mPhoto!!.urls.raw)
                .asBitmap()
                .into(object : SimpleTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {

                        val downloadTask = ImageDownloadTask(this@DetailActivity, resource, isSave, object : ImageDownloadCallback {
                            override fun onFinish() {
                                handleLoading(false)
                            }
                        })
                        downloadTask.execute()
                    }
                })
    }


    private val isWifiOn: Boolean
        get() {
            val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            return mWifi.isConnected
        }

    interface ImageDownloadCallback {
        fun onFinish()
    }
}


