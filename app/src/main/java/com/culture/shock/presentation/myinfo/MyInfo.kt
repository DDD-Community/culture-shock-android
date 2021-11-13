package com.culture.shock.presentation.myinfo

import androidx.fragment.app.viewModels
import com.culture.shock.base.mvi.MVIFragment
import com.culture.shock.databinding.FragmentMyInfoBinding

class MyInfo : MVIFragment<FragmentMyInfoBinding, MyInfoIntent, MyInfoState, MyInfoEffect>(
    FragmentMyInfoBinding::inflate
) {
    override val viewModel: MyInfoViewModel by viewModels()

    override fun processState(state: MyInfoState) {
    }

    override fun processEffect(effect: MyInfoEffect) {
    }
}
