package command

class GreetCommand(private val firstName: String, private val lastName: String) : Command {
    override fun executeAndDisplayResult(): String = "Hello, $firstName $lastName!"
}