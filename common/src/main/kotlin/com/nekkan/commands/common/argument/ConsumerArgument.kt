package com.nekkan.commands.common.argument

abstract class ConsumerArgument<T>: Argument<T> {

    abstract class WithTimes<T>: Argument.WithTimes<T> {
        final override fun parse(charSequence: CharSequence, times: Int, fromIndex: Int): ArgumentResult<T> {
            val consumer = CharSequenceConsumer(charSequence, fromIndex)
            return consumer.parse(times)
        }

        final override fun parse(charSequence: CharSequence, fromIndex: Int): ArgumentResult<T> {
            val consumer = CharSequenceConsumer(charSequence, fromIndex)
            return consumer.parse(defaultTimes)
        }

        abstract fun CharSequenceConsumer.parse(times: Int): ArgumentResult<T>
    }

    final override fun parse(charSequence: CharSequence, fromIndex: Int): ArgumentResult<T> {
        val consumer = CharSequenceConsumer(charSequence, fromIndex)
        return consumer.parse()
    }

    abstract fun CharSequenceConsumer.parse(): ArgumentResult<T>

}
