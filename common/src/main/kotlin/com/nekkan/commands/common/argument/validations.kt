package com.nekkan.commands.common.argument

inline fun <T: Any?> ArgumentResult.Default<T>.ok() = when(this) {
    is ArgumentResult.Success<*> -> item
    else -> throw IllegalStateException("Expected argument result was Success, but Failure was provided.")
}

inline fun ArgumentResult.Default<*>.fail() = when(this) {
    is ArgumentResult.Failure -> Unit
    else -> throw IllegalStateException("Expected argument result was Failure, but Success was provided.")
}

inline fun <T: Any?> WordArgumentResult<T>.ok() = when(this) {
    is WordArgumentResult.Success<*> -> words
    else -> throw IllegalStateException("Expected argument result was Success, but Failure was provided.")
}

inline fun WordArgumentResult<*>.fail() = when(this) {
    is WordArgumentResult.Failure -> Unit
    else -> throw IllegalStateException("Expected argument result was Failure, but Success was provided.")
}

inline fun <T: Any?> ArgumentResult<T>.asWordResult(wordsTaken: Int = 0): WordArgumentResult<T> = when(this) {
    is WordArgumentResult<T> -> this
    is ArgumentResult.Success -> WordArgumentResult.Success(listOf(item))
    is ArgumentResult.Failure -> WordArgumentResult.Failure(reason, atChar, wordsTaken) as WordArgumentResult<T>
    else -> throw IllegalStateException("Expected argument result was Success or Failure, but ${this::class.qualifiedName} was provided.")
}

inline fun <T: Any?> ArgumentResult<T>.default() = when(this) {
    is ArgumentResult.Default<T> -> this
    is WordArgumentResult.Success -> ArgumentResult.Success(words.joinToString(" "), words.size)
    is WordArgumentResult.Failure -> ArgumentResult.Failure(reason, atChar)
    else -> throw IllegalStateException("Expected argument result was Default, but ${this::class.qualifiedName} was provided.")
}
