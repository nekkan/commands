package com.nekkan.commands.common.argument

inline fun <T: Any?> ArgumentResult.Default<T>.ok() = when(this) {
    is ArgumentResult.Success<*> -> item
    else -> throw IllegalStateException("Expected argument result was Success, but Failure was provided.")
}

inline fun ArgumentResult.Default<*>.fail() = when(this) {
    is ArgumentResult.Failure -> Unit
    else -> throw IllegalStateException("Expected argument result was Failure, but Success was provided.")
}

inline fun <T: Any?> TextArgumentResult<T>.ok() = when(this) {
    is TextArgumentResult.Success<*> -> words
    else -> throw IllegalStateException("Expected argument result was Success, but Failure was provided.")
}

inline fun TextArgumentResult<*>.fail() = when(this) {
    is TextArgumentResult.Failure -> Unit
    else -> throw IllegalStateException("Expected argument result was Failure, but Success was provided.")
}

inline fun <T: Any?> ArgumentResult<T>.asWordResult(wordsTaken: Int = 0): TextArgumentResult<T> = when(this) {
    is TextArgumentResult<T> -> this
    is ArgumentResult.Success -> TextArgumentResult.Success(listOf(item))
    is ArgumentResult.Failure -> TextArgumentResult.Failure(reason, atChar, wordsTaken) as TextArgumentResult<T>
    else -> throw IllegalStateException("Expected argument result was Success or Failure, but ${this::class.qualifiedName} was provided.")
}

inline fun <T: Any?> ArgumentResult<T>.default() = when(this) {
    is ArgumentResult.Default<T> -> this
    is TextArgumentResult.Success -> ArgumentResult.Success(words.joinToString(" "), words.size)
    is TextArgumentResult.Failure -> ArgumentResult.Failure(reason, atChar)
    else -> throw IllegalStateException("Expected argument result was Default, but ${this::class.qualifiedName} was provided.")
}
