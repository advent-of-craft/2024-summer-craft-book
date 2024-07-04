import {Command} from "./command";

export class ExitCommand implements Command {
    executeAndDisplayResult(): string {
        return 'Goodbye!';
    }
}