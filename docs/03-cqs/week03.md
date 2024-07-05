## Week 3: Command Query Separation.

### Defining the responsibilities

Whose responsibility is it?

In object-oriented programming (OOP), responsibility refers to the specific roles or behaviors assigned to an object. Each object in a system is responsible for managing its data and behaviors, known as methods, which interact with other objects. 

These behaviors or methods are identified as either commands or queries.

Commands change the state of the system.
Queries return information without altering the state. 

This distinction helps in designing predictable and reliable interactions within the system. The encapsulation of responsibility with the clear distinction between commands and queries ensures a modular, maintainable codebase.

> **A method is NOT supposed to do both.**

### How to assert properly

Assertions in unit testing insures the system is properly validated. It's important the assertions reflects the responsibility of the method and validates it accordingly. Look at the following graphic to help you assert correctly your code.

![CQS Assertions](img/assert.png)


### Exercise 1: Identify the issue and its consequences

Exercise => Head to the /exercise folder to the week 3 - exercise 1 to get the code version

Solution => Head to the /solution folder to the week 3 - exercise 1 to get the code version

### Exercise 2: Double-edge method

Exercise => Head to the /exercise folder to the week 3 - exercise 2 to get the code version

Solution => Head to the /solution folder to the week 3 - exercise 2 to get the code version

### Go Further: CQS Heuristics

The CQS principle can bring you several advantages such as code clarity, better testability and maintainability.

#### CQS Heuristics

Let's look at a formula to how we would do refactoring with CQS in mind.

- Identify Commands and Queries: Review your methods and categorize them as either commands (methods that change state) or queries (methods that return data).
Look at the signature to see if it returns a void or something.
Look at the code if there is any invariant change or external call.

- Refactor Mixed Methods: If you find methods that both change state and return data, refactor them into separate methods.

- Enforce Separation in New Code: When writing new code, ensure that you adhere to CQS by clearly distinguishing commands from queries.

- Use Clear Naming Conventions: Name your methods in a way that makes it clear whether they are commands or queries. Use this standard naming convention in all your code base.

#### Exceptions: Fluent APIs.

Fluent APIs returns its instance as well as change states in order to do chain calls for readability. It's a strategic decision, not a CQS breach.

Other patterns use such decision to mix state change and returning data.
