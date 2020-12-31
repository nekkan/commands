package com.nekkan.commands.common.argument

/**
 * A [CharSequenceConsumer] is a mutable state class to facilitate the parsing of a given [charSequence].
 *
 * Characters can be consumed through our functions. The [cursor] is increased in each call of these functions.
 * Alternatively, the [cursor] can be increased `x` times without consuming the [CharSequence] by using the [drop]
 * function.
 *
 * @param startIndex The index from which to start parsing the given [charSequence].
 * @param charSequence The text that will be consumed.
 * @param consumed The builder used to store text consumptions.
 */
class CharSequenceConsumer(
    val charSequence: CharSequence,
    val startIndex: Int = 0,
    val consumed: StringBuilder = StringBuilder()
) {

    /**
     * Returns the character at the position of the [cursor].
     * @throws IndexOutOfBoundsException when the cursor is higher or equals to the given [charSequence]'s length.
     */
    val character: Char
        get() = charSequence[cursor]

    /**
     * Returns a value in the range of `0..'[charSequence].length'` equals to the current [character] index.
     */
    var cursor: Int = startIndex
        set(value) {
            /**
             * An index could not be negative and should be lower than the character's length.
             */
            require(value >= 0) {
                "Cursor must be positive, but `$value` was provided."
            }
            require(value <= charSequence.length) {
                "Cursor must be less than the given text length, but `$value` was provided."
            }
            field = value
        }

    /**
     * Clears the [consumed] characters and resets the [cursor] to [startIndex].
     */
    fun reset() {
        cursor = startIndex
        consumed.clear()
    }

    /**
     * Consume [amount] characters; get the next [amount] characters starting from the [cursor] and append to the
     * [consumed] builder.
     * @throws IllegalArgumentException if the [amount] would exceed the [charSequence] length.
     */
    fun consume(amount: Int) {
        val length = cursor + amount
        require(length <= charSequence.length) {
            "Taking $amount characters exceeded the charSequence length."
        }
        consumed.append(charSequence.substring(cursor, length))
        cursor += amount
    }

    /**
     * Consume the next character starting from the [cursor] and append to the [consumed] builder.
     * @throws IllegalArgumentException if the [cursor] would exceed the [charSequence] length.
     */
    fun consume() {
        consumed.append(character)
        cursor += 1
    }

    /**
     * Drop [amount] characters starting from the [cursor].
     * @throws IllegalArgumentException if the [amount] would exceed the [charSequence] length.
     */
    fun drop(amount: Int = 1) {
        require(cursor + amount <= charSequence.length) {
            "Taking $amount characters exceeded the charSequence length."
        }
        cursor += amount
    }

    /**
     * Build the [StringBuilder] and return its value as a [String].
     * @return The [consumed] values as a [String].
     */
    override fun toString() = consumed.toString()

}
