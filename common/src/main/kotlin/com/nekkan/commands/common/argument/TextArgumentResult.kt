package com.nekkan.commands.common.argument

import com.nekkan.commands.common.argument.text.TextArgument

/**
 * The product of an [TextArgument]'s result. A [TextArgumentResult] can either be successful or failed. A value of
 * the generic type [T] can be returned.
 */
sealed class TextArgumentResult<T: Any?>: ArgumentResult<T>() {

    /**
     * A successful parsing that produces a list of [words] and the amount of [wordsTaken].
     */
    data class Success<T: Any?>(val words: List<T>): TextArgumentResult<T>()

    /**
     * A failed parsing that couldn't turn the given [String] into a [T] item, producing the fail reason,
     * the amount of [wordsTaken] and the char where the parsing failed.
     */
    data class Failure(val reason: String, val atChar: Int, val wordsTaken: Int): TextArgumentResult<Nothing>()

}
