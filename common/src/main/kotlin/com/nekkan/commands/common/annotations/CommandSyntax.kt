package com.nekkan.commands.common.annotations

/**
 * Defines the syntax for a [Command]. If applied to a class, it will set the syntax when no parameters are passed.
 * If applied to a function that is marked as [Command], it will set the syntax for that only command. Usually,
 * this is applied to Minecraft, but you can use for other environments with other usages.
 */
annotation class CommandSyntax(val value: String)
