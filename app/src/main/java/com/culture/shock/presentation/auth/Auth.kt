package com.culture.shock.presentation.auth

import androidx.fragment.app.viewModels
import com.culture.shock.R
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentAuthBinding
import com.culture.shock.ext.deepLink
import com.culture.shock.ext.showToast
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Auth : MVIFragment<FragmentAuthBinding, AuthIntent, AuthState, AuthEffect>(
    FragmentAuthBinding::inflate
) {
    private val userApiClient by lazy { UserApiClient.instance }
    override val viewModel: AuthViewModel by viewModels()
    private val isKakaoTalkLoginAvailable
        get() = userApiClient.isKakaoTalkLoginAvailable(requireContext())
    private val onAuthCallback: (token: OAuthToken?, error: Throwable?) -> Unit = { token, error ->
        setIntent(AuthIntent.OnAuthResult(token, error))
    }

    override fun initView() = binding {
        btnSignIn.setOnClickListener {
            if (isKakaoTalkLoginAvailable) {
                userApiClient.loginWithKakaoTalk(requireContext(), callback = onAuthCallback)
            } else {
                userApiClient.loginWithKakaoAccount(requireContext(), callback = onAuthCallback)
            }
        }
    }

    override fun processState(state: AuthState) {
    }

    override fun processEffect(effect: AuthEffect) = when (effect) {
        is AuthEffect.NavigateUri -> deepLink(effect.uri) {
            popUpTo(R.id.auth) { inclusive = true }
        }
        is AuthEffect.ShowToast -> showToast(effect.message)
    }
}
