import {Command} from "./command";

export class BirthdayCommand implements Command {
    private readonly today: () => Date;
    private readonly birthday: Date;

    constructor(today: () => Date, birthday: Date) {
        this.today = today;
        this.birthday = birthday;
    }

    executeAndDisplayResult(): string {
        let daysBetween = this.daysBetween(this.today(), this.birthday);

        if (daysBetween < 0) {
            const nextYearBirthday = new Date(this.birthday);
            nextYearBirthday.setFullYear(this.today().getFullYear() + 1);
            daysBetween = this.daysBetween(this.today(), nextYearBirthday);
        }
        return `Still ${daysBetween} days left!`;
    }

    private daysBetween(today: Date, other: Date) {
        return Math.ceil((other.getTime() - today.getTime()) / (1000 * 60 * 60 * 24));
    }
}