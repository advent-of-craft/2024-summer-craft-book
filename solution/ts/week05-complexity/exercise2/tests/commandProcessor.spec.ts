import {CommandProcessor} from "../src/commandProcessor";
import {FakeOutputAdapter} from "./fakeOutputAdapter";
import {GreetCommand} from "../src/greetCommand";
import {ExitCommand} from "../src/exitCommand";
import {BirthdayCommand} from "../src/birthdayCommand";

describe('CommandProcessor', () => {
    let processor: CommandProcessor;
    let output: FakeOutputAdapter;

    beforeEach(() => {
        output = new FakeOutputAdapter();
        processor = new CommandProcessor();
    });

    it('greetCommandShouldGreetMe', () => {
        processor.addCommand('greet', new GreetCommand('jean', 'dupont'));
        processor.processCommand('greet', str => output.sendOut(str));

        expect(output.getAllOutputs()).toBe('Hello, jean dupont!');
    });

    it('exitCommandShouldSayGoodbye', () => {
        processor.addCommand('exit', new ExitCommand());
        processor.processCommand('exit', str => output.sendOut(str));

        expect(output.getAllOutputs()).toBe('Goodbye!');
    });

    it('birthdayCommandShouldTellYouHowManyDaysLeftBeforeYourBirthday', () => {
        const todaySupplier = () => new Date(2024, 7, 4);
        const birthday = new Date(2024, 7, 14);

        processor.addCommand('birthday', new BirthdayCommand(todaySupplier, birthday));
        processor.processCommand('birthday', str => output.sendOut(str));

        expect(output.getAllOutputs()).toBe('Still 10 days left!');
    });
});