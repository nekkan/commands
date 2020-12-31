package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.TextArgumentResult
import com.nekkan.commands.common.argument.unexpectedEnd
import com.nekkan.commands.common.consumeWord
import com.nekkan.commands.common.dropWhitespaces
import com.nekkan.commands.common.hasEnded
import com.nekkan.commands.common.requireNotBlank

abstract class SingleWordArgument: TextArgument.WithTimes() {

    final override val defaultTimes: Int
        get() = 1

    override fun CharSequenceConsumer.parse(times: Int): ArgumentResult<String> {
        if(hasEnded) {
            return unexpectedEnd()
        }
        val cursorBefore = cursor
        repeat(times) {
            dropWhitespaces()
            consumeWord()
        }
        val word = requireNotBlank("$this")
        return TextArgumentResult.Success(listOf(word))
    }

}
