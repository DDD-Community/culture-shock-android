package com.culture.shock.presentation.splash

import com.culture.shock.base.mvi.MVIVIewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor() : MVIVIewModel<SplashIntent, SplashState, SplashEffect>() {
    override fun createInitialState(): SplashState = SplashState

    override fun processIntent(intent: SplashIntent) {
    }
}
