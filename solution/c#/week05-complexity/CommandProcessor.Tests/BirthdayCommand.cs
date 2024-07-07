namespace CommandProcessor.Tests
{
    public class BirthdayCommand(Func<DateTime> todaySupplier, DateTime birthday) : ICommand
    {
        private readonly DateTime _today = todaySupplier();

        public string ExecuteAndDisplayResult()
        {
            var daysBetween = (birthday - _today).Days;
            if (daysBetween < 0) // If birthday passed this year
            {
                // Calculate days until next year's birthday
                var nextBirthday = birthday.AddYears(1);
                daysBetween = (nextBirthday - _today).Days;
            }

            return $"Still {daysBetween} days left!";
        }
    }
}