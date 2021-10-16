package com.culture.shock.presentation.home

import com.culture.shock.base.mvi.MVIVIewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : MVIVIewModel<HomeIntent, HomeState, HomeEffect>() {
    override fun createInitialState(): HomeState = HomeState

    override fun processIntent(intent: HomeIntent) {
    }
}
