package br.com.leonardo.waller.view.fragment

import android.support.v4.app.Fragment
import android.view.ViewGroup

/**
 * Created by Leonardo on 22/10/17.
 */

open abstract class BaseFragment: Fragment(){

    lateinit var mRootView: ViewGroup
}