package com.culture.shock.presentation.performance

import com.culture.shock.base.mvi.MVIViewModel

class PerformanceViewModel :
    MVIViewModel<PerformanceIntent, PerformanceState, PerformanceEffect>() {
    override fun createInitialState(): PerformanceState = PerformanceState

    override fun processIntent(intent: PerformanceIntent) {
    }
}
