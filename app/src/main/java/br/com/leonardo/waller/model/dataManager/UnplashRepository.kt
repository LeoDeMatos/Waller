package br.com.leonardo.waller.model.dataManager

import br.com.leonardo.core.UnplashAPI
import br.com.leonardo.core.model.Photo
import br.com.leonardo.core.util.Paginator
import br.com.leonardo.waller.util.BaseRepository
import io.reactivex.Single
import javax.inject.Inject

//
//  UnplashRepository
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

class UnplashRepository : BaseRepository() {

    @Inject
    lateinit var unplashAPI: UnplashAPI

    fun getPhotos(paginator: Paginator): Single<MutableList<Photo>> {
        return unplashAPI.photos(page = paginator.getCurrentPage(), perPage = paginator.limit)
    }
}