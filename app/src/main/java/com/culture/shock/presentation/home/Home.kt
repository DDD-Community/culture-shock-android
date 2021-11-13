package com.culture.shock.presentation.home

import androidx.fragment.app.viewModels
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : MVIFragment<FragmentHomeBinding, HomeIntent, HomeState, HomeEffect>(
    FragmentHomeBinding::inflate
) {
    override val viewModel: HomeViewModel by viewModels()
    override val isVisibleToolbar: Boolean = false

    override fun processState(state: HomeState) {
    }

    override fun processEffect(effect: HomeEffect) {
    }
}
