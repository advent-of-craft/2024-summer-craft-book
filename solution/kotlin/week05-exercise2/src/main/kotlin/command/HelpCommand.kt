package command

import java.lang.System.lineSeparator

class HelpCommand(private val commandsName: Set<String>) : Command {
    override fun executeAndDisplayResult(): String =
        "Here are all the available commands:${lineSeparator()}${commandsName.joinToString(lineSeparator())}"
}
