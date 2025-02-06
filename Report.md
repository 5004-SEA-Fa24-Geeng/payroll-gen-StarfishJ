# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?
* Comma-Separated Values. Each line in the file corresponds to a row in the table, and each value in the row is separated by a comma.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
* Using List<IEmployee> allows for flexibility and polymorphism. Since IEmployee is an interface, it can store different types of employees, such as HourlyEmployee and SalaryEmployee, making the code more scalable and maintainable.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
* a has-a relationship.
4. Can you provide an example of a has-a relationship in your code (if one exists)?
* PayStub has-a employeeName because PayStub contains an attribute storing the employee’s name.

5. Can you provide an example of an is-a relationship in your code (if one exists)?
* In my code, SalaryEmployee is-a Employee because it extends Employee.

6. What is the difference between an interface and an abstract class?
* Interfaces define a contract that classes must follow but do not provide any implementation. Abstract classes can have both implemented and unimplemented methods, allowing for some shared functionality while still being incomplete. A class can implement multiple interfaces, but it can extend only one abstract class.

7. What is the advantage of using an interface over an abstract class?
* More flexibility. A class can implement multiple interfaces, but it can extend only one abstract class; Interfaces promote loose coupling, making the code easier to maintain and extend; They define a strict contract that any implementing class must follow.
8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
* Not valid. Java does not support primitive types (int) in generics.Just replace int with Integer, `List<Integer> numbers = new ArrayList<>();`
9. Which class/method is described as the "driver" for your application?
* main method inside the PayrollGenerator class
10. How do you create a temporary folder for JUnit Testing? 
* @TempDir  
  Path tempDir;

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 
