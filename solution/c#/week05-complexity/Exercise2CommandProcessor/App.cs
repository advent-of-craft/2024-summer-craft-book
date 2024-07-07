namespace Exercise2CommandProcessor
{
    public static class App
    {
        public static void Main()
    {
        var processor = new CommandProcessor();
        // Create and register commands
        processor.AddCommand("greet", new GreetCommand("Alice", "Johnson"));
        processor.AddCommand("exit", new ExitCommand());
        processor.AddCommand("help", new HelpCommand([..processor.GetCommandsNames()]));

        processor.ProcessCommand("greet", Console.WriteLine);  // Outputs: Hello, Alice Johnson!
        processor.ProcessCommand("exit", Console.WriteLine);   // Outputs: Goodbye!
        processor.ProcessCommand("help", Console.WriteLine);   // Outputs: Should be all commands' description
        processor.ProcessCommand("invalid", Console.WriteLine);   // Outputs: Command not recognized.
    }
    }
}