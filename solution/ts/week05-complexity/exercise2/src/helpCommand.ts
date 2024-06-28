import {Command} from "./command";

export class HelpCommand implements Command {
    private commandsName: Set<string>;

    constructor(commandsName: Set<string>) {
        this.commandsName = commandsName;
    }

    executeAndDisplayResult(): string {
        return `Here are all the available commands:\n${Array.from(this.commandsName).join('\n')}`;
    }
}