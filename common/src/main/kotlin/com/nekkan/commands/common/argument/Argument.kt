package com.nekkan.commands.common.argument

interface Argument<T> {

    /**
     * Parses the given [charSequence], reading the remaining characters starting [from the given index][fromIndex].
     * @return A [ArgumentResult] of [T] representing either a parsing failure or success.
     */
    fun parse(charSequence: CharSequence, fromIndex: Int): ArgumentResult<T>

}
