package com.nekkan.commands.common.argument.text

import com.nekkan.commands.common.argument.ConsumerArgument

abstract class TextArgument<T>: ConsumerArgument<T>() {
    abstract class WithTimes<T>: ConsumerArgument.WithTimes<T>()
}
