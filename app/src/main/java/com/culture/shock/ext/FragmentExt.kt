package com.culture.shock.ext

import androidx.fragment.app.Fragment

fun Fragment.showToast(msg: String) = requireContext().toastL(msg)
