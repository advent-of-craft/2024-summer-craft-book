import {Command} from "./command";

export class CommandProcessor {
    private commands: Map<string, Command> = new Map<string, Command>();

    get commandsNames(): Set<string> {
        return new Set(this.commands.keys());
    }

    addCommand(commandName: string, command: Command): void {
        this.commands.set(commandName, command);
    }

    processCommand(commandName: string, printTo: (message: string) => void): void {
        const cmd = this.commands.get(commandName) || { executeAndDisplayResult: () => "Command not recognized." };
        printTo(cmd.executeAndDisplayResult());
    }
}