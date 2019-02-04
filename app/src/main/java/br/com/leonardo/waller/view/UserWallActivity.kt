package br.com.leonardo.waller.view

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.model.User
import br.com.leonardo.waller.R
import br.com.leonardo.waller.presenter.MainWallViewModel
import br.com.leonardo.waller.view.adapter.UserWallAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.Gson

class UserWallActivity : AppCompatActivity(), WallView {

    private lateinit var mList: RecyclerView
    private lateinit var mTotalLikes: TextView
    private lateinit var mTotalPhotos: TextView
    private lateinit var mTotalCollections: TextView

    private var mMainWallViewModel: MainWallViewModel? = null



    private val mUser: User by lazy {
        getUser()!!//TODO
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_wall)

        val w = window
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val statusViews = window.decorView
        statusViews.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        configureViews()

//        mMainWallViewModel = MainWallViewModel(this, this)
//        mMainWallViewModel!!.fetchPhotos(mUser.links.photos, false)
    }

    //MARK: View Config
    private fun configureViews() {
        mList = findViewById(R.id.user_wall_recycler_view)
        mTotalLikes = findViewById(R.id.user_total_likes)
        mTotalPhotos = findViewById(R.id.user_total_photos)
        mTotalCollections = findViewById(R.id.user_total_collections)

        mList.setHasFixedSize(true)

        val layoutManager = GridLayoutManager(this@UserWallActivity, 2, GridLayoutManager.VERTICAL, false)

        mList.layoutManager = layoutManager

        findViewById<View>(R.id.photos_container).setOnClickListener {
            mList.smoothScrollToPosition(0)
        }

        bindUser()
    }

    private fun bindUser() {
        val userImageView: ImageView = findViewById(R.id.user_image_view)
        val userNameTextView: TextView = findViewById(R.id.user_name_text_view)
        val userDescriptionTextView: TextView = findViewById(R.id.user_description_text_view)

        userNameTextView.text = mUser.name
        userDescriptionTextView.text = mUser.bio
        mTotalPhotos.text = mUser.total_photos.toString()
        mTotalLikes.text = mUser.total_likes.toString()
        mTotalCollections.text = mUser.total_collections.toString()

        Glide.with(this@UserWallActivity)
                .load(mUser.profile_image.large)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(userImageView)

    }

    //MARK: Data
    private fun getUser(): User? {
        intent.extras.getString(USER_EXTRA)?.let {
            return Gson().fromJson(it, User::class.java)
        }
        return null
    }

    //MARK: View Delegate
    override fun onPhotosLoaded(photos: MutableList<Photo>) {
        mList.let {
            if (it.adapter == null) {
                val adapter = UserWallAdapter(photos)
                it.adapter = adapter

            } else {
                (it.adapter as UserWallAdapter).addNewPage(photos)
            }

        }
    }

    //COMPANION
    companion object {
        val USER_EXTRA = "USER_EXTRA"
    }
}