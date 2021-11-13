package com.culture.shock.presentation.splash

import androidx.fragment.app.viewModels
import com.culture.shock.R
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentSplashBinding
import com.culture.shock.ext.deepLink
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : MVIFragment<FragmentSplashBinding, SplashIntent, SplashState, SplashEffect>(
    FragmentSplashBinding::inflate
) {
    override val viewModel: SplashViewModel by viewModels()
    override val isVisibleToolbar: Boolean = false

    override fun initView() {
        setIntent(SplashIntent.ViewCreated)
    }

    override fun processState(state: SplashState) {
    }

    override fun processEffect(effect: SplashEffect) = when (effect) {
        is SplashEffect.NavigateUri -> deepLink(effect.uri) {
            popUpTo(R.id.splash) { inclusive = true }
        }
    }
}
