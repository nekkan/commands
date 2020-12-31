@file:JvmName("Extensions")

package com.nekkan.commands.common

import com.nekkan.commands.common.argument.CharSequenceConsumer

/**
 * Returns whether the parser has fully parsed the given [CharSequenceConsumer.charSequence].
 * Will always returns `true` if the given [CharSequenceConsumer.charSequence] is empty.
 */
val CharSequenceConsumer.hasEnded: Boolean
    get() = cursor >= charSequence.length

/**
 * Returns the distance in characters the [CharSequenceConsumer.cursor] has moved from the
 * [CharSequenceConsumer.startIndex].
 */
val CharSequenceConsumer.moved: Int
    get() = cursor - startIndex

/**
 * Returns the remaining characters to be parsed.
 */
val CharSequenceConsumer.remaining: String
    get() = if(hasEnded) "" else charSequence.substring(cursor)

fun CharSequenceConsumer.dropRemaining() = drop(remaining.length - 1)

/**
 * Make a consumption until the [predicate] returns `false`.
 * @param predicate The predicate that will be verified before each consumption.
 */
inline fun CharSequenceConsumer.consumeUntil(predicate: (Char) -> Boolean) {
    while(!hasEnded && !predicate(character)) {
        consume()
    }
}

/**
 * Drops characters that match the given [predicate].
 * @param predicate The predicate that will be verified before each drop.
 */
inline fun CharSequenceConsumer.dropWhile(predicate: (Char) -> Boolean) {
    while(!hasEnded && predicate(character)) {
        cursor++
    }
}

/**
 * Returns a drop of all characters that are whitespaces.
 */
inline fun CharSequenceConsumer.dropWhitespaces() = dropWhile { it.isWhitespace() }

/**
 * Returns a consumption of the next word starting from the [CharSequenceConsumer.cursor].
 */
fun CharSequenceConsumer.consumeWord() = consumeUntil { it.isWhitespace() }

/**
 * Clear everything, executes the [callback] and clears everything again.
 * The cursor will be not reset.
 */
inline fun CharSequenceConsumer.clear(callback: () -> Unit): String {
    consumed.clear()
    callback()
    val result = "$consumed"
    consumed.clear()
    return result
}

/**
 * Consumes all [CharSequenceConsumer.remaining] characters.
 */
fun CharSequenceConsumer.consumeAll() = consume(charSequence.length - cursor)

/**
 * Requires a [CharSequence] to be not blank.
 */
inline fun <T: CharSequence> requireNotBlank(text: T): T {
    require(text.isNotBlank()) { "Given text was expected to be not blank." }
    return text
}
