export class FakeOutputAdapter {
    private allOutputs: string[] = [];

    getAllOutputs(): string {
        return this.allOutputs.join('\n');
    }

    sendOut(message: string): void {
        this.allOutputs.push(message);
    }
}