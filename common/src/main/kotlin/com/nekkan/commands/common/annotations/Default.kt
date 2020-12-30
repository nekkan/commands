package com.nekkan.commands.common.annotations

/**
 * Set a [Command] function as the [Default] command. This annotation should be paired with [CommandAlias] and [Command]
 * or a [NoSuchFieldException] will be thrown.
 */
@Target(AnnotationTarget.FUNCTION)
annotation class Default
