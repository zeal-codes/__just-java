import java.util.*;

public class Assignment {
    public static void main(String[] args) {
        Employee e1 = new Clerk();
        Employee e2 = new Programmer();
        Employee e3 = new Manager();
        e1.display();
        e2.display();
        e3.display();
        e1.raiseSalary();
    }
}

class Employee {
    private String name;
    private int age;
    private int salary;
    private String designation;
    private int incrementAmount;

    public Employee(int salary, String designation, int incrementAmount) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        while (true) {
            System.out.print("Enter the name of new employee : ");
            String name = sc.nextLine();
            if (name.length() == 0) {
                System.out.println("Please enter a valid name");
            } else {
                this.name = name;
                break;
            }
        }
        while (true) {
            System.out.print("Enter the age of new employee : ");
            int age = sc.nextInt();
            if (age < 18 || age > 60) {
                System.out.println("Please enter a valid age");
                System.out.println();
            } else {
                this.age = age;
                break;
            }
        }
        this.salary = salary;
        this.designation = designation;
        this.incrementAmount = incrementAmount;
        System.out.println();
    }

    public void display() {
        System.out.println("------------");
        System.out.println("Name: " + this.name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + this.age);
        System.out.println();
    }

    public void raiseSalary() {
        System.out.print("Old Salary: " + this.salary);
        this.salary += incrementAmount;
        System.out.println(" New Salary: " + this.salary);
        System.out.println(this.name + " recieved an incremnt of " + incrementAmount + "rs.");
        System.out.println();
    }
}

interface ClerkInterface {
    String designation = "CLERK";
    int salary = 12000;
    int incrementAmount = 3000;
}

interface ProgrammerInterface {
    String designation = "PROGRAMMER";
    int salary = 30000;
    int incrementAmount = 5000;
}

interface ManagerInterface {
    String designation = "MANAGER";
    int salary = 90000;
    int incrementAmount = 10000;
}

class Clerk extends Employee implements ClerkInterface {
    public Clerk() {
        super(salary, designation, incrementAmount);
    }

}

class Programmer extends Employee implements ProgrammerInterface {
    public Programmer() {
        super(salary, designation, incrementAmount);
    }

}

class Manager extends Employee implements ManagerInterface {
    public Manager() {
        super(salary, designation, incrementAmount);
    }

}
