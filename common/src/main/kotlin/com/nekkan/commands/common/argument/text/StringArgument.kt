package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.ArgumentResult
import com.nekkan.commands.common.argument.CharSequenceConsumer
import com.nekkan.commands.common.argument.success
import com.nekkan.commands.common.argument.unexpectedEnd
import com.nekkan.commands.common.consumeAll
import com.nekkan.commands.common.hasEnded

object StringArgument: TextArgument<String>() {

    override fun CharSequenceConsumer.parse(): ArgumentResult<String> {
        if(hasEnded) {
            return unexpectedEnd()
        }
        consumeAll()
        return success()
    }

}
