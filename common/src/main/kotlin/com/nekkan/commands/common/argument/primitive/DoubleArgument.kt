package com.nekkan.commands.common.argument.primitive

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.failure
import com.nekkan.commands.common.argument.success
import com.nekkan.commands.common.argument.text.SingleWordArgument

object DoubleArgument: SingleWordArgument<Double>() {

    override fun CharSequenceConsumer.parse(word: String): ArgumentResult<Double> {
        return when(val number = word.toDoubleOrNull()) {
            null -> failure("A number was expected, but '$word' was provided.")
            else -> success(number)
        }
    }

}
