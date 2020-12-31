package com.nekkan.commands.common.argument

/**
 * Returns a [ArgumentResult.Failure] indicating that more characters were expected.
 */
inline fun <T: Any?> CharSequenceConsumer.unexpectedEnd(atChar: Int = 0): ArgumentResult<T> {
    return unexpected("End: more characters were expected but reached end.", atChar)
}

/**
 * Returns a [ArgumentResult.Failure] indicating that the parsing have been not succeeded.
 * @param text The text that will be passed after the `Unexpected` message.
 */
inline fun <T: Any?> CharSequenceConsumer.unexpected(text: CharSequence, atChar: Int = 0): ArgumentResult<T> {
    return ArgumentResult.Failure("Unexpected $text", atChar) as ArgumentResult<T>
}

/**
 * Returns a [ArgumentResult.Failure] indicating that the parsing have been not succeeded.
 * @param text The text that will be passed after the `Expected` message.
 */
inline fun <T: Any?> CharSequenceConsumer.expected(text: CharSequence, atChar: Int = 0): ArgumentResult<T> {
    return ArgumentResult.Failure("Expected $text", atChar) as ArgumentResult<T>
}

/**
 * Returns a [ArgumentResult.Success] indicating that the parsing have been successful.
 * @param item The [item] that will be passed to the [ArgumentResult].
 */
inline fun <T: Any?> CharSequenceConsumer.success(item: T) = ArgumentResult.Success(item, cursor)

/**
 * Returns a [ArgumentResult.Success] indicating that the parsing have been successful with the consumed [String]
 * passed as item.
 */
inline fun CharSequenceConsumer.success() = ArgumentResult.Success("$consumed", cursor)

/**
 * Returns a [ArgumentResult.Success] indicating that the parsing have failed with the consumed [String] passed as
 * item.
 */
inline fun <T: Any?> CharSequenceConsumer.failure(reason: String): ArgumentResult<T> {
    return ArgumentResult.Failure(reason, cursor) as ArgumentResult<T>
}
