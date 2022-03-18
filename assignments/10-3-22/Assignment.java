
/**
 * ASSIGNMENT
 [*] restrict creation of object of Employee class.
 [*] no subclass can skip raiseSalary method
 [*] no one can override diplay method
 [*] keep count of number of employees created
 [*] no one can subclass from Clerk/Programmer/Manager
 [*] All classes should be part of emp.assignment package
 */

package emp.assignment;

import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        Employee e1 = new Clerk();
        e1.display();
        e1.raiseSalary();
        e1.display();
        Employee e2 = new Programmer();
        Employee e3 = new Manager();
        System.out.println("Number of working employees: " + Employee.employeeCount);
    }
}

abstract class Employee {// restrict creation of object of Employee class.
    static int employeeCount = 0;// keep count of number of employees created
    public String name;
    protected int age;
    protected int salary;
    public String designation;

    protected abstract void raiseSalary();// no subclass can skip raiseSalary method

    Employee() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Age: ");
        age = sc.nextInt();
        employeeCount++;
    }

    protected final void display() {// no one can override diplay method
        System.out.println();
        System.out.println("---------------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Designation: " + designation);

    }
}

final class Clerk extends Employee { // no one can subclass from Clerk/Programmer/Manager
    private int maxAllowedIncrement = 3000;

    Clerk() {
        salary = 12000;
        designation = "CLERK";
    }

    protected void raiseSalary() {
        salary += maxAllowedIncrement;
    }
}

final class Programmer extends Employee { // no one can subclass from Clerk/Programmer/Manager
    private int maxAllowedIncrement = 5000;

    Programmer() {
        salary = 30000;
        designation = "PROGRAMMER";
    }

    protected void raiseSalary() {
        salary += maxAllowedIncrement;
    }
}

final class Manager extends Employee { // no one can subclass from Clerk/Programmer/Manager
    private int maxAllowedIncrement = 10000;

    Manager() {
        salary = 90000;
        designation = "MANAGER";
    }

    protected void raiseSalary() {
        salary += maxAllowedIncrement;
    }
}