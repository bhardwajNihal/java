package OOPs;

import java.util.Objects;

import OOPs.principals.inheritance.Child;

// A class is a blue print to create objects
    // defines the structure and behaviour of the object.
    // Classes can include fields, methods, constructors, nested classes, and interfaces

    class Student {
        
        // attributes
        String name;
        int roll;

        // methods
        void call(){
            System.out.println("Hello my name is " + name + " and roll is " + roll);
        }
        
    }

    class Car {
        
        String brand;
        float price;

    // Constructors
        // A constructor is a special method used to initialize new objects.
        // It has the same name as the class and no return type.
        // Constructors can be parameterized or non-parameterized.

    // Constructor Overloading
        // Constructor overloading means having multiple constructors in the same class, each with different parameter lists.
        // This allows objects to be initialized in various ways
        Car(){
            brand = "suzuki";       // constructor is initialized with default assigned values
            price = 500000;
        }

    // The this keyword refers to the current object within a method or constructor.
    // It is commonly used to distinguish between class fields and parameters with the same name, or to call other constructors within the same class
        Car(String brand, float price){
            this.brand = brand;
            this.price = price;
        }

    // Default Constructor
        // If no constructor is defined, Java provides a default constructor that initializes fields to default values (0, null, false, etc.).
        // The default constructor takes no arguments and is only provided if no other constructor exists in the class.

        void print(){
            System.out.println("brand : " + this.brand + ", price : " + this.price);
        }
    }


public class ClassesAndObjects{
    
    public static void main(String[] args) {
        
    // Instantiating a class,
    // an instance is a specific realization of a class, 
    // typically an object created from the class using the new keyword.


    // Instance creates an object
        // An object is a runtime entity that has state (fields/attributes) and behavior (methods).
        // Objects are created from classes and interact with each other through method calls


    // DMA - Memory is dynamically allocated to Objects in the heap memory whenever instantiated using the new keyword.
    // The reference to the object is stored in the stack memory.
        
    // like in here 
        // an object s1 is instantiated from the Student class
        // new student object is created in the heap
        // reference variable s1 is stored in the stack
        Student s1 = new Student();
        s1.name = "nihal";      // manually allocating values to the attributes
        s1.roll = 21;
        s1.call();

    // object formed by default constructor, assigned default value
        Car c1 = new Car();
        System.out.println(c1.brand+ c1.price);     // null, 0.0


    // instantiating object by defined constructor
    Car c2 = new Car("mahindra", 1000000);
    System.out.println(c2);     // will call the default toString() method, will print some random hashed value
    
    // defined print method
    c2.print();;

    }
    
}
