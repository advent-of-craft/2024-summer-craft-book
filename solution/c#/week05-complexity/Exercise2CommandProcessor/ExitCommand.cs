namespace Exercise2CommandProcessor
{
    public class ExitCommand : ICommand
    {
        public string ExecuteAndDisplayResult()
    {
        return "Goodbye!";
    }
    }
}