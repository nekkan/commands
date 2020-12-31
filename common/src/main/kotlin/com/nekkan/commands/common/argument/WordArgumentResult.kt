package com.nekkan.commands.common.argument

import com.nekkan.commands.common.argument.text.WordArgument

/**
 * The product of an [WordArgument]'s result. A [WordArgumentResult] can either be successful or failed. A value of
 * the generic type [T] can be returned.
 */
sealed class WordArgumentResult<T: Any?>: ArgumentResult<T>() {

    /**
     * A successful parsing that produces an [item] and the amount of [wordsTaken].
     */
    data class Success<T: Any?>(val item: T, val wordsTaken: Int): WordArgumentResult<T>()

    /**
     * A failed parsing that couldn't turn the given [String] into a [T] item, producing the fail reason,
     * the amount of [wordsTaken] and the char where the parsing failed.
     */
    data class Failure(val reason: String, val atChar: Int, val wordsTaken: Int): WordArgumentResult<Nothing>()

}
