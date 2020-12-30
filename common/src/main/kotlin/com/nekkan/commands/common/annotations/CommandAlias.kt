package com.nekkan.commands.common.annotations

/**
 * When used in a class, it defines the [labels] for the root command. Otherwise, if used in a function marked as
 * [Command], it will define the labels for the subcommand, in which are applied after the root command. For example,
 * in a Minecraft environment, the commands are represented in the following way:
 * ```
 * /rootcommand subcommand // for example, /hi player_name
 * ```
 */
annotation class CommandAlias(vararg val labels: String)
