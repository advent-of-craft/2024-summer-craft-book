package command;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Supplier;

public class BirthdayCommand implements Command {
    private final LocalDate today;
    private final LocalDate birthday;

    public BirthdayCommand(Supplier<LocalDate> today, LocalDate birthday) {
        this.today = today.get();
        this.birthday = birthday;
    }

    @Override
    public String executeAndDisplayResult() {
        long daysBetween = ChronoUnit.DAYS.between(today, birthday);
        if (daysBetween < 0) {  // If birthday passed this year
            // Calculate days until next year's birthday
            daysBetween = ChronoUnit.DAYS.between(today, birthday.plusYears(1));
        }
        return "Still " + daysBetween + " days left!";
    }
}
