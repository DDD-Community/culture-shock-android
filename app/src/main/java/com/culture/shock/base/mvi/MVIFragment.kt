package com.culture.shock.base.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.culture.shock.base.ui.BaseFragment
import kotlinx.coroutines.flow.collect

abstract class MVIFragment<BINDING : ViewBinding, I : ViewIntent, S : ViewState, E : ViewEffect>(
    inflater: (LayoutInflater, ViewGroup?, Boolean) -> BINDING
) : BaseFragment<BINDING>(inflater), MviView<I, S, E> {
    abstract val viewModel: MVIVIewModel<I, S, E>

    override fun setIntent(intent: I) {
        viewModel.dispatch(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initCollect()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun initCollect() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.state.collect {
                processState(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.effect.collect {
                processEffect(it)
            }
        }
    }
}
