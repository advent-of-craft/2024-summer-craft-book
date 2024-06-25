package command;

import java.util.Map;

class HelpCommand implements Command {
    private final Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("Here are all the available commands:");
        commands.keySet().forEach(System.out::println);
    }
}
