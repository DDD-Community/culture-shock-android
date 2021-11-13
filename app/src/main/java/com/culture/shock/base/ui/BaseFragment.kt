package com.culture.shock.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.culture.shock.ext.setTitle

abstract class BaseFragment<BINDING : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup?, Boolean) -> BINDING
) : Fragment() {
    private var bindingRef: BINDING? = null

    open val title = ""
    @DrawableRes
    open val titleDrawableRes: Int? = null
    open val isVisibleToolbar: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater(inflater, container, false).apply {
        bindingRef = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setTitle(title, titleDrawableRes, isVisibleToolbar)
        initView()
    }

    override fun onResume() {
        super.onResume()
        setTitle(title, titleDrawableRes, isVisibleToolbar)
    }

    open fun initView() {}

    protected fun <T> binding(action: BINDING.() -> T): T {
        return checkNotNull(bindingRef) {
            "${this.javaClass.simpleName} - ViewDataBinding is released"
        }.action()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingRef = null
    }
}
