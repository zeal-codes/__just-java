/**
 * Since methods in Interfaces are abstract => No ambiguity + Multiple allowed.
 * Interface supports multiple inheritance and not only added to support
 * multiple inheritance in Java.
 * Not really multiple inheritance.. Only when interfaces more than one
 * interfaces
 * Interface variables can hold the reference of a class object!!
 * Interfaces added :
 * -> to achieve security?? => Give client the interface and make
 * the server implement the code => Client clueless
 * Encapsulation : Hiding Data
 * -> Support OOPS concept - Abstraction : Hiding implementation details
 * -> To impose rules and regulations on classes which are extremely free to do
 * whatever they want.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        A a1 = new A();
        // I i1 = new I(); :: Nope no constructor allowed => no objs
        // i1.x = 30; :: Nope final by default + plus by default static
    }
}

class A {
    int x = 10;// Nahi init kia toh bhi chalega
    // public void work() :: Body cannot be skipped!

    public void work() {

    }

    A() {
    }
}

interface I {
    // int x; :: Must be initialized since no constructors to provide them values
    int x = 10; // By default static+public+final
    // Also no access modifiers allowed on variables, only public allowed!

    public void common();
    // public void common(){
    // Must not provide body. Are abstract by default i,e. no body.
    // }
}

// Usage of interface
class B implements I, J {
    // Must compulsorily implement abstract methods of interface or be declared
    // abstract itself
    public void common() {
        System.out.println("Implemented common!");
    }

    public void common2() {
        System.out.println("Implemented common!");
    }
}

interface J {
    // int y; :: Must be initialized since no constructors to provide them values
    int y = 10; // By default static+public+final
    // Also no access modifiers allowed on variables, only public allowed!

    public void common2();
    // public void common(){
    // Must not provide body. Are abstract by default i,e. no body.
    // }
}

// class C extends A{} :: Works fine. Everything borrowed from A
interface K extends I, J {
    // This is inheritance! => All shit given by I and J
    // Now if a class extends K => implement all the methods of I,J and K
}
