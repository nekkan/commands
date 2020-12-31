package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.WordArgumentResult
import com.nekkan.commands.common.argument.unexpectedEnd
import com.nekkan.commands.common.clear
import com.nekkan.commands.common.consumeWord
import com.nekkan.commands.common.hasEnded
import com.nekkan.commands.common.requireNotBlank

object SingleWordArgument: WordArgument() {

    override fun CharSequenceConsumer.parse(): ArgumentResult<String> {
        if(hasEnded) {
            return unexpectedEnd()
        }
        val cursorBefore = cursor
        val word = requireNotBlank(clear { consumeWord() })
        return WordArgumentResult.Success(word, 1)
    }

}
