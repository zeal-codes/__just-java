/**
 * No access modifier : Scope := default
 * package is collection of interfaces and classes.
 * why to create a package?
 * - To avoid naming collision/clashes
 * - Visibility control
 * - Categorization based on functionality
 * - Reusability : literally using that file
 * cmd : javac -d . AccessModifiersMain.java
 * ............---- => make directory in current class
 * default : package scope
 * WRT TO CLASSMESH.png
 * public : A -> A B C D E F (All classes irrespective of package)
 * private : ONLY ALLOWED FOR MEMBER VARIABLES
 * protected : ONLY ALLOWED FOR MEMBER VARIABLES
 * only public available for classes.
 * CLASS LEVEL belongs to {(default),Public}
 * All 4 for all member vars : even inner classes!
 * protected : All classes of current package + all subclasses in other pacakges
 * private < (default) < protected < public [Indian economy since globalization]
 * default exist as a keyword (in switch block) but not as an access modifier
 * default modifier of class => NOT EVEN AVAILABLE TO THE SUBPACKAGES
 * 
 * 
 * ---NON-ACCESS-MODIFIERS---
 *  - static: can be modified by all objects but common to all objs + belongs to class
 *       * static methods can only access static variables directly
         * whatever is static, its executed/created by JVM at time of class loading
         * static method CANNOT be overriden.
         * We cannot use this/super keyword within the static block.
         
 *  - abstract: (given below) 
 *  - final: 
 *          * declaring constants  
            * final method => overriding NOT allowed 
            * final class CANNOT be extended

 * normal vars are created for each obj and each has its own copy.
 *
 */

/**
 * FamilyExample.jpg
 * A man with wife and 2 kids + 3rd najayaz
 * toothbrush - private
 * TV/wifi - (default)
 * Money/Netflix - protected
 * Open_Fridge_For_Poor - public
 */

// package com.abc.xyz; --> Specifying the package
// import com.abc.xyz.Demo --> Using the class
public class AccessModifiersMain {
    public static void main(String[] args) {

    }
}

class A { // Consider class A as public
    // WRT TO CLASSMESH.png
    public int x; // Available to all
    private int y; // Only available to A
    protected int z;// A,B,C,E,F
    int q;// A,B,C
}

class Person {
    public String name; // Known to all
    private String password; // Known to none
    protected String salarySlip; // Only familia
    int age; // Only khandan aur jaanne wale
}

/**
 * METHODS : with body + without body(required to be declared abstract)
 * Objects cannot be instantiated => Needs to be extended by come class (say C)
 * FORCES THE SUBCLASS TO IMPLEMENT THE ABSTRACT METHODS
 */
abstract class B {
    public void abc() {

    }

    public abstract void xyz();
}

/**
 * ASSIGNMENT
 * restrict creation of object of Employee class.
 * no subclass can skip raiseSalary method
 * no one can override diplay method
 * keep count of number of employees created
 * no one can subclass from Clerk/Programmer/Manager
 * All classes should be part of emp.assignment package
 */