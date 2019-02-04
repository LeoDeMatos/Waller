package br.com.leonardo.core

import android.view.View

//
//  LMRecyclerViewDelegate
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

interface LMRecyclerViewDelegate<in T> {
    fun onItemClickListener(view: View, position: Int, obj: T?)
}