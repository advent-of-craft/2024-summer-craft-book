package command;

public class App {
    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();
        // Create and register commands
        processor.addCommand("greet", new GreetCommand("Alice", "Johnson"));
        processor.addCommand("exit", new ExitCommand());
        processor.addCommand("help", new HelpCommand(processor.getCommandsNames()));

        processor.processCommand("greet", System.out::println);  // Outputs: Hello, Alice Johnson!
        processor.processCommand("exit", System.out::println);   // Outputs: Goodbye!
        processor.processCommand("help", System.out::println);   // Outputs: Should be all commands' description
        processor.processCommand("invalid", System.out::println);   // Outputs: Command not recognized.
    }
}

