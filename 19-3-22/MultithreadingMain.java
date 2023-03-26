/**
 * Threads share resources -> context switching much easier v/s Processes
 * A thread is created only when we call start() method on the thread obj
 * run() contains the logic a thread has to execute (vis-a-vis "psvm")
 * Only one thread runs at a time and others in queue <in single processor sys.>
 * wait :: notify/notifyAll :: suspend:resume
 * suspend and resume are methods of Thread class [DEPRECATED]
 * wait & notify(All) are methods of Object class
 * If within a synchronized block we wanna block/unblock thread then we use :
 * wait-notify(All)
 * If a thread is suspended and never resumed => program hangs and thread is in
 * coma!
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 19/03/22
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Resources : CPU cycles,register,memory,etc.
 * MIN_PRIORITY - 1
 * NORM_PRIORITY - 5 (default)
 * MAX_PRIORITY - 10
 * a.setPriority(b.getPriority()+1) --> a always has higher priority than b
 * a.setName("___") && a.getName() --> "a" is just a reference but name stays
 * with a thread
 * Default name : Thread-i (i>=0)
 * References : roles in life :: name : sticks for life
 * Thread.currentThread() gives the reference the thread executing in the
 * current scope
 * join() makes one thread to wait till the other completes
 * isAlive() tells if the thread is dead or alive(sleeping/working)
 * sysout(threadObj) ==> [threadName,priority,parentThreadName]
 * threadObj.join() ==> call makes caller of join method to wait of threadObj to
 * finish execution
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Runnable interface is used when ur class already extends a class
 * Thread class also implements Runnable => we override Runnable's run method
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * If you only implement Runnable and don't extend Thread => You don't have
 * access to start()
 * Hence we need to do : Thread tObj = new Thread(new OnlyRunnable())
 * 1 class --> n Threads [POSSIBLE]
 * 1 Object --> n Threads [ALSO POSSIBLE]
 * Observations on [Thread objects created from class implementing Runnable] :
 * -[1] All the different objects execute same block of code simultaneously
 * -[2] Single obj of class can help make multiple threads
 * -[3]
 * 
 * How to make a block of code single threaded in a multithreaded env?
 * Meaning allow only one thread to access the code while others have to wait.
 * ==> Use synchronized keyword with run method!
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Every thread obj has a key to the lock to its parent runnable class object
 * only i,e THREAD OBJECTS OF OTHER RUNNABLE CLASS OBJECTS DO NOT CARE FOR ITS
 * LOCK AND CAN ACCESS THE METHOD EVEN IF THE CURRENT THREAD HAS CONTROL OF IT
 * [Q] How to make sure brothers from different mothers share a single lock?
 * [A] WE REQUIRE CLASS LEVEL LOCKING
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Multiple threads from same mother ==> synchronized(this)
 * Multiple threads from different mother ==> synchronized(motherClass.class)
 * <-!- TO EXPLORE : TRY CLASS LEVEL LOCKING FOR THREADS WITH SAME MOTHER !-->
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * Daemon thread is a background thread. It has the least priority..
 * threadObj.isDaemon() --> return true if the thread runs in the background
 */

class A extends Thread {
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println("A: " + i);
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println("B: " + i);
        }
    }
}

class C extends Thread {
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println("C: " + i);
        }
    }
}

class notMyClass {
}

class alreadyExtendsAClass extends notMyClass implements Runnable {
    // We have to implement Runnable interface because we already extend a class
    public void run() {

    }

}

class onlyImplementsRunnableClass implements Runnable {
    // To execute the obj of this class as a thread we need to do the following
    /**
     * onlyImplementsRunnableClass myobj = new onlyImplementsRunnableClass()
     * Thread myObjRefThread = new Thread(myobj)
     * myObjRefThread.start(); // Works!
     */

    // <-------------------VERY IMPORTANT-------------------------------------->
    // THE BELOW ONLY WORKS IF WE CREATE THREAD OBJECTS FROM SINGLE RUNNABLE OBJECT
    // THE BELOW IS CALLED OBJECT LEVEL LOCKING
    synchronized public void run() { // synchronized => Jo pehle aya woh pura krke jayega
        // Until then no-one else is permitted to execute this block of code, PERIOD.
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 11; i++) {
            System.out.println("All I want for christmas: " + i);
        }
        // Lets say some code we want everyone to be able to access at the same time
        /**
         * // Eg : Filling of forms at the bank...
         * Everyone should be allowed to fill a form at the same time BUT
         * Only one customer will be entertained at a time
         * Hence remove synchronized keyword from method name but use it for a block
         * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         */

    }
}

// OBJECT LEVEL LOCKING : ALL OBJECTS OF THIS CLASS HAVE A KEY TO ONLY ONE LOCK
// ONLY IF THEIR MOTHER IS SAME
class onlyImplementsRunnableClass2 implements Runnable {// synchronized block example
    public void run() {
        // Code to be able to executed by all
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        // Only the one with the access key currently
        synchronized (this) {
            System.out.println("Currently Entered Thread: " + Thread.currentThread().getName());
            for (int i = 0; i < 11; i++) {
                System.out.println("All I want for christmas: " + i);
            }
        }
    }
}

// CLASS LEVEL LOCKING : ALL OBJECTS OF THIS CLASS HAVE A KEY TO ONLY ONE LOCK
// IRRESPECTIVE OF MOTHER OBJECT
class onlyImplementsRunnableClass3 implements Runnable {// synchronized block example
    public void run() {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        // onlyImplementsRunnableClass3.class ==> any object irrespective of mother
        // has to abide by only ONE lock
        synchronized (onlyImplementsRunnableClass3.class) {
            System.out.println("Currently Entered Thread: " + Thread.currentThread().getName());
            for (int i = 0; i < 11; i++) {
                System.out.println("All I want for christmas: " + i);
            }
        }
    }
}

public class MultithreadingMain {
    public static void main(String[] args) {
        Bike b1 = new Bike();

        // A a = new A();
        // B b = new B();
        // C c = new C();
        // a.start();
        // b.start();
        // c.start();
        /**
         * WHY DOES MAIN EXIT GET PRINTED FIRST??
         * MAIN is itself a thread so no as such perma behaviour
         */
        // b.join(); // Tells main thread to wait for b to complete its execution
        // System.out.println("MAIN EXIT");
        // onlyImplementsRunnableClass myObj = new onlyImplementsRunnableClass();
        // Thread t1 = new Thread(myObj);
        // Thread t2 = new Thread(myObj);
        // Thread t3 = new Thread(myObj);
        // // Without using synchronized keyword =>
        // // All enter same block of code at the same time!
        // t1.start();
        // t2.start();
        // t3.start();
    }
}