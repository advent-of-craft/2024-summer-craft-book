package command

fun main() {
    val processor = CommandProcessor()
    // Create and register commands
    processor.addCommand("greet", GreetCommand("Alice", "Johnson"))
    processor.addCommand("exit", ExitCommand())
    processor.addCommand("help", HelpCommand(processor.commandsNames))

    processor.processCommand("greet", ::println)  // Outputs: Hello, Alice Johnson!
    processor.processCommand("exit", ::println)   // Outputs: Goodbye!
    processor.processCommand("help", ::println)   // Outputs: Should be all commands' description
    processor.processCommand("invalid", ::println)   // Outputs: Command not recognized.
}