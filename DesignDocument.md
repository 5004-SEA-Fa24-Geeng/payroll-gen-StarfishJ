# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.


## (INITIAL DESIGN): Class Diagram

Place your class diagram below. Make sure you check the fil in the browser on github.com to make sure it is rendering correctly. If it is not, you will need to fix it. As a reminder, here is a link to tools that can help you create a class diagram: [Class Resources: Class Design Tools](https://github.com/CS5004-khoury-lionelle/Resources?tab=readme-ov-file#uml-design-tools)
```mermaid
classDiagram
direction BT
class Arguments {
- Arguments()
- String employeeFile
- String payrollFile
- String timeCards
+ process(String[]) Arguments
+ getTimeCards() String
+ getPayrollFile() String
+ getEmployeeFile() String
+ printHelp() void
  }
  class Builder {
- Builder()
+ buildEmployeeFromCSV(String) IEmployee?
+ buildTimeCardFromCSV(String) ITimeCard
  }
  class Employee {
+ Employee(String, String, double, double, double, double)
# double payRate
# double taxRate
# String name
# String id
# double pretaxDeductions
# double ytdTaxesPaid
# double ytdEarnings
+ getYTDEarnings() double
+ getEmployeeType() String
+ getPayRate() double
+ getYTDTaxesPaid() double
+ runPayroll(double) double
+ toCSV() String
+ getName() String
+ getID() String
+ getPretaxDeductions() double
# calculateGrossPay(double) double
}
class FileUtil {
- FileUtil()
+ String EMPLOYEE_HEADER
+ String PAY_STUB_HEADER
+ writeFile(String, List~String~) void
+ writeFile(String, List~String~, boolean) void
+ readFileToList(String) List~String~
  }
  class HourlyEmployee {
+ HourlyEmployee(String, String, double, double, double, double)
- double OVERTIME_MULTIPLIER
- String EMPLOYEE_TYPE
+ getEmployeeType() String
# calculateGrossPay(double) double
}
class IEmployee {
<<Interface>>
+ getEmployeeType() String
+ getYTDEarnings() double
+ getID() String
+ getPretaxDeductions() double
+ getPayRate() double
+ toCSV() String
+ runPayroll(double) double
+ getName() String
+ getYTDTaxesPaid() double
  }
  class IPayStub {
  <<Interface>>
+ getTaxesPaid() double
+ getPay() double
+ toCSV() String
  }
  class ITimeCard {
  <<Interface>>
+ getHoursWorked() double
+ getEmployeeID() String
  }
  class PayStub {
+ PayStub(String, double, double, double, double)
- double ytdEarnings
- double ytdTaxesPaid
- double taxesPaid
- String employeeName
- double netPay
+ toCSV() String
+ getYtdEarnings() double
+ getPay() double
+ getTaxesPaid() double
+ getYtdTaxesPaid() double
  }
  class PayrollGenerator {
- PayrollGenerator()
- String DEFAULT_TIME_CARD_FILE
- String DEFAULT_PAYROLL_FILE
- String DEFAULT_EMPLOYEE_FILE
+ main(String[]) void
  }
  class SalaryEmployee {
+ SalaryEmployee(String, String, double, double, double, double)
- String EMPLOYEE_TYPE
+ getEmployeeType() String
# calculateGrossPay(double) double
}
class TimeCard {
+ TimeCard(String, double)
- double hoursWorked
- String employeeID
+ setEmployeeID(String) void
+ getHoursWorked() double
+ setHoursWorked(double) void
+ getEmployeeID() String
  }

  IEmployee <|.. Employee
  Employee <|-- HourlyEmployee
  Employee <|-- SalaryEmployee
  ITimeCard <|.. TimeCard
  IPayStub <|.. PayStub
  PayrollGenerator --> IEmployee : Uses
  PayrollGenerator --> ITimeCard : Uses
  PayrollGenerator --> IPayStub : Generates
  TimeCard --> IEmployee : Matches by employeeID
  PayrollGenerator --> FileUtil : Reads/Writes
```



## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that the `Employee` class properly returns `name` from `getName()`
2. Test that the `Employee` class properly returns `id` from `getId()`
3. continue to add your brainstorm here (you don't need to super formal - this is a brainstorm) - yes, you can change the bullets above to something that fits your design.

<pre>
package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    SalaryEmployee employee2;

    @BeforeEach
    void Setup(){
        employee2 = new SalaryEmployee("Joe Lee", "P002", 24000.0,10000.00, 2000.00,150.00);
    }

    @Test
    void getName() {
        assertEquals("Joe Lee", employee2.getName());
    }

    @Test
    void getID() {
        assertEquals("P002", employee2.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(24000.0, employee2.getPayRate());
    }
    @Test
    void runPayroll() {
        assertEquals(1972.42, employee1.runPayroll(100));
        assertEquals(657.48, employee2.runPayroll(100));
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,John Doe,P001,20.00,50.00,5000.00,100.00", employee1.toCSV());
        assertEquals("SALARY,Joe Lee,P002,24000.00,150.00,10000.00,2000.00", employee2.toCSV());
    }
</pre>


## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. Make sure you check the file in the browser on github.com to make sure it is rendering correctly. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect. 

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.
```mermaid
classDiagram
direction BT
class Arguments {
  - Arguments() 
  - String employeeFile
  - String timeCards
  - String payrollFile
  + getPayrollFile() String
  + process(String[]) Arguments
  + getTimeCards() String
  + printHelp() void
  + getEmployeeFile() String
}
class Builder {
  - Builder() 
  + buildEmployeeFromCSV(String) IEmployee?
  + buildTimeCardFromCSV(String) ITimeCard
}
class Employee {
  + Employee(String, String, double, double, double, double) 
  - double ytdEarnings
  - String name
  - double payRate
  - double pretaxDeductions
  - String id
  - double taxRate
  - double ytdTaxesPaid
  + getPretaxDeductions() double
  + runPayroll(double) double
  + getPayRate() double
  + getYTDTaxesPaid() double
  + calculateGrossPay(double) double
  + getID() String
  + toCSV() String
  + getName() String
  + getEmployeeType() String
  + getYTDEarnings() double
}
class FileUtil {
  - FileUtil() 
  + String PAY_STUB_HEADER
  + String EMPLOYEE_HEADER
  + writeFile(String, List~String~, boolean) void
  + writeFile(String, List~String~) void
  + readFileToList(String) List~String~
}
class HourlyEmployee {
  + HourlyEmployee(String, String, double, double, double, double) 
  - double OVERTIMEMULTIPLIER
  - String employeeType
  + calculateGrossPay(double) double
  + getEmployeeType() String
}
class IEmployee {
<<Interface>>
  + getName() String
  + getPretaxDeductions() double
  + runPayroll(double) double
  + getID() String
  + getPayRate() double
  + getEmployeeType() String
  + calculateGrossPay(double) double
  + toCSV() String
  + getYTDTaxesPaid() double
  + getYTDEarnings() double
}
class IPayStub {
<<Interface>>
  + getTaxesPaid() double
  + toCSV() String
  + getPay() double
}
class ITimeCard {
<<Interface>>
  + getEmployeeID() String
  + getHoursWorked() double
}
class PayStub {
  + PayStub(String, double, double, double, double) 
  - String employeeName
  - double netPay
  - double taxesPaid
  - double ytdEarnings
  - double ytdTaxesPaid
  + getYtdTaxesPaid() double
  + getYtdEarnings() double
  + getPay() double
  + getTaxesPaid() double
  + toCSV() String
}
class PayrollGenerator {
  - PayrollGenerator() 
  - String DEFAULT_TIME_CARD_FILE
  - String DEFAULT_EMPLOYEE_FILE
  - String DEFAULT_PAYROLL_FILE
  + main(String[]) void
}
class SalaryEmployee {
  + SalaryEmployee(String, String, double, double, double, double) 
  - String employeeType
  + getEmployeeType() String
  + calculateGrossPay(double) double
}
class TimeCard {
  + TimeCard(String, double) 
  - String employeeID
  - double hoursWorked
  + getHoursWorked() double
  + getEmployeeID() String
}

PayrollGenerator --> Arguments  : "uses"
PayrollGenerator --> IEmployee  : "uses"
PayrollGenerator --> ITimeCard  : "uses"
PayrollGenerator --> IPayStub   : "uses"

Builder --> IEmployee  : "creates"
Builder --> ITimeCard  : "creates"

Employee ..> IEmployee  : "implements"
HourlyEmployee --> Employee  : "inherits"
SalaryEmployee --> Employee  : "inherits"

PayStub ..> IPayStub  : "implements"

TimeCard ..> ITimeCard  : "implements"

FileUtil --> IEmployee  : "reads/writes"
FileUtil --> IPayStub   : "reads/writes"
FileUtil --> ITimeCard  : "reads/writes"
```




## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 
* The major change I make is changing my code in PayrollGenerator. I got confused about what elements to include in payStub object. I was trying to build a payStub object by referencing to employee object, but I don't know how to make the reference in detail. After checking the output I realize I just need to assign the parameter in PayRollGenerator and that's all. 
* Another part is remaking several functions as I kept getting errors in the output number. I didn't pay attention to the sequence of certain codes when I tried to update ytdEarnings in runPayroll method so the result was revised more than once. I also change some fields from protected to private to avoid unnecessary access.
* The most challenging part is debugging, as I have to add println in different places before tracking down the actual issue. I still feel it's difficult to have a general idea of which class should be in charge of what function while reading the instruction. 
* What I learned from this process is how to remove repetitive or redundant codes by using abstract classes and interfaces. And also I learned from practice and some key functions to help with the process.