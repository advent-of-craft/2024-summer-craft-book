namespace Exercise2CommandProcessor
{
    public class GreetCommand(string firstName, string lastName) : ICommand
    {
        public string ExecuteAndDisplayResult()
    {
        return $"Hello, {firstName} {lastName}!";
    }
    }
}