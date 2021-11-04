package com.culture.shock.presentation.performance

import androidx.fragment.app.viewModels
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.base.mvi.MVIVIewModel
import com.culture.shock.databinding.FragmentPerformanceBinding

class Performance: MVIFragment<FragmentPerformanceBinding, PerformanceIntent, PerformanceState, PerformanceEffect>(
    FragmentPerformanceBinding::inflate
) {
    override val viewModel: PerformanceViewModel by viewModels()

    override fun processState(state: PerformanceState) {

    }

    override fun processEffect(effect: PerformanceEffect) {

    }
}