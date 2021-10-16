package com.culture.shock.presentation.splash

import androidx.fragment.app.viewModels
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : MVIFragment<FragmentSplashBinding, SplashIntent, SplashState, SplashEffect>(
    FragmentSplashBinding::inflate
){
    override val viewModel: SplashViewModel by viewModels()

    override fun processState(state: SplashState) {
    }

    override fun processEffect(effect: SplashEffect) {
    }
}
