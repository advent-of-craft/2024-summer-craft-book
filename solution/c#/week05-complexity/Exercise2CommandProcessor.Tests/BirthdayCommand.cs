namespace Command.Tests;

public class BirthdayCommand(Func<DateTime> todaySupplier, DateTime birthday) : ICommand
{
    private readonly DateTime today = todaySupplier();

    public string ExecuteAndDisplayResult()
    {
        var daysBetween = (birthday - today).Days;
        if (daysBetween < 0)  // If birthday passed this year
        {
            // Calculate days until next year's birthday
            var nextBirthday = birthday.AddYears(1);
            daysBetween = (nextBirthday - today).Days;
        }
        return $"Still {daysBetween} days left!";
    }
}