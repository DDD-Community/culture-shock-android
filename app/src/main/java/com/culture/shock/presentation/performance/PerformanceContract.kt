package com.culture.shock.presentation.performance

import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface PerformanceIntent : ViewIntent

object PerformanceState : ViewState

sealed interface PerformanceEffect : ViewEffect
