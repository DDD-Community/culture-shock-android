package com.culture.shock.presentation.performance.list

import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface PerformanceListIntent : ViewIntent {

}

object PerformanceListState : ViewState

sealed interface PerformanceListEffect : ViewEffect {

}
