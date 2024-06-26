package command;

import org.junit.Assert;
import org.junit.Test;

public class AppTests {
    @Test
    public void displayAllCommands(){
        String expectedOutput = """
                Hello, Alice Johnson!
                Goodbye!
                Here are all the available commands:
                exit
                help
                greet
                Command not recognized.""";

        var output = new FakeOutputAdapter();
        CommandProcessor processor = new CommandProcessor();

        processor.addCommand("greet", new GreetCommand("Alice", "Johnson"));
        processor.addCommand("exit", new ExitCommand());
        processor.addCommand("help", new HelpCommand(processor.getCommandsNames()));

        processor.processCommand("greet", output::sendOut);  // Outputs: Hello, Alice Johnson!
        processor.processCommand("exit", output::sendOut);   // Outputs: Goodbye!
        processor.processCommand("help", output::sendOut);   // Outputs: Should be all commands' description
        processor.processCommand("invalid", output::sendOut);   // Outputs: Command not recognized.

        Assert.assertEquals(expectedOutput, output.getAllOutputs());
    }
}
