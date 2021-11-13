package com.culture.shock.presentation.splash

import com.culture.shock.base.DeepLink
import com.culture.shock.base.mvi.MVIVIewModel
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() :
    MVIVIewModel<SplashIntent, SplashState, SplashEffect>() {
    override fun createInitialState(): SplashState = SplashState

    override fun processIntent(intent: SplashIntent) = when (intent) {
        SplashIntent.ViewCreated -> processAuthCheck()
    }

    private fun processAuthCheck() {
        val hasToken = AuthApiClient.instance.hasToken()
        if (!hasToken) return processNavigation(false)
        UserApiClient.instance.accessTokenInfo { _, error ->
            processNavigation(error == null)
        }
    }

    private fun processNavigation(hasUser: Boolean) {
        launch {
            val deepLink = if (hasUser) DeepLink.Home else DeepLink.Auth
            setEffect { SplashEffect.NavigateUri(deepLink.uri) }
        }
    }
}
