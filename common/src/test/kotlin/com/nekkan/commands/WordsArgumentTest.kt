package com.nekkan.commands

import com.nekkan.commands.common.argument.asWordResult
import com.nekkan.commands.common.argument.ok
import com.nekkan.commands.common.argument.text.WordsArgument
import org.junit.jupiter.api.Test

class WordsArgumentTest {

    companion object {
        private const val firstWord = "AAAJKASJMKAS"
        private const val secondWord = "BCXVVXCJJKDSFOLJM"
        private const val thirdWord = "IFDFIDF"
        private const val string = "$firstWord $secondWord $thirdWord"
        private val list = listOf(firstWord, secondWord, thirdWord)
    }

    @Test
    fun `consume all words`() {
        val list = WordsArgument(3).parse(string).asWordResult().ok()
        require(list == Companion.list) {
            "Expected list was [${Companion.list.joinToString()}], but ${list.joinToString()} was provided."
        }
    }

}
