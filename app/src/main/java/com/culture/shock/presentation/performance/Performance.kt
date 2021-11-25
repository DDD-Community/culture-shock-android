package com.culture.shock.presentation.performance

import androidx.fragment.app.viewModels
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentPerformanceBinding
import com.google.android.material.tabs.TabLayoutMediator

class Performance :
    MVIFragment<FragmentPerformanceBinding, PerformanceIntent, PerformanceState, PerformanceEffect>(
        FragmentPerformanceBinding::inflate
    ) {
    override val viewModel: PerformanceViewModel by viewModels()

    override fun initView() = binding {
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }

    override fun processState(state: PerformanceState) {
    }

    override fun processEffect(effect: PerformanceEffect) {
    }
}
