package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.ConsumerArgument

abstract class TextArgument: ConsumerArgument<String>() {
    abstract class WithTimes: ConsumerArgument.WithTimes<String>()
}
