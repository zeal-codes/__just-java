public class Assignment{
    public static void main(String[] args) {
        Employee e1 = new Employee("Raj", "SDE", 70000, 22);        
        Employee e2 = new Employee("Rahul", "SDET", 50000, 23);        
        Employee e3 = new Employee("Karan", "SDE-2", 90000, 24);        
        e1.display();
        e2.display();
        e3.display();
        e1.raiseSalary(5000);
        e2.raiseSalary(-5000);
    }
}

class Employee{
    private String name;
    private String designation;
    private int salary;
    private int age;
    public Employee(String name, String designation, int salary, int age) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.age = age;
    }
    public void display(){
        System.out.println("------------");
        System.out.println("Name: "+this.name);
        System.out.println("Designation: "+this.designation);
        System.out.println("Salary: "+this.salary);
        System.out.println("Age: "+this.age);
        System.out.println();
    }

    public void raiseSalary(int change){
        System.out.print("Old Salary: "+this.salary);
        this.salary += change;
        System.out.println(" New Salary: "+this.salary);
        if(change > 0){
            System.out.println(this.name+" recieved an increment of "+change+"rs.");
        }else{
            System.out.println(this.name+" recieved a decrement of "+Math.abs(change)+"rs.");

        }
        System.out.println();
    }
}