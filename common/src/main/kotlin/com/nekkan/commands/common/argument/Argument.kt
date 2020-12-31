package com.nekkan.commands.common.argument

interface Argument<T> {

    interface WithTimes<T>: Argument<T> {
        val defaultTimes: Int

        fun parse(charSequence: CharSequence, times: Int, fromIndex: Int = 0): ArgumentResult<T>

        /**
         * Parses the given [charSequence], reading the remaining characters starting [from the given index][fromIndex].
         * @return A [ArgumentResult] of [T] representing either a parsing failure or success.
         */
        override fun parse(charSequence: CharSequence, fromIndex: Int): ArgumentResult<T> {
            return parse(charSequence, defaultTimes, fromIndex)
        }
    }

    /**
     * Parses the given [charSequence], reading the remaining characters starting [from the given index][fromIndex].
     * @return A [ArgumentResult] of [T] representing either a parsing failure or success.
     */
    fun parse(charSequence: CharSequence, fromIndex: Int = 0): ArgumentResult<T>

}
