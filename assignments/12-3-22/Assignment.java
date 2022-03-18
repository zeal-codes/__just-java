package emp.assigment;

import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        Employee employeeList[] = new Employee[100];
        int num = 0;
        System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
        while (loop) {
            System.out.println("Please enter the number corresponding to desired choice: ");
            System.out.println("---------------------------------------------------------");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.println("---------------------------------------------------------");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Employee e;
                    while (true) {
                        System.out.println("Select the type of employee: ");
                        System.out.println("---------------------------------------------------------");
                        System.out.println("1. Progammer");
                        System.out.println("2. Clerk");
                        System.out.println("3. Manager");
                        System.out.println("4. Exit");
                        System.out.println("---------------------------------------------------------");
                        System.out.print("Enter choice: ");
                        int type = sc.nextInt();
                        if (type == 4)
                            break;
                        e = Employee.createEmployee(type);
                        if (e == null)
                            continue;
                        employeeList[num] = e;
                        num++;
                        break;
                    }
                    break;
                case 2:
                    if (num == 0) {
                        System.out.println("No employees in company yet!");
                        break;
                    }
                    for (int i = 0; i < num; i++) {
                        System.out.println();
                        System.out.println("-----------------------");
                        System.out.println("Name: " + employeeList[i].name);
                        System.out.println("Salary: " + employeeList[i].salary);
                        System.out.println("Designation: " + employeeList[i].designation);
                        System.out.println("Age: " + employeeList[i].age);
                        System.out.println("-----------------------");
                        System.out.println();
                    }
                    break;
                case 3:
                    if (num == 0) {
                        System.out.println("No employees in company yet!");
                        break;
                    }
                    System.out.println();
                    System.out.println("Raising salaries of employees...");
                    for (int i = 0; i < num; i++) {
                        employeeList[i].raiseSalary();
                    }
                    break;
                case 4:
                    loop = false;
                    System.out.println();
                    System.out.println("Number of employees in the company: " + num);
                    break;
                default:
                    System.out.println("Please enter a valid choice!");
                    System.out.println();
            }
        }

    }
}

abstract class Employee {
    int age;
    String name;
    int incrementAmount;
    int salary;
    String designation;

    Employee() {
    }

    Employee(int age, String name, int amt, int sal, String desig) {
        this.age = age;
        this.name = name;
        incrementAmount = amt;
        salary = sal;
        designation = desig;
    }

    protected void raiseSalary() {
        this.salary += incrementAmount;
    }

    protected static Employee createEmployee(int type) {
        Scanner in = new Scanner(System.in);
        int ageIp = -1;
        String nameIp = "";
        if (type >= 1 && type <= 4) {
            System.out.print("Please enter name: ");
            nameIp = in.nextLine();
            System.out.print("Please enter age: ");
            ageIp = in.nextInt();
            System.out.println();
        }
        switch (type) {
            case 1:
                Employee newClerk = new Clerk(ageIp, nameIp);
                return newClerk;
            case 2:
                Employee newProgrammer = new Programmer(ageIp, nameIp);
                return newProgrammer;
            case 3:
                Employee newManager = new Manager(ageIp, nameIp);
                return newManager;
            default:
                System.out.println("Please enter a valid choice!");
                System.out.println();
                return null;
        }
    }
}

class Clerk extends Employee {
    static final int salary = 10000;
    static final String designation = "Clerk";
    static final int allowedIncrement = 3000;

    Clerk() {

    }

    Clerk(int age, String name) {
        super(age, name, allowedIncrement, salary, designation);
    }
}

class Programmer extends Employee {
    static final int salary = 30000;
    static final String designation = "Programmer";
    static final int allowedIncrement = 5000;

    Programmer() {

    }

    Programmer(int age, String name) {
        super(age, name, allowedIncrement, salary, designation);

    }
}

class Manager extends Employee {
    static final int salary = 90000;
    static final String designation = "Manager";
    static final int allowedIncrement = 10000;

    Manager() {

    }

    Manager(int age, String name) {
        super(age, name, allowedIncrement, salary, designation);
    }
}
