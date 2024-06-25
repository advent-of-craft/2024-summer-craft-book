import {Command} from "./command";

export class CommandProcessor {
    private commandMap: Map<string, Command>;

    constructor() {
        this.commandMap = new Map<string, Command>();
        this.commandMap.set("greet", { execute: () => console.log("Hello, World!") });
        this.commandMap.set("exit", { execute: () => console.log("Exiting application...") });
    }

    processCommand(command: string): void {
        if (this.commandMap.has(command)) {
            this.commandMap.get(command)!.execute();
        } else {
            console.log("Unknown command");
        }
    }
}

const cp = new CommandProcessor();
// TODO: Should be able to pass my name to the command to say Hello to me!
cp.processCommand("greet");  // Outputs: Hello, World!
cp.processCommand("exit");   // Outputs: Exiting application...
// TODO: Should display all commands available
cp.processCommand("help");   // Outputs: Unknown command