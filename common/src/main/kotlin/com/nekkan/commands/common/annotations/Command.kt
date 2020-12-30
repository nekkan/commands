package com.nekkan.commands.common.annotations

/**
 * Defines a [Command] in a class or function. This annotation should be paired with [CommandAlias] or a
 * [NoSuchFieldException] will be thrown. This annotation is optional for classes.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
annotation class Command
