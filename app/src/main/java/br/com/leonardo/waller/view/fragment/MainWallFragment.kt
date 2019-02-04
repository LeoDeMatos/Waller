package br.com.leonardo.waller.view.fragment

import android.graphics.PointF
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.util.ViewModelState
import br.com.leonardo.waller.Preferences
import br.com.leonardo.waller.R
import br.com.leonardo.waller.WallAdapter
import br.com.leonardo.waller.model.BaseWallModel
import br.com.leonardo.waller.presenter.MainWallViewModel
import br.com.leonardo.waller.view.WallView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_main_wall.*


/**
 * Created by Leonardo on 22/10/17.
 */

class MainWallFragment : BaseFragment(), WallView {

    private lateinit var viewModel: MainWallViewModel
    private var autoScroll = true
    // MARK: - View Lifecycle
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_wall, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
        configureViewModel()
        bindView()
    }

    // MARK: - View configuration

    override fun configureView() {
        val staggeredGridLayoutManager = object : StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) {
            override fun smoothScrollToPosition(recyclerView: RecyclerView?, state: RecyclerView.State?, position: Int) {
                val linearSmoothScroller = object : LinearSmoothScroller(recyclerView?.context) {

                    override fun computeScrollVectorForPosition(targetPosition: Int): PointF? {
                        return super.computeScrollVectorForPosition(targetPosition)
                    }

                    override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                        return 500f / displayMetrics.densityDpi
                    }
                }

                linearSmoothScroller.targetPosition = position
                startSmoothScroll(linearSmoothScroller)
            }
        }
        mainWallRecyclerView.layoutManager = staggeredGridLayoutManager

        mainWallRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = recyclerView.layoutManager as StaggeredGridLayoutManager
                val visiblePositions = IntArray(2)
                manager.findFirstVisibleItemPositions(visiblePositions)
                visiblePositions.forEach { position ->
                    val view = manager.findViewByPosition(position) ?: return
                    val baseY = view.y.toFloat()
                    val workingY = baseY * 2

                    val percentage = (((workingY * 100f) / view.height) / 100f) + 1
                    view.scaleX = Math.min(percentage, 1f)
                    view.scaleY = Math.min(percentage, 1f)
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val manager = recyclerView.layoutManager as StaggeredGridLayoutManager
                val visiblePositions = IntArray(6)
                manager.findFirstVisibleItemPositions(visiblePositions)

                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> {
                        if (autoScroll) {
                            val positions = visiblePositions.filter { position ->
                                val view = manager.findViewByPosition(position)
                                        ?: return@filter false
                                isViewVisible(view)
                            }

                            if (positions.isNotEmpty()) {
                                val position = positions.min() ?: 0
                                recyclerView.smoothScrollToPosition(position)
                                autoScroll = false
                            }
                        }
//                        Log.i("View Visibility", "View at $position is ${if (isViewVisible(view)) "Visible" else "Disappearing"}")
                    }
                    RecyclerView.SCROLL_STATE_DRAGGING -> {
                        autoScroll = true
                    }
                }
            }
        })
    }

    fun isViewVisible(view: View): Boolean = view.scaleX >= 0

    override fun configureViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainWallViewModel::class.java)
        viewModel.register(this, Observer { newState ->
            when (newState) {
                ViewModelState.Success -> {
                    mainWallRecyclerView.adapter?.notifyDataSetChanged()
                }
            }
        })

        viewModel.init()
    }

    override fun bindView() {
        mainWallRecyclerView.adapter = WallAdapter().apply {
            setShowPlaceholderWhenEmpty(false)
            dataSource = viewModel
        }
    }

    //MARK: Persistence
    private fun savePhotos(photos: List<BaseWallModel>) {
        Preferences.saveSharedPreference(this@MainWallFragment.context, Preferences.RANDOM_BUCKET, Gson().toJson(photos))
    }

    //MARK: View Delegate
    override fun onPhotosLoaded(photos: MutableList<Photo>) {
//        mSwipeRefresh.isRefreshing = false
//        savePhotos(photos = photos)

//        mList.let {
//            if (it.adapter == null) {
//                val adapter = WallAdapter(photos)
////                adapter.mMainWallListener = mWallPresenter?.addWallListener()
//                it.adapter = adapter
//            } else {
//                (it.adapter as WallAdapter).addNewPage(photos)
//            }
//        }
    }
}