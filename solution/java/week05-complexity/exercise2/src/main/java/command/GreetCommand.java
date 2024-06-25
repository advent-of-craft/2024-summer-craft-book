package command;

class GreetCommand implements Command {
    private final String firstName;
    private final String lastName;

    public GreetCommand(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void execute() {
        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }
}
