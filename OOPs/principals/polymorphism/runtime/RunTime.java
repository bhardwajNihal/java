package OOPs.principals.polymorphism.runtime;

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

public class RunTime {
    public static void main(String[] args) {

    // Java uses dynamic method dispatch:
    // Method calls are resolved at runtime based on object type, not reference type.

        Animal a;       // reference of parent class, object of child class

        a = new Dog();
        a.sound();  // Dog barks

        a = new Cat();
        a.sound();  // Cat meows


        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.draw();  // Drawing Circle
        s2.draw();  // Drawing Rectangle
    }
}


// final methods
// static methods (they are hidden, not overridden)
// private methods
// Constructors
        // - cannot be overriden



// Interface based polymorphism
// mimics multiple inheritance which is not supported by java natively
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class TestShapes {
    public static void main(String[] args) {
        
    }
}
