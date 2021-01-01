package com.nekkan.commands.common.argument.primitive

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.failure
import com.nekkan.commands.common.argument.success
import com.nekkan.commands.common.argument.text.SingleWordArgument

object IntArgument: SingleWordArgument<Int>() {

    override fun CharSequenceConsumer.parse(word: String): ArgumentResult<Int> {
        return when(val number = word.toIntOrNull()) {
            null -> failure("A number was expected, but '$word' was provided.")
            else -> success(number)
        }
    }

}
