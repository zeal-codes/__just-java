/**
 * The public class should be named the file if used
 * Any class can have the main method, but we keep in the file named class for avoiding ambiguity in future
 * Constructors can have return statements (can't return values tho)
 * If any constructor provided by dev => No default added by compiler
 * Java ka internal constructor will always provide default values for instance variables.
 * number:0, boolean:false, object=null, characters="" [Default values]
 * 
 * 
 */
public class Main {
    public static void main(String[] args) {
        RoomArea r = new RoomArea();
        r.setArea(10, 20, 30);

    }
}

class Employee{
    private int salary;
    public void raiseSalary(int sal){
        this.salary = sal;
    }
    public void showSalary(){
        System.out.println(salary);
    }
}

class RoomArea{
    private int length;
    private int height;
    private int width;
    private int area;
    public void setArea(int len,int h,int w){
        this.length = len;
        this.height = h;
        this.width = w;
        this.area = len*h*w;
        showArea();
    }
    public void showArea(){
        System.out.println("New area is "+area+" of diimensions "+length+"x"+width+"x"+height+".");
    }
}
class Demo{
    // Compiler adds the default constructor and NOT JRE AND JVM
}