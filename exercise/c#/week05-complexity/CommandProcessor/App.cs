namespace CommandProcessor
{
    public static class App
    {
        public static void Main(string[] args)
        {
            var cp = new CommandProcessor();

            // TODO: Should be able to pass my name to the command to say Hello to me!
            cp.ProcessCommand("greet"); // Outputs: Hello, World!
            cp.ProcessCommand("exit"); // Outputs: Exiting application...
            // TODO: Should display all commands available
            cp.ProcessCommand("help"); // Outputs: Unknown command
        }
    }
}