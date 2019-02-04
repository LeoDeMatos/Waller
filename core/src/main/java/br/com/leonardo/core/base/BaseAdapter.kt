package br.com.leonardo.core.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.core.LMRecyclerViewDataSource
import br.com.leonardo.core.LMRecyclerViewDelegate
import br.com.leonardo.core.R

//
//  BaseAdapter
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var showPlaceholderWhenEmpty = true
    val noContentViewType = 32423476

    override fun getItemViewType(position: Int): Int {
        return if (isEmptyContent()) noContentViewType else dataSource.getViewTypeFor(position)
    }

    override fun getItemCount(): Int {
        return if (isEmptyContent() && showPlaceholderWhenEmpty) {
            1
        } else {
            dataSource.getItemCount()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        initInflater(parent.context)
        val view = inflater.inflate(R.layout.row_no_content, parent, false)
        return NoContentViewHolder(view)
    }

    lateinit var inflater: LayoutInflater
    lateinit var dataSource: LMRecyclerViewDataSource<T>
    lateinit var delegate: LMRecyclerViewDelegate<T>

    fun initInflater(context: Context) {
        if (!this::inflater.isInitialized) {
            inflater = LayoutInflater.from(context)
        }
    }

    fun isEmptyContent(): Boolean {
        return dataSource.getItemCount() == 0
    }

    fun setShowPlaceholderWhenEmpty(show: Boolean) {
        showPlaceholderWhenEmpty = show
    }
}