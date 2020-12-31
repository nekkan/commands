package com.nekkan.commands.common.argument

inline fun <T: Any?> ArgumentResult.Default<T>.ok() = when(this) {
    is ArgumentResult.Success<*> -> item
    else -> throw IllegalStateException("Expected argument result was Success, but Failure was provided.")
}

inline fun ArgumentResult.Default<*>.fail() = when(this) {
    is ArgumentResult.Failure -> Unit
    else -> throw IllegalStateException("Expected argument result was Failure, but Success was provided.")
}

inline fun <T: Any?> ArgumentResult<T>.default() = when(this) {
    is ArgumentResult.Default<T> -> this
    is WordArgumentResult.Success -> ArgumentResult.Success(item, wordsTaken)
    is WordArgumentResult.Failure -> ArgumentResult.Failure(reason, atChar)
    else -> throw IllegalStateException("Expected argument result was Default, but ${this::class.simpleName} was provided.")
}
