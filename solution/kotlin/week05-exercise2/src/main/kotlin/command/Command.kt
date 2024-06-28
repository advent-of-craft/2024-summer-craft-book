package command

fun interface Command {
    fun executeAndDisplayResult(): String
}

