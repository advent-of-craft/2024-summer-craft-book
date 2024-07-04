export class Cache {
    private map: Map<string, number> = new Map<string, number>();

    getOrInsert(key: string, value: number): number {
        if (!this.map.has(key)) {
            this.map.set(key, value);
        }
        return this.map.get(key)!; // Modifies state if key not present and returns value
    }
}
