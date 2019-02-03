package br.com.leonardo.waller.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by Leonardo on 22/10/17.
 */
class DefaultViewPagerAdapter<T>(fm: FragmentManager, private val fragments: List<Fragment>, private val titles: Array<T>? = null) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles?.get(position)?.toString() ?: ""
    }
}
