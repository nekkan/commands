package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.TextArgumentResult

object WordArgument: SingleWordArgument<String>() {

    override fun CharSequenceConsumer.parse(words: String): ArgumentResult<String> {
        return TextArgumentResult.Success(listOf(words))
    }

}
