package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.*
import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.WordArgumentResult
import com.nekkan.commands.common.argument.unexpectedEnd

object SingleWordArgument: WordArgument() {

    fun CharSequenceConsumer.parse(index: Int): ArgumentResult<String> {
        if(hasEnded) {
            return unexpectedEnd()
        }
        val cursorBefore = cursor
        val word = requireNotBlank(clear {
            dropWhitespaces()
            consumeWord(index)
        })
        return WordArgumentResult.Success(listOf(word))
    }

    override fun CharSequenceConsumer.parse(): ArgumentResult<String> {
        return parse(1)
    }

}
