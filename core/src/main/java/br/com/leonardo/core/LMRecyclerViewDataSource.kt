package br.com.leonardo.core

//
//  LMRecyclerViewDataSource
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

interface LMRecyclerViewDataSource<out T> {
    fun getItemCount(): Int
    fun getViewTypeFor(position: Int): Int
    fun getItemFor(position: Int): T
}