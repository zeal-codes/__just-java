/**
 * We can only extend only one class => Ambiguity if two super classes have the
 * same method
 * Having >1 methods with same and diff. params in the same class => Method
 * Overloading
 * Having same method (params+return type) in the parent class and different
 * functionality in the child class => Overriding
 * When a method is not present in the current class => goes thru super->super->
 * ... to find it
 * super.__ to access methods and variables of the super class
 * this.__ current class ke object ko access krne ke liye
 * By default every subclass constructor calls its super-class
 * (non-paramaterized) constructor! => Why? Because super() is added by compiler
 * in every constructor hence super class's non param called
 * Super class should either have the non-parameterized constructor or call the
 * super(...params) in subclass explicitly
 * Sir what if we want to prevent call to the super class constructor? Can we do
 * that?
 * => No... need to return without doing anything but the call cannot be
 * stopped bcoz all the variables inherited must be initialized by super class
 * before the child accesses them
 * Cannot call super() or this() in one constructor at the same time i,e. no-one
 * has preference over other
 * super class variable can refere to sub-class object but not vice-versa
 * 
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        B b1 = new B();
        // System.out.println(b1.x);
        A a2 = new B();// allowed since A constructor called by default
        // Also a2 is the object of B class! and just a variable of type A
        // Hence a2.abc() => B class abc() => Runtime decision as objects created at
        // runtime
        // Therefore Runtime Polymorphism!
        // B b3 = new A(); not allowed since B constructor nvr called
        /***************************** */
        runtimePolyExampleClass1 obj1 = new runtimePolyExampleClass1();
        obj1.abc();
        runtimePolyExampleClass1 obj2 = new runtimePolyExampleClass2();
        obj2.abc();
        runtimePolyExampleClass1 obj3 = new runtimePolyExampleClass3();
        obj3.abc();
    }
}

class A {
    int x = 10;

    A() {
        System.out.println("Default one");
    }

    A(int x) {
        System.out.println("A(int) :" + x);
    }

    A(String s) {
        System.out.println("A(String) :" + s);
    }

    void abc() {
        System.out.println("Hi");
    }
}

class B extends A {
    int x = 50;

    B() {
        super("ANY FKING VALUE");
        System.out.println("Default one");
    }

    B(int x) {
        this();
        System.out.println("B(int) :" + x);
    }

    B(String s) {
        System.out.println("B(String) :" + s);
    }

    void abc() {
        System.out.println(super.x);
        System.out.println("Hello");
    }
}

class runtimePolyExampleClass1 {
    public void abc() {
        System.out.println("Class 1");
    }
}

class runtimePolyExampleClass2 extends runtimePolyExampleClass1 {
    public void abc() {
        System.out.println("Class 2");
    }
}

class runtimePolyExampleClass3 extends runtimePolyExampleClass2 {
    public void abc() {
        System.out.println("Class 3");
    }
}