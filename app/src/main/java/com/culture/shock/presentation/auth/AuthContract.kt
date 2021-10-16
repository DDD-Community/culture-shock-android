package com.culture.shock.presentation.auth

import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface AuthIntent : ViewIntent {

}

object AuthState : ViewState

sealed interface AuthEffect : ViewEffect {

}
