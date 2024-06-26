package command;

import java.util.Map;
import java.util.Set;

class HelpCommand implements Command {
    private final Set<String> commandsName;

    public HelpCommand(Set<String> commandsName) {
        this.commandsName = commandsName;
    }

    @Override
    public String executeAndDisplayResult() {
        var result = "Here are all the available commands:\n";
        result += String.join("\n", commandsName);
        return result;
    }
}
