package command

import java.lang.System.lineSeparator

class FakeOutputAdapter {
    private val allOutputs: MutableList<String> = mutableListOf()

    fun getAllOutputs(): String = allOutputs.joinToString(lineSeparator())

    fun sendOut(message: String) {
        allOutputs.add(message)
    }
}
