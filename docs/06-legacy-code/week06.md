## Week 6: Legacy Code.

### Your code might be legacy

Identifying how a code becomes a debt

When we think of legacy code, we usually think of an old technology, monolith architecture and crazy indentations levels, abbreviated variables and implementation leaks all over the place.

Yet, we all do hot-fixes, sometimes on a daily basis without tests and instantly add to the technical debt of our project. Wouldn't you say this is legacy code?

As Martin Fowler puts it in his bool, Working effectively with Legacy Code:

        “To me, legacy code is simply code without tests.”

A well-written code with the best patterns and naming without the proper tests adds instantly to the amount of potential unsafe refactoring to your code. It becomes what we call a technical debt and, if not tended to, can fester and may need a considerable rework.

### The boy scout rule

One way to look at your code (or any code) is to say: How can I make this code better than when I found it?

 That is the Boy Scout Rule.

You don't have to refactor everything, all at once. Just scope small steps, tested, that will make your code better for the future developers. Better, share your changes with your colleagues and indulge in pair programming to lesser the code review time and have shorter feedback loops.

### Trust in your tests

When refactoring legacy code, you should trust your tests to ensure modifications don't introduce new bugs. Proper tests validate code behavior, offering a safety net that enables confident alterations. Trusting these tests allows you to maintain system integrity while improving code structure and performance. And remember the golden rule of refactoring:

     Do NOT start a refactoring without the proper tests

### How to tackle legacy code

Getting out of the mess.

Testing the code before you refactor might not be an option. Some circumstances might force you to rework the code without the proper tests suite. Here are some exceptions to the rule of thumb:
- Total inability to test my code (manual testing ?)
- Technical code that only has manual or semi-manual tests (a batch for instance)
- Auto-generated actions by the IDE that does not break the design (renaming, extracting, inlining, etc)
- Test code

### Approval Testing

A last resort solution.

A technique used to bypass the lack of testability is to use the approval testing or most commonly called the Golden Master tests.

The idea is to be able to make “snapshots” of your code as an expected and run the same snapshot of your code at a different time and compare them. If they are not the same, the test will fail.

The snapshot can be generated in many different way using the console output, a logging system or just the output of a method.


### Exercise 1: Put the code under tests

Exercise => Head to the /exercise folder to the week 6 - exercise 1 to get the code version

Solution => Head to the /solution folder to the week 6 - exercise 1 to get the code version

### Exercise 2: What's wrong here

Exercise => Head to the /exercise folder to the week 6 - exercise 2 to get the code version

Solution => Head to the /solution folder to the week 6 - exercise 2 to get the code version

### Go Further: Other Techniques for Testing Legacy Code

Often, you won't be able to test your code without making changes to it. Thus, you want to identify the steps you can take in your code that won't change its behavior.

**Extending Classes (Seams)**

When you identify a method that accesses the outside, such as getting information from a database or a singleton, it often involves hard-wired dependencies that make testing difficult. To address this, make the method overridable (virtual with some mocks) and override it inside the tests with a test double. This way, the new test class won't call the database, and you can mock your return. You can also add your own implementation details used for testing.

**Extract & Overloading Methods**

If your code is too tightly coupled to the implementation of its dependencies, you might not have a method that calls the outside, but everything will be procedural. One way to change that is to extract part of your code in a method that accesses the outside or a singleton, and then change the accessibility of the method so you can override it. This is similar to the technique mentioned above.

**Sprout Methods**

The sprout method involves adding new code by "sprouting" it into small, isolated methods or classes without altering the existing code structure. This approach minimizes the risk of introducing bugs into the legacy code and allows for new features to be implemented in a more controlled and manageable way.

- Identify where the new functionality is needed.
- Create a new method or class to implement the new functionality.
- Call the new method or class from the existing code at appropriate points.

All technics can be done automatically using your favorite IDE's shortcuts.


