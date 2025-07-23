package OOPs.principals.inheritance;

public class InheritanceExamples {
    public static void main(String[] args) {
        // 1. Single Inheritance
        Dog d = new Dog();
        d.bark();          // From Dog
        d.eat();           // From Animal (parent)

        // 2. Multilevel Inheritance
        BabyDog bd = new BabyDog();
        bd.weep();         // From BabyDog
        bd.bark();         // From Dog
        bd.eat();          // From Animal

        // 3. Hierarchical Inheritance
        Cat c = new Cat();
        c.meow();          // From Cat
        c.eat();           // From Animal

        // 4. Multiple Inheritance using Interfaces
        Human h = new Human();
        h.walk();          // From Walkable
        h.talk();          // From Talkable

        // 5. Hybrid Inheritance (class + multiple interfaces)
        Android a = new Android();
        a.compute();       // From Machine
        a.talk();          // From Talkable
    }
}

//////////////////////
// 1. SINGLE INHERITANCE
//////////////////////

class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks.");
    }
}

//////////////////////
// 2. MULTILEVEL INHERITANCE
//////////////////////

class BabyDog extends Dog {
    void weep() {
        System.out.println("BabyDog weeps.");
    }
}

//////////////////////
// 3. HIERARCHICAL INHERITANCE
//////////////////////

class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows.");
    }
}

//////////////////////
// 4. MULTIPLE INHERITANCE using INTERFACES
//////////////////////

interface Walkable {
    void walk();
}

interface Talkable {
    void talk();
}

// A class implementing multiple interfaces
class Human implements Walkable, Talkable {
    public void walk() {
        System.out.println("Human walks.");
    }

    public void talk() {
        System.out.println("Human talks.");
    }
}

//////////////////////
// 5. HYBRID INHERITANCE
//////////////////////

class Machine {
    void compute() {
        System.out.println("Machine computing...");
    }
}

// Hybrid: class + interfaces
class Android extends Machine implements Talkable {
    public void talk() {
        System.out.println("Android talking like a human.");
    }
}
 {
    
}
