package command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class CommandProcessor {
    private final Map<String, Command> commands;

    public CommandProcessor() {
        commands = new HashMap<>();
    }

    public Set<String> getCommandsNames() {
        return commands.keySet();
    }

    public void addCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void processCommand(String commandName, Consumer<String> printTo) {
        var cmd = commands.getOrDefault(commandName, () -> "Command not recognized.");
        printTo.accept(cmd.executeAndDisplayResult());
    }
}

