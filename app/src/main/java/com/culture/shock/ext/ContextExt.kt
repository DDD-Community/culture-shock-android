package com.culture.shock.ext

import android.content.Context
import android.widget.Toast

fun Context.toastS(message: CharSequence?) =
    Toast.makeText(this, message ?: "", Toast.LENGTH_SHORT).show()

fun Context.toastL(message: CharSequence?) =
    Toast.makeText(this, message ?: "", Toast.LENGTH_LONG).show()
