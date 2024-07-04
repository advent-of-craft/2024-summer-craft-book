package command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.function.Supplier;

public class CommandProcessorTests {
    CommandProcessor processor;
    FakeOutputAdapter output;

    @BeforeEach
    public void setup(){
        output = new FakeOutputAdapter();
        processor = new CommandProcessor();
    }

    @Test
    public void greetCommandShouldGreetMe(){
        processor.addCommand("greet", new GreetCommand("jean", "dupont"));
        processor.processCommand("greet", output::sendOut);
        Assertions.assertEquals("Hello, jean dupont!", output.getAllOutputs());
    }

    @Test
    public void exitCommandShouldSayGoodbye(){
        processor.addCommand("exit", new ExitCommand());
        processor.processCommand("exit", output::sendOut);
        Assertions.assertEquals("Goodbye!", output.getAllOutputs());
    }

    @Test
    public void helpCommandShouldShowAllCommandsAvailable(){
        String expected = """
                Here are all the available commands:
                exit
                help""";
        processor.addCommand("exit", new ExitCommand());
        processor.addCommand("help", new HelpCommand(processor.getCommandsNames()));
        processor.processCommand("help", output::sendOut);
        Assertions.assertEquals(expected, output.getAllOutputs());
    }

    @Test
    public void birthdayCommandShouldTellYouHowManyDaysLeftBeforeYourBirthday(){
        Supplier<LocalDate> todaySupplier = () -> LocalDate.of(2024, 8, 4); ;  // Supplier using method reference
        LocalDate birthday = LocalDate.of(2024, 8, 14);  // Example birthday

        processor.addCommand("birthday", new BirthdayCommand(todaySupplier, birthday));
        processor.processCommand("birthday", output::sendOut);
        Assertions.assertEquals("Still 10 days left!", output.getAllOutputs());
    }
}
