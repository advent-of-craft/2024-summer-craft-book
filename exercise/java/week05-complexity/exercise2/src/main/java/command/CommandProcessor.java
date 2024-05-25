package command;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private Map<String, Command> commandMap;

    public CommandProcessor() {
        commandMap = new HashMap<>();
        commandMap.put("greet", () -> System.out.println("Hello, World!"));
        commandMap.put("exit", () -> System.out.println("Exiting application..."));
    }

    public void processCommand(String command) {
        if (commandMap.containsKey(command)) {
            commandMap.get(command).execute();
        } else {
            System.out.println("Unknown command");
        }
    }

    public static void main(String[] args) {
        CommandProcessor cp = new CommandProcessor();

        // TODO: Should be able to pass my name to the command to say Hello to me!
        cp.processCommand("greet");  // Outputs: Hello, World!
        cp.processCommand("exit");   // Outputs: Exiting application...
        // TODO: Should display all commands available
        cp.processCommand("help");    // Outputs: Unknown command
    }
}
