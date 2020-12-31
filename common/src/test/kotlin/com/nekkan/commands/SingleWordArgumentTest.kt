package com.nekkan.commands

import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.clear
import com.nekkan.commands.common.consumeDroppingWhitespaces
import com.nekkan.commands.common.consumeWord
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SingleWordArgumentTest {

    companion object {
        private const val firstWord = "AAAJKASJMKAS"
        private const val secondWord = "BCXVVXCJJKDSFOLJM"
        private const val thirdWord = "IFDFIDF"
        private const val string = "$firstWord $secondWord $thirdWord"
    }

    private val consumer = CharSequenceConsumer(string)

    /**
     * Alternative:
     * ```
     * @Test
     * @Suppress("RedundantWith")
     * fun `consume all words`() {
     *     val builder = StringBuilder()
     *     repeat(3) {
     *       consumer.dropWhitespaces()
     *       builder.append(consumer.clear { consumer.consumeWord() } + " ")
     *   }
     *    val value = builder.toString().removeSuffix(" ")
     *    require(value == string) { "Expected '$string', but '$value' was provided." }
    }
     * ```
     */
    @Test
    @Suppress("RedundantWith")
    fun `consume all words`() = assertDoesNotThrow {
        val first = consumer.clear { consumer.consumeWord() }
        val second = consumer.clear { consumer.consumeDroppingWhitespaces(1) }
        val third = consumer.clear { consumer.consumeDroppingWhitespaces(2) }
        val value = "$first $second $third"
        require(value == string) { "Expected '$string', but '$value' was provided." }
    }

}
