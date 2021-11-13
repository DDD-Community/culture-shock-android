package com.culture.shock.presentation.auth

import com.culture.shock.base.DeepLink
import com.culture.shock.base.mvi.MVIVIewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : MVIVIewModel<AuthIntent, AuthState, AuthEffect>() {
    override fun createInitialState(): AuthState = AuthState

    override fun processIntent(intent: AuthIntent) = when (intent) {
        is AuthIntent.OnAuthResult -> processAuthResult(intent)
    }

    private fun processAuthResult(result: AuthIntent.OnAuthResult) {
        if (result.token != null) {
            setEffect { AuthEffect.NavigateUri(DeepLink.Home.uri) }
        } else {
            val error = result.error
            if (error != null) {
                Timber.e(error)
                error.message?.let(AuthEffect::ShowToast)?.let { effect ->
                    setEffect { effect }
                }
            } else {
                setEffect { AuthEffect.ShowToast("로그인 실패") }
            }
        }
    }
}
