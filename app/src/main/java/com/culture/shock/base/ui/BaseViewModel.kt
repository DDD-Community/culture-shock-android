package com.culture.shock.base.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.culture.shock.domain.DomainModel
import com.culture.shock.domain.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import timber.log.Timber
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel : ViewModel() {
    private val _errorHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e(exception)
        handleException(exception)
    }

    protected open fun handleException(exception: Throwable) {
    }

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        errorHandler: CoroutineExceptionHandler = _errorHandler,
        block: suspend CoroutineScope.() -> Unit
    ): Job = (viewModelScope + errorHandler).launch(context, start, block)

    protected fun <T> async(
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> T
    ): Deferred<T> = viewModelScope.async(context, start, block)

    protected inline fun <reified T : DomainModel> Result<T>.onComplete(
        doOnError: (exception: Throwable) -> Unit = ::handleException,
        doOnSuccess: T.() -> Unit
    ) {
        when (this) {
            is Result.Success -> doOnSuccess(data)
            is Result.Failure -> doOnError(exception)
        }
    }
}
