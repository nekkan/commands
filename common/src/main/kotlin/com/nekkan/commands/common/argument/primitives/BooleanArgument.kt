package com.nekkan.commands.common.argument.primitives

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.failure
import com.nekkan.commands.common.argument.success
import com.nekkan.commands.common.argument.text.SingleWordArgument

data class BooleanArgument(
    private val `true`: String = "true",
    private val `false`: String = "false",
    private val ignoreCase: Boolean = true
): SingleWordArgument<Boolean>() {

    override fun CharSequenceConsumer.parse(word: String): ArgumentResult<Boolean> {
        return when {
            `true`.equals(word, ignoreCase) -> success(true)
            `false`.equals(word, ignoreCase) -> success(false)
            else -> failure("Expected '$`true`' or '$`false`', but '$word' was provided.")
        }
    }

}
