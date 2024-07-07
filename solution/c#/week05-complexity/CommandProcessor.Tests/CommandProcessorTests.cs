using Xunit;

namespace CommandProcessor.Tests
{
    public class CommandProcessorTests
    {
        private readonly CommandProcessor _processor = new();
        private readonly FakeOutputAdapter _output = new();

        [Fact]
        public void GreetCommandShouldGreetMe()
        {
            _processor.AddCommand("greet", new GreetCommand("jean", "dupont"));
            _processor.ProcessCommand("greet", _output.SendOut);
            Assert.Equal("Hello, jean dupont!", _output.AllOutputs());
        }

        [Fact]
        public void ExitCommandShouldSayGoodbye()
        {
            _processor.AddCommand("exit", new ExitCommand());
            _processor.ProcessCommand("exit", _output.SendOut);
            Assert.Equal("Goodbye!", _output.AllOutputs());
        }

        [Fact]
        public void HelpCommandShouldShowAllCommandsAvailable()
        {
            const string expected = "Here are all the available commands:\nexit\nhelp";
            _processor.AddCommand("exit", new ExitCommand());
            _processor.AddCommand("help", new HelpCommand(_processor.CommandsNames()));

            _processor.ProcessCommand("help", _output.SendOut);

            Assert.Equal(expected, _output.AllOutputs());
        }

        private static DateTime Today() => new(2024, 8, 4);

        [Fact]
        public void BirthdayCommandShouldTellYouHowManyDaysLeftBeforeYourBirthday()
        {
            DateTime birthday = new(2024, 8, 14); // Example birthday

            _processor.AddCommand("birthday", new BirthdayCommand(Today, birthday));
            _processor.ProcessCommand("birthday", _output.SendOut);
            Assert.Equal("Still 10 days left!", _output.AllOutputs());
        }
    }
}