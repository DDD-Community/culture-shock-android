package com.culture.shock.init

import android.content.Context
import androidx.startup.Initializer
import com.culture.shock.BuildConfig
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import timber.log.Timber

class KakaoInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        KakaoSdk.init(context, BuildConfig.KAKAO_NATIVE_APP_KEY)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(TimberInitializer::class.java)
    }
}
