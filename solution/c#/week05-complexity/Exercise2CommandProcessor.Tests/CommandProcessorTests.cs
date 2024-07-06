using Xunit;

namespace Exercise2CommandProcessor.Tests;

public class CommandProcessorTests
{
    private readonly CommandProcessor processor = new();
    private readonly FakeOutputAdapter output = new();

    [Fact]
    public void GreetCommandShouldGreetMe()
    {
        processor.AddCommand("greet", new GreetCommand("jean", "dupont"));
        processor.ProcessCommand("greet", output.SendOut);
        Assert.Equal("Hello, jean dupont!", output.GetAllOutputs());
    }

    [Fact]
    public void ExitCommandShouldSayGoodbye()
    {
        processor.AddCommand("exit", new ExitCommand());
        processor.ProcessCommand("exit", output.SendOut);
        Assert.Equal("Goodbye!", output.GetAllOutputs());
    }

    [Fact]
    public void HelpCommandShouldShowAllCommandsAvailable()
    {
        string expected = "Here are all the available commands:\nexit\nhelp";
        processor.AddCommand("exit", new ExitCommand());
        processor.AddCommand("help", new HelpCommand(processor.GetCommandsNames()));
        processor.ProcessCommand("help", output.SendOut);
        Assert.Equal(expected, output.GetAllOutputs());
    }
    
    private DateTime TodaySupplier() => new(2024, 8, 4);

    [Fact]
    public void BirthdayCommandShouldTellYouHowManyDaysLeftBeforeYourBirthday()
    {
        DateTime birthday = new(2024, 8, 14); // Example birthday

        processor.AddCommand("birthday", new BirthdayCommand(TodaySupplier, birthday));
        processor.ProcessCommand("birthday", output.SendOut);
        Assert.Equal("Still 10 days left!", output.GetAllOutputs());
        return;
    }

    
}