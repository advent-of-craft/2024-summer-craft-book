export class ReportData {
    private readonly id: number;
    private readonly value: number;
    private readonly description: string;

    constructor(id: number, value: number, description: string) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    getId(): number {
        return this.id;
    }

    getValue(): number {
        return this.value;
    }

    getDescription(): string {
        return this.description;
    }
}