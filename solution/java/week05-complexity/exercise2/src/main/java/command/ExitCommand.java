package command;

class ExitCommand implements Command {
    @Override
    public String executeAndDisplayResult() {
        return "Goodbye!";
    }
}
