package com.nekkan.commands.common.argument

/**
 * The product of an [Argument]'s result. A [ArgumentResult] can either be successful or failed. A value of the
 * generic type [T] can be returned.
 */
sealed class ArgumentResult<T: Any?> {

    /**
     * A successful parsing that produces an [item] and the [newIndex].
     */
    data class Success<T: Any?>(val item: T, val newIndex: Int): ArgumentResult<T>()

    /**
     * A failed parsing that couldn't turn the given [String] into a [T] item, producing the fail reason and
     * the char where the parsing failed.
     */
    data class Failure(val reason: String, val atChar: Int): ArgumentResult<Nothing>()

}
