## Week 5: Accidental Complexity.

### Conditionals increase complexity

Ways to reduce accidental complexity

Number of code bases suffer from accidental complexity. One of the cause for such complexity is the way we overuse conditionals.

Avoiding conditionals in code can significantly enhance its readability, maintainability, and error-resistance. Traditional conditional statements like if and else often make code verbose and complex, which can lead to errors and difficulties when debugging or extending the code. 

To avoid accidental complexity, several techniques are at your disposal:
- **Inheritance & polymorphism**: if 2 algorythms behave almost the same, you might want to consider creating a component with 2 implementations. 
- **Design patterns**: Like Strategy and Command patterns. They are basically a more complex version of the inheritance / polymorphism approach.
- **Nullable objects**: returning nullable objects can help reduce the conditionals.
- **Functional Programming Goodies**: Some FP techniques like Monads can help you handle an alternative state outside of the implementation itself reducing greatly the conditionals in your code.
- **Functional Maps**: a technique leveraging dictionaries or hash maps to associate keys directly with functions or values. It simplifies the logic by abstracting control flow into data, making the code more declarative and easier to understand

### Making your code predictable

Striving for predictable code is crucial on your journey. Doing so offers significant advantages, such as easier debugging, reduced maintenance costs, and enhanced scalability. 

Predictable code ensures consistent behavior, making it simpler to understand, test and modify. This reliability also improves team collaboration and the onboarding process for new developers, leading to more efficient development cycles.

This practice is fundamental for maintaining high quality and scalability in software projects.

### Exercise 1: Do not use if... else

Exercise => Head to the /exercise folder to the week 5 - exercise 1 to get the code version

Solution => Head to the /solution folder to the week 5 - exercise 1 to get the code version

### Exercise 2: Above and beyond conditionals

Exercise => Head to the /exercise folder to the week 5 - exercise 2 to get the code version

Solution => Head to the /solution folder to the week 5 - exercise 2 to get the code version

### Go Further: Ask another human

**Why collaborative programming ?**

Pair, mob, team or just in general collaborative programming involves at least 2 developers working on a single machine, on a single piece of code.

This is by far the best way to avoid accidental complexity. Not only will you have at least 2 brains working on a single subject but you won't have any opportunity to digress when coding. You won't take shortcut because you have a teammate and you likely won't stay stuck on a piece of code and miss something.

#### Different formats

**Pair programming** involves two developers working together at one workstation. One developer, the "driver," writes the code, while the other, the "navigator," reviews each line of code as it is written. The two programmers switch roles frequently (ideally every 10-15 minutes).
Benefits: Enhances code quality, improves knowledge sharing, and helps in problem-solving by leveraging two perspectives.

**Mob or team programming** extends the idea of pair programming to a whole team. All team members work together on the same task, at the same time, in the same space (or virtually), using a single computer.

**Peer review**: one or more developers review the code written by another developer. This process usually happens after the code is written and before it is merged into the main codebase.
Benefits: Identifies bugs, ensures adherence to coding standards, and facilitates knowledge transfer across the team.

#### Plugins

Tools such as the CodeWithMe plugin with the Intellij IDE can help you share a coding session with colleagues for an easy collaborative programming workshop.

