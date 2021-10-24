package com.culture.shock.presentation.auth

import android.net.Uri
import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState
import com.kakao.sdk.auth.model.OAuthToken

sealed interface AuthIntent : ViewIntent {
    data class OnAuthResult(val token: OAuthToken?, val error: Throwable?) : AuthIntent
}

object AuthState : ViewState

sealed interface AuthEffect : ViewEffect {
    data class NavigateUri(val uri: Uri) : AuthEffect
    data class ShowToast(val message: String) : AuthEffect
}
