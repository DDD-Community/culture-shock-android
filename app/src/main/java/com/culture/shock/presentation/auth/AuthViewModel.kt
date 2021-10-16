package com.culture.shock.presentation.auth

import com.culture.shock.base.mvi.MVIVIewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor() : MVIVIewModel<AuthIntent, AuthState, AuthEffect>() {
    override fun createInitialState(): AuthState = AuthState

    override fun processIntent(intent: AuthIntent) {
    }
}
