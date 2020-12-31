package com.nekkan.commands.common.argument

/**
 * Returns a [ArgumentResult.Failure] indicating that more characters were expected.
 */
inline fun <T: Any?> CharSequenceConsumer.unexpectedEnd(atChar: Int = 0): ArgumentResult<T> {
    return unexpected("End: more characters were expected but reached end.", atChar)
}

inline fun <T: Any?> CharSequenceConsumer.unexpected(text: String, atChar: Int = 0): ArgumentResult<T> {
    return ArgumentResult.Failure("Unexpected $text", atChar) as ArgumentResult<T>
}

inline fun <T: Any?> CharSequenceConsumer.expected(text: String, atChar: Int = 0): ArgumentResult<T> {
    return ArgumentResult.Failure("Expected $text", atChar) as ArgumentResult<T>
}
