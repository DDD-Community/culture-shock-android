package com.culture.shock.presentation.performance.list

import com.culture.shock.base.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PerformanceListViewModel @Inject constructor(
) : MVIViewModel<PerformanceListIntent, PerformanceListState, PerformanceListEffect>() {
    override fun createInitialState() = PerformanceListState

    override fun processIntent(intent: PerformanceListIntent) {}
}

