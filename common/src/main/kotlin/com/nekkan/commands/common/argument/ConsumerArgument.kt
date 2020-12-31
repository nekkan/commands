package com.nekkan.commands.common.argument

abstract class ConsumerArgument<T>: Argument<T> {

    final override fun parse(charSequence: CharSequence, fromIndex: Int): ArgumentResult<T> {
        val consumer = CharSequenceConsumer(charSequence, fromIndex)
        return consumer.parse()
    }

    protected abstract fun CharSequenceConsumer.parse(): ArgumentResult<T>

}
