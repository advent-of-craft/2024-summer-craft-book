package command

class CommandProcessor {
    private val commands: MutableMap<String, Command> = mutableMapOf()

    val commandsNames: Set<String>
        get() = commands.keys

    fun addCommand(commandName: String, command: Command) {
        commands[commandName] = command
    }

    fun processCommand(commandName: String, printTo: (String) -> Unit) {
        val cmd = commands[commandName] ?: Command { "Command not recognized." }
        printTo(cmd.executeAndDisplayResult())
    }
}
