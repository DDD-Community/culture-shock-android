package com.culture.shock.presentation.home

import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface HomeIntent : ViewIntent

object HomeState : ViewState

sealed interface HomeEffect : ViewEffect
