/**
 * Arrays are objects in java <== Uses new keyword for initialization +
 * predefined attributes on it like .length
 * int a[], int d[] = new int[5] ==> Only syntaxes correct in java
 * int c[5] = new int[] --> [wrong] cuz size not specified for new keyword
 * int c[] = new int[] --> [wrong] cuz size not specified for new keyword
 * int f[5] = new int[5] --> [wrong] cuz size cannot be specified for LHS
 * 
 * int arr[] = {11,22,33,44,55} --> Array intialized
 * 
 * int[] a; --> Allowed in java too. => int[] a = new []int;
 * int[][] a,b,c,d,e --> correct and shorter syntax v/s int a[][],int b[][],....
 * what if a,d->2d and b,c,e->1d ==> int[] a[],b,c,d[],e;
 * intialization syntax remains same for both.
 */

class Emp {
    String name;
}

public class ArrayMain {
    public static void main(String[] args) {
        // Emp e --> can hold only Emp objects
        // Emp e[] = new Emp[5] --> can hold 5 Emp objects
        Emp e[] = new Emp[5]; // --> 0 OBJECTS CREATED ! since no constructor called
        // e[0].name = "A";// NullPointerException as no object referernce given to e[0]
        // e[1].name = "B"; // Runtime error!
        // e[2].name = "C";// Valid shit --> e[2] = new Emp();
        // e[3].name = "D";
        // e[4].name = "E";
    }
}

/**
 * forEach loop
 * for(int x : num) --> get every ele of the arr
 * Performance wise better for all-element iteration --> no condition checking
 * like traditional for-loop
 */

/**
 * We don't have multi-dimensional arrays in java. --> Internally single dim
 * arrays connected to behave like multidimensional arrays
 * int md[][] = new int[2][3]; --> Correct!
 * But then why?? =>
 * - C++ allocates for all 6 => i,e. restricts column definition i,e.
 * multidimension fixed
 * - But in Java we can skip column number declaration!
 * - meaning int md[][] = new int[6][]; ---> Valid in Java
 * Then we can do md[i] = new int[x];
 * In C++ int* arr[6] can do a similar thing.
 * Also called Jagged arrays.
 */