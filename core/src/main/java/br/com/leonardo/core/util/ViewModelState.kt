package br.com.leonardo.core.util

//
//  ViewModelState
//  Waller
//
//  Created by Leonardo de Matos on 2019-02-03.
//  Copyright © 2019 Leonardo de Matos. All rights reserved.
//

sealed class ViewModelState {

    data class ErrorWith(val message: String) : ViewModelState()
    object Error : ViewModelState()
    object Loading : ViewModelState()
    object Success : ViewModelState()
    object None : ViewModelState()
}