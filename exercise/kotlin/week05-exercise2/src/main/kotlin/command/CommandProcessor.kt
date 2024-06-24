package command

class CommandProcessor {
    private var commandMap: MutableMap<String, Command> = HashMap()

    init {
        commandMap["greet"] = Command { println("Hello, World!") }
        commandMap["exit"] = Command { println("Exiting application...") }
    }

    fun processCommand(command: String) {
        if (commandMap.containsKey(command)) {
            commandMap[command]?.execute()
        } else {
            println("Unknown command")
        }
    }
}

fun main() {
    val cp = CommandProcessor()

    // TODO: Should be able to pass my name to the command to say Hello to me!
    cp.processCommand("greet")  // Outputs: Hello, World!
    cp.processCommand("exit")   // Outputs: Exiting application...
    // TODO: Should display all commands available
    cp.processCommand("help")   // Outputs: Unknown command
}
