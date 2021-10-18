package com.culture.shock.ext

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.culture.shock.base.DeepLink

fun Fragment.navController(action: NavController.() -> Unit) {
    findNavController().action()
}

fun Fragment.navPopBack(
    @IdRes destinationId: Int? = null,
    inclusive: Boolean = true
) = navController {
    if (destinationId == null) popBackStack() else popBackStack(destinationId, inclusive)
}

fun Fragment.deepLink(
    deepLink: DeepLink,
    optionsBuilder: NavOptionsBuilder.() -> Unit = {}
) = deepLink(deepLink.uri, navOptions(optionsBuilder))

fun Fragment.deepLink(
    uri: Uri,
    optionsBuilder: NavOptionsBuilder.() -> Unit = {}
) = deepLink(uri, navOptions(optionsBuilder))

fun Fragment.deepLink(
    deepLink: DeepLink,
    navOption: NavOptions
) = deepLink(deepLink.uri, navOption)

fun Fragment.deepLink(
    uri: Uri,
    navOption: NavOptions
) = navController {
    navigate(uri, navOption)
}

private val defaultOption by lazy {
    NavOptionBuilders.Default.build()
}

object NavOptionBuilders {
    val Default
        get() = NavOptions.Builder()
}

fun Fragment.navigate(
    direction: NavDirections,
    navOption: NavOptions = defaultOption,
    extras: Navigator.Extras? = null
) = navigate(direction.actionId, direction.arguments, navOption, extras)

fun Fragment.navigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOption: NavOptions = defaultOption,
    extras: Navigator.Extras? = null
) = findNavController().navigate(resId, args, navOption, extras)

fun View.navigate(
    direction: NavDirections,
    navOption: NavOptions = defaultOption,
    extras: Navigator.Extras? = null
) = navigate(direction.actionId, direction.arguments, navOption, extras)

fun View.navigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOption: NavOptions = defaultOption,
    extras: Navigator.Extras? = null
) = findNavController().navigate(resId, args, navOption, extras)
