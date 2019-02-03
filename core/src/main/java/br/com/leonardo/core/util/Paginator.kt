package br.com.leonardo.core.util

//
//  Paginator
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

data class Paginator(private val page: Int, val limit: Int) {

    private var currentPage: Int = 1
    private var nextPage: Int = currentPage

    fun loadNextPage() {
        nextPage += 1
    }

    fun didLoadNextPage() {
        if (isLoadingNextPage()) {
            currentPage = nextPage
        }
    }

    fun didNotLoadNextPage() {
        if (isLoadingNextPage()) {
            nextPage = currentPage
        }
    }

    fun getCurrentPage(): Int {
        return if (nextPage == currentPage) {
            currentPage
        } else {
            nextPage
        }
    }

    fun isLoadingNextPage(): Boolean {
        return nextPage != currentPage
    }
}