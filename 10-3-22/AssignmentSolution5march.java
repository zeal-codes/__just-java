public class AssignmentSolution5march {
    public static void main(String[] args) {

    }
}

class Employee {
    int salary;
    String desig;
}

class Clerk extends Employee {
    Clerk() {
        salary = 12000;
        desig = "CLERK";
    }
}

class Programmer extends Employee {
    Programmer() {
        salary = 12000;
        desig = "PROGRAMMER";
    }
}

class Manager extends Employee {
    Manager() {
        salary = 30000;
        desig = "MANAGER";
    }
}