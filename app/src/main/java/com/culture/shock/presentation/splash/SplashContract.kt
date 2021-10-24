package com.culture.shock.presentation.splash

import android.net.Uri
import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface SplashIntent : ViewIntent {
    object ViewCreated : SplashIntent
}

object SplashState : ViewState

sealed interface SplashEffect : ViewEffect {
    data class NavigateUri(val uri: Uri) : SplashEffect
}
