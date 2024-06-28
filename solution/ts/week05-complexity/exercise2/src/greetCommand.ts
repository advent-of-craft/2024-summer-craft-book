import {Command} from "./command";

export class GreetCommand implements Command {
    private readonly firstName: string;
    private readonly lastName: string;

    constructor(firstName: string, lastName: string) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    executeAndDisplayResult(): string {
        return `Hello, ${this.firstName} ${this.lastName}!`;
    }
}