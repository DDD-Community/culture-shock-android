package com.culture.shock.init

import android.content.Context
import androidx.startup.Initializer
import com.culture.shock.BuildConfig
import timber.log.Timber

class TimberInitializer : Initializer<Unit> {
    private val notLoggingTree = object : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        }
    }

    override fun create(context: Context) {
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else notLoggingTree)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}
