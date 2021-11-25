package com.culture.shock.presentation.performance.list

import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentPerformanceListBinding
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PerformanceList : MVIFragment<FragmentPerformanceListBinding, PerformanceListIntent, PerformanceListState, PerformanceListEffect>(
    FragmentPerformanceListBinding::inflate
) {
    override val viewModel: PerformanceListViewModel by viewModels()

    override fun initView() = binding {

    }

    override fun processState(state: PerformanceListState) = binding {

    }

    override fun processEffect(effect: PerformanceListEffect) {

    }
}
