/**
 * Threads share resources -> context switching much easier v/s Processes
 * A thread is created only when we call start method on the thread obj
 * run() contains the logic a thread has to execute (vis-a-vis "psvm")
 * Only one thread runs at a time and others in queue <in single processor sys.>
 * 
 * 
 * 
 * Resources : CPU cycles,register,memory,etc.
 * MIN_PRIORITY - 1
 * NORM_PRIORITY - 5
 * MAX_PRIORITY - 10
 * a.setPriority(b.getPriority()+1) --> a always has higher priority than b
 * a.setName("___") && a.getName() --> "a" is just a reference but name stays
 * with a thread
 * Default name : Thread-i (i>=0)
 * wait :: notify/notifyAll :: suspend:resume
 * suspend and resume are methods of Thread class [DEPRECATED]
 * wait & notify(All) are methods of Object class
 * If within a synchronized block we wanna block/unblock thread then we use :
 * wait-notify(All)
 * If a thread is suspended and never resumed => program hangs and thread is in
 * coma!
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

public class MultithreadingMain {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        a.start();
        b.start();
        c.start();
        /**
         * WHY DOES MAIN EXIT GET PRINTED FIRST??
         * MAIN is itself a thread so no as such perma behaviour
         */
        System.out.println("MAIN EXIT");
    }
}