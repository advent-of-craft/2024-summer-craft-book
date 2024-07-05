## Week 4: TDD.

### Understanding Test-Driven Development (TDD)

Test-Driven Development or TDD is a software development approach that relies on the repetition of a very short development cycle. The primary goal of TDD is to make the code clearer, simple, and bug-free. It is predicated on the test-first method, which emphasizes writing a test before writing the functional code itself.

### How TDD Works

TDD can be summarized in 3 main steps:
1) Write a Test (RED): Initially, the developer writes a test that defines a function or improvements of a function, which should initially fail because the function has not yet been developed.
2) Make it Run (GREEN): The next step is to write just enough code to make the test pass. This is where you ensure that the software behaves as expected.
3) Refactor: Once the test passes, the resulting code is refactored to acceptable standards. This might involve improving efficiency, removing duplications, and cleaning up poorly written code.

### Rules when using TDD (As per Robert Martin)

Three rules can be observed when you are working with TDD:
- No production code unless it is to make a failing unit test pass.
- No more of a unit test than is sufficient to fail (compilation also).
- No more production code than is sufficient to pass the one failing unit test.

### TDD Concepts

**Baby  Step**: the smallest possible change that can be verified and validated by your test. Meaning a change which does not break any test. The baby step ensures you are splitting up a big change in smaller more digestible steps and that you are building up confidence are you are coding your functionality. The resulting implementation should be fully understood and tested. You should not have any more code than necessary.

**Emerging design**: building your application from the smallest step to incorporate all the changes needed for your functionality will ultimately shape your final implementation. A specific design issued from multiple refactoring phases should therefore emerge.

**Example-based testing**: involves specifying concrete values or examples for inputs to functions or methods, and then checking if the output matches expected results for those inputs. It is a traditional approach where tests are created based on pre-defined examples that represent typical, boundary, or special case scenarios. The primary focus is to ensure that the software behaves correctly for given instances.

**Property-based testing**: takes a different approach by focusing on the properties that a function should satisfy rather than on individual examples. In this method, the system generates input data automatically, and tests are written to ensure that no matter what the input is, the output should satisfy certain properties. This helps uncover edge cases that example-based tests might miss, offering a more comprehensive assessment of potential bugs or errors in the system.

**Triangulation**: the triangulation is a TDD technique used to challenge your implementation by writing more than one example-based test to test one function of your program. You want your implementation to look a certain way but you lack the test for it. Writing a second failing test to trigger the change you want in your implementation is called triangulating.

**Double loop**: the double loop refers to the practice of nesting a smaller, inner loop of red-green-refactor cycles within a larger, outer loop that focuses on delivering functional software features incrementally. This approach helps ensure both the correctness of individual units and the integration of those units within the overall system.

### Exercise 1: Password Validation

Exercise => Head to the /exercise folder to the week 4 - exercise 1 to get the code version

Solution => Head to the /solution folder to the week 4 - exercise 1 to get the code version

### Go Further: The Mikado Method

Using the Mikado method with TDD can be a great way to map out the dependencies for a functionality. Let's imagine we are taking the password validation exercise from earlier and try to map out using the Mikado method. You first need to write down the functionality or test you want to iterate.

Here are the steps to implement such method:

- Try to do your change
- Check for regression
- Try trivial changes
- Check non regression tests pass
    - Commit if it passes
    - If the goal is achieved, close the tree
- If non regression tests fails
    - Add a dependency branch to your graph
    - Revert
    - Recurse on dependency

If you want to go further and do an entire refactoring kata using the Mikado method, you can click on the [link](https://yoan-thirion.gitbook.io/knowledge-base/software-craftsmanship/code-katas/mikado-method/mikado-kata)
