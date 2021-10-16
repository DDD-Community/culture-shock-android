package com.culture.shock.presentation.auth

import androidx.fragment.app.viewModels
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Auth : MVIFragment<FragmentAuthBinding, AuthIntent, AuthState, AuthEffect>(
    FragmentAuthBinding::inflate
) {
    override val viewModel: AuthViewModel by viewModels()

    override fun processState(state: AuthState) {
    }

    override fun processEffect(effect: AuthEffect) {
    }
}
