package com.culture.shock.base

import android.net.Uri

sealed interface DeepLink {
    val deepLink: String
    val uri: Uri get() = Uri.parse(deepLink)

    object Splash : DeepLink {
        override val deepLink: String = "culture://splash"
    }

    object Auth : DeepLink {
        override val deepLink: String = "culture://auth"
    }

    object Main : DeepLink {
        override val deepLink: String = "culture://main"
    }
}
