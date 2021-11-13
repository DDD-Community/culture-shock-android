package com.culture.shock.ext

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

@SuppressLint("RestrictedApi")
fun Fragment.setTitle(
    title: String,
    @DrawableRes drawableRes: Int? = null,
    isVisibleToolbar: Boolean = true
) {
    (requireActivity() as? AppCompatActivity)?.supportActionBar?.let {
        it.title = title
        drawableRes?.let(it::setHomeAsUpIndicator)
        it.setShowHideAnimationEnabled(false)
        if (isVisibleToolbar) it.show() else it.hide()
    }
}

fun Fragment.showToast(msg: String) = requireContext().toastL(msg)
