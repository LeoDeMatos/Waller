package br.com.leonardo.core.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

//
//  LMViewModel
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

open class LMViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val state = MutableLiveData<ViewModelState>()

    fun postNewState(newState: ViewModelState) {
        state.postValue(newState)
    }

    fun register(lifecycleOwner: LifecycleOwner, observer: Observer<ViewModelState>) {
        state.observe(lifecycleOwner, observer)
    }

    fun addToDisposeBag(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun disposeViewModelCalls() {
        compositeDisposable.dispose()
    }
}