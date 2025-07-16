package OOPs;

import java.lang.reflect.Constructor;

public class Intro {
    public static void main(String[] args) {
        

    }
}

// todos : 
    // classes✅
    // instance✅
    // objects✅
    // dynamic memory allocation✅
    // constructors✅
    // default constructor✅
    // this keyword✅
    // constructor overloading✅
    // calling constructor from another constructor
        // Calling Constructor from Another Constructor (Constructor Chaining)
        // Sometimes you want one constructor to call another constructor in the same class to reuse code. 
        // In Java, id done using this().
        class Person {
            String name;
            int age;
            
            Person() {
                this("Unknown", 0); // Calls second constructor
            }
            
            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }  //if new Person() is created;, it will call the no-argument constructor, which then calls the second constructor.
    
        
    // new keyword, memory allocation✅


    // wrapper classes✅
        // Wrapper classes lets us treat primitive types as objects.
        // it lets us use various utility methods to manipulate the primitive values
            // int primitive = 5;
            // Integer object = Integer.valueOf(primitive); // Wrap int in Integer


    // final keyword✅
        // final can be applied to variables, methods, and classes:
            // Final variable: Value cannot be changed after it’s set.
            // Final method: Cannot be overridden by subclasses.
            // Final class: Cannot be inherited from.
                // final int x = 10;
            // x = 20; // Error: cannot assign
                // final class Animal {}
            // class Dog extends Animal {} // Error: cannot inherit



    // garbage collection ✅
        // Java automatically frees memory that’s no longer used (no need to manually delete objects).
        // The system tracks objects that cannot be referenced anymore and cleans them up to free space.


    // finalize✅
        // This is a special method you can define for cleanup actions just before the object is garbage-collected.
        // protected void finalize() throws Throwable {
        //     System.out.println("Object is being garbage collected!");
        // }


    // packages✅
        // A package is a namespace to organize classes (like folders for files). It helps avoid name conflicts.
            // e.g. package com.myapp.util;
        // To use a class from another package, import it:
            // import java.util.Scanner;


    // import✅
        // The import keyword is how we tell Java to bring in classes from other packages, so we don’t have to type the full path.

        

    // static keyword✅
        // static variable
            // A variable shared by all instances of a class (like a property common to all dogs: “species”).
            // class Dog {
            //     static String species = "Canine";
            // }

        // static methods
            // A method that belongs to the class, not an object. Call it without an instance.
                // class MathUtil {
                //     static int add(int a, int b) { return a + b; }
                // }
                // MathUtil.add(2,3);          // No need for MathUtil object


        // static block✅
            // A block that runs once when the class is loaded.
                // class Demo {
                //     static int x;
                //     static {
                //         x = 10; // Runs when class loads
                //     }
                // }


    // non-static member inside static
        // cannot directly access non-static (instance) variables/methods from a static method/block
                // class Test {
                //     int data;
                //     static void show() {
                //         // data = 10; // Error! Non-static in static
                //     }
                // }


    // static inside non-static
        // can use static members (variables/methods) inside non-static (instance) code
            // class Test2 {
            //     static int x;
            //     void display() {
            //         x = 5; // Allowed
            //     }
            // }
    // this keyword inside static
        // cannot use this (refers to current object) inside static methods/blocks, because there’s no "current object" when calling static methods.


    // initialization of static variables✅
        // can initialize static variables:
            // When declaring them
            // In a static block
                // static int x = 10;
                // static {
                //     x = 20;
                // }


    // inner classes✅
        // A class inside another class. Commonly used to group helper classes.
            // class Outer {
            //     class Inner {
            //         void display() { System.out.println("I'm inner!"); }
            //     }
            // }
            // Outer.Inner innerObj = new Outer().new Inner();
            // innerObj.display();



    // inbuilt java utils and classes, there internal workings✅
        // ArrayList: A resizable array. Internally, it uses an array that grows as needed.
        // HashMap: Stores key-value pairs. Uses hashing to quickly find values.
        // Scanner: Reads input (from keyboard, files, etc.).
        // String: Immutable sequence of characters (once created, cannot be changed).





    // singleton class
        // A design pattern to ensure only one instance of a class exists.

            // class Singleton {
            //     private static Singleton instance = null;
            //     private Singleton() {} // Private constructor

            //     public static Singleton getInstance() {
            //         if (instance == null) instance = new Singleton();
            //         return instance;
            //     }
            // }           //Any call to Singleton.getInstance() returns the same object.



    // principals of OOPS ✅
        // 1. inheritance - child class, super keyword, single, multiple, heirarchical, hybrid
        // 2. polymorphism - static vs dynamic polymorphism, overloading vs overriding
        // 3. encapsulation
        // 4. abstraction 
        // 5. Data hiding

    // access modifiers
        // public, private, protected and default modifiers✅
        // rules for modifiers
        // when to use which modifiers
        // protected modifier in detail, important notes
        // inbuild packages
        //     - io, util, lang, applet, awt, net
        // object class
        // object methods
        // hashcode methods
        // equals method
        // instanceof operator
        // getClass method
    
    // Abstract classes, interfaces and annotations ✅
        // Multiple Inheritance Problem
        // Abstract Classes
        // Example of Abstract Classes
        // Abstract Constructors
        // Object of an Abstract Class
        // Abstract Static Methods
        // Static Methods in Abstract Classes
        // "final" Keyword in Abstract Class
        // Multiple Inheritance using Abstract Classes
        // Interfaces
        // Example of Interfaces
        // Variable of Interface Type
        // Separate Classes in Same Interface
        // Extending Interfaces
        // Annotations
        // Important point regarding Static Interface methods
        // Nested Interfaces

        // generics
        // custom arraylist
        // lambda expressions
        // exception hanling
        // object cloning

        // collections framework
        // vector class
        // enums 
