package com.culture.shock.presentation.home

import com.culture.shock.base.mvi.MVIVIewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : MVIVIewModel<HomeIntent, HomeState, HomeEffect>() {
    override fun createInitialState(): HomeState = HomeState

    override fun processIntent(intent: HomeIntent) {
    }
}
