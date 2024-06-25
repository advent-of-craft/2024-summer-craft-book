package command;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private static Map<String, Command> commands;

    public CommandProcessor() {
        commands = new HashMap<>();
    }

    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void processCommand(String commandName) {
        Command cmd = commands.getOrDefault(commandName, () -> System.out.println("Command not recognized."));
        cmd.execute();
    }

    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();
        // Create and register commands
        processor.addCommand("greet", new GreetCommand("Alice", "Johnson"));
        processor.addCommand("exit", new ExitCommand());
        processor.addCommand("help", new HelpCommand(commands));

        processor.processCommand("greet");  // Outputs: Hello, Alice Johnson!
        processor.processCommand("exit");   // Outputs: Goodbye!
        processor.processCommand("help");   // Outputs: Should be all commands' description
        processor.processCommand("invalid");   // Outputs: Command not recognized.
    }
}

