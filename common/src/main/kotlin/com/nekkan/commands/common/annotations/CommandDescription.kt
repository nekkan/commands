package com.nekkan.commands.common.annotations

/**
 * Defines the description for a [Command]. Usually used in Minecraft server environments when using the `/help`
 * command.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class CommandDescription(val value: String)
