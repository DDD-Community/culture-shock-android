package com.culture.shock.presentation.splash

import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface SplashIntent : ViewIntent {

}

object SplashState : ViewState

sealed interface SplashEffect : ViewEffect {

}
