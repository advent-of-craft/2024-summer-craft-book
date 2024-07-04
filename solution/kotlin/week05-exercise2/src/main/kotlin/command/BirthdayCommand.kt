package command

import java.time.LocalDate
import java.time.temporal.ChronoUnit.DAYS
import java.util.function.Supplier

class BirthdayCommand(private val today: Supplier<LocalDate>, private val birthday: LocalDate) : Command {
    override fun executeAndDisplayResult(): String = "Still ${daysUntilBirthday()} days left!"

    private fun daysUntilBirthday(): Long =
        DAYS.between(today.get(), birthday)
            .let {
                if (it < 0) return DAYS.between(today.get(), birthday.plusYears(1))
                else return it
            }
}
