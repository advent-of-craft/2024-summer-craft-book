## Week 7: Property-based Testing.

### Different Type of Testing

#### Example-based testing

By default, we test using example-based expectations. We pass into our system an input by calling a behavior of a component and we check the output, whether it be a data we can read or verify a task from a mock that is being triggered. This approach is straightforward and effective for functions or methods where the outputs are predictable and can be defined in advance. Anyone who is familiar with unit tests and has written one knows what example-based testing is.

#### Parameter-based testing

Parameter-based testing allows you to run the same test with different values without duplicating code. It is useful for covering a range of scenarios and ensuring that your method behaves correctly with various inputs.

#### Property-based testing

Property-based testing involves checking that certain properties hold true for all valid inputs. It uses algorithms to generate inputs dynamically, testing the robustness of the function beyond fixed data sets. Different libraries can be used to achieve that. Here an example is the vavr library.

### Exercise 1: Thousands of tests in one

Exercise => Head to the /exercise folder to the week 7 - exercise 1 to get the code version

Solution => Head to the /solution folder to the week 7 - exercise 1 to get the code version

### Go Further: Property-based and TDD

Using Property to drive your development with TDD can yield great results. 

Look at the tests and implementation to see how you can extract common behavior and test them without using examples.

Here are the steps to implement such method:

- Red Phase:
Write a property that should fail initially.
For instance, "a sorted list should remain sorted after sorting again".

- Green Phase:
Implement the minimal code required to pass the property.
Run the property tests to ensure the code passes for a wide range of inputs.

- Refactor Phase:
Refactor the code while ensuring the properties continue to hold true.
Run the property tests again to verify correctness.


**Combining Example-Based and Property-Based Testing**:

Use property-based tests to cover a wide range of inputs and general properties.
Use example-based tests for specific edge cases, known bugs, or critical scenarios.

An example of how you could start for the Diamond kata:

Horizontally symmetric
for all (validCharacter in [A-Z])
such that diamond(validCharacter) == reverse(diamond(validCharacter))

A Diamond is a square (height = width)
for all (validCharacter)
such that diamond(validCharacter) is a square

2 identical letters per line
for all (validCharacter)
such that each line in diamond(validCharacter) contains 2 identical letters except first and last 

To try the property driven development on an exercise, you can do the day 21 of the 2023's Advent of Craft [here](https://github.com/advent-of-craft/2023/blob/main/docs/exercise/day22/challenge.md).
