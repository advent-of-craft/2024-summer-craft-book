package command

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate
import java.util.function.Supplier

class CommandProcessorTests : StringSpec({
    lateinit var processor: CommandProcessor
    lateinit var output: FakeOutputAdapter

    beforeEach {
        output = FakeOutputAdapter()
        processor = CommandProcessor()
    }

    "greetCommandShouldGreetMe" {
        processor.addCommand("greet", GreetCommand("jean", "dupont"))
        processor.processCommand("greet", output::sendOut)
        output.getAllOutputs() shouldBe "Hello, jean dupont!"
    }

    "exitCommandShouldSayGoodbye" {
        processor.addCommand("exit", ExitCommand())
        processor.processCommand("exit", output::sendOut)
        output.getAllOutputs() shouldBe "Goodbye!"
    }

    "helpCommandShouldShowAllCommandsAvailable" {
        val expected = """
            Here are all the available commands:
            exit
            help
        """.trimIndent()
        processor.addCommand("exit", ExitCommand())
        processor.addCommand("help", HelpCommand(processor.commandsNames))
        processor.processCommand("help", output::sendOut)
        output.getAllOutputs() shouldBe expected
    }

    "birthdayCommandShouldTellYouHowManyDaysLeftBeforeYourBirthday" {
        val todaySupplier: Supplier<LocalDate> = Supplier { LocalDate.of(2024, 8, 4) }
        val birthday = LocalDate.of(2024, 8, 14)

        processor.addCommand("birthday", BirthdayCommand(todaySupplier, birthday))
        processor.processCommand("birthday", output::sendOut)
        output.getAllOutputs() shouldBe "Still 10 days left!"
    }
})
