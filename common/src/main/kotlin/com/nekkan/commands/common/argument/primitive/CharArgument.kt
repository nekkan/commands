package com.nekkan.commands.common.argument.primitive

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.failure
import com.nekkan.commands.common.argument.success
import com.nekkan.commands.common.argument.text.SingleWordArgument

object CharArgument: SingleWordArgument<Char>() {

    override fun CharSequenceConsumer.parse(word: String): ArgumentResult<Char> {
        return when(word.length) {
            1 -> success(word.first())
            else -> failure("A character was expected, but '$word' was provided.")
        }
    }

}
