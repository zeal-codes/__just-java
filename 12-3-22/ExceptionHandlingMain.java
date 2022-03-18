/**
 * Two classes of Runtime errors : Error, Exceptions
 * Errors cannot be handled by programmers and should compusoliry terminate the
 * program.
 * Unchecked : Not checked at compile time => happen at runtime.
 * Checked : Based on system resources (like DB,files) => prevents system
 * crashes --> Forces try-catch block/or ask it to be thrown to be handle parent
 * caller
 * 
 * Keywords to enforce exception handling :
 ** try:
 * - Encloses block of code prone to occurence of exception [Signs on road like
 * Accident Porn Area]
 * - Wear helmet to avoid accident and not try to get involved in accident
 * **************************************************************************
 ** catch: [Accident occured --> Goto appropriate doctor]
 * - catch(ArithmeticException e){}
 * - catch(NullPointerException e){}
 * - catch(IOException e){}
 * - catch(Exception e){} // Multi-speciality hospital :: handles any kind of
 * exception
 * - If no exception --> next line of catch execution continues.
 * - If exception --> try->catch->finally [if handled appropiately]
 * - If exception --> try->catch[not handled]->finally->terminated
 * **************************************************************************
 ** finally: WHATEVER HAPPENS THIS BLOCK ALWAYS EXECUTED [ex/no-ex/return/normal]
 * - If return in try block => finally block still executed
 * - IF IN TRY BLOCK : System.exit(0) => process terminated => Finally not
 * executed
 * - [God's Plan]
 * **************************************************************************
 ** throw: Manually raise an exception [suicide]
 * - Check if file not exist => throw FileNotFoundException => create the file
 * in catch block
 * - Where we want to use our own custom exception => throw it
 * - Like InsufficientBalanceException => in catch goto db and get valid amt and
 * show user
 * - Using throw keyword we can throw only 1 exception ---> 1st catch block
 * ***************************************************************************
 ** throws: Don't wanna tightly couple buisness logic and exception handling
 * - We specify the list of exceptions expected by the logic that wl not be
 * handled by the current method
 * - They wl be handled by the method that called the current method
 * - Hence the parent method wl be having the try-catch blocks [the exception
 * handling mech.]
 * - If not handled by any method --> Finally main method can also pass the
 * handling but JVM wl cause the program to terminate so don't pass it from main
 * - If not handled even in main => JVM handles with default exception handler
 * - JVM prints the :
 * --> Exception Name
 * --> Stack trace(execution flow/order of calling of methods)
 * --> (Finally terminates the program)
 * ****************************************************************************
 * 
 * Throwable class is the superclass of all errors and exceptions
 * subclass --> superclass [order of placing catch blocks]
 * We handle certain exceptions in one class and pass others to parent.. [not
 * compulsory to entirely pass]
 * 
 * Multiple Exception Handler :
 * Shud not be subclass of each other
 * catch(IOException | SQLException e){
 * ....................
 * }
 */

public class ExceptionHandlingMain {
    public static void main(String[] args) {
        try {
            // throw new UserException();// Default contructor called
            throw new UserException("JUST FOR DEMO"); // Paramaterized constructor called
        } catch (Exception e) {
            // TODO: handle exception
        }
        ;
    }
}

class UserException extends Exception {
    // extends RuntimeException ==> unchecked
    // Minimum 2 things to be done :
    // 2 constructors : 1 w/o param + 1 String param
    public UserException() {
        // Needed to be added becoz of String param constructor
    }

    public UserException(String msg) {
        // To specify the reason for occurence of reason
        super(msg);
    }

    void display() {
        // called using e.display()
    }
}

/**
 * ASSIGNMENT
 * java emp.assignment.EmpMain
 * ---------------------------
 * ----------------
 * 1.Create
 * 2.Display
 * 3.Raise Salary
 * 4.Exit
 * ----------------
 * 
 */