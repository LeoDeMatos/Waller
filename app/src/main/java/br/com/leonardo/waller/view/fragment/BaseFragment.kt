package br.com.leonardo.waller.view.fragment

import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Leonardo on 22/10/17.
 */

open abstract class BaseFragment : Fragment() {

    lateinit var mRootView: ViewGroup

    abstract fun configureViewModel()
    abstract fun configureView()
    abstract fun bindView()

    override fun onStart() {
        super.onStart()
    }
}