package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.*
import com.nekkan.commands.common.clear
import com.nekkan.commands.common.consumeWord
import com.nekkan.commands.common.dropWhitespaces
import com.nekkan.commands.common.hasEnded

data class WordsArgument(val times: Int): WordArgument() {

    companion object {
        val one = WordsArgument(1)
    }

    override fun CharSequenceConsumer.parse(): ArgumentResult<String> {
        @OptIn(ExperimentalStdlibApi::class)
        val words = buildList {
            repeat(times) {
                dropWhitespaces()
                if(hasEnded) {
                    return@parse unexpectedEnd<String>().asWordResult()
                }
                add(clear { consumeWord() })
            }
        }
        return WordArgumentResult.Success(words)
    }

}
