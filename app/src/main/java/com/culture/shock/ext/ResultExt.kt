package com.culture.shock.ext

import com.culture.shock.domain.DomainModel
import com.culture.shock.domain.Result

inline fun <reified T : DomainModel> Result<T>.get(): T = when (this) {
    is Result.Success -> data
    is Result.Failure -> throw exception
}

inline fun <reified T : DomainModel> Result<T>.getOrNull(): T? = when (this) {
    is Result.Success -> data
    is Result.Failure -> null
}
