namespace Command;

public class ExitCommand : ICommand
{
    public string ExecuteAndDisplayResult()
    {
        return "Goodbye!";
    }
}