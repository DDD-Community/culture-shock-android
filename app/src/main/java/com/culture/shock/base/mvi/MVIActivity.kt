package com.culture.shock.base.mvi

import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.culture.shock.base.ui.BaseActivity
import kotlinx.coroutines.flow.collect

abstract class MVIActivity<BINDING : ViewBinding, I : ViewIntent, S : ViewState, E : ViewEffect>(
    inflater: (LayoutInflater) -> BINDING
) : BaseActivity<BINDING>(inflater), MviView<I, S, E> {
    abstract val viewModel: MVIViewModel<I, S, E>

    override fun setIntent(intent: I) {
        viewModel.dispatch(intent)
    }

    init {
        lifecycleScope.launchWhenResumed {
            viewModel.state.collect {
                processState(it)
            }
        }
        lifecycleScope.launchWhenResumed {
            viewModel.effect.collect {
                processEffect(it)
            }
        }
    }
}
