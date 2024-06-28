package command

class ExitCommand : Command {
    override fun executeAndDisplayResult(): String = "Goodbye!"
}
