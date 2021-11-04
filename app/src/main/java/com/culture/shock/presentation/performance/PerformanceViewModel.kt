package com.culture.shock.presentation.performance

import com.culture.shock.base.mvi.MVIVIewModel

class PerformanceViewModel: MVIVIewModel<PerformanceIntent, PerformanceState, PerformanceEffect>() {
    override fun createInitialState(): PerformanceState = PerformanceState

    override fun processIntent(intent: PerformanceIntent) {

    }
}