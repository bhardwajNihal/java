package OOPs.principals.inheritance;

public class Child {

    String name;
    int age;
    
    Child(String name, int age){
        this.name = name;
        this.age = age;
    }

    void callStudent(){
        System.out.println("my name is " + name + " and age is " + age);
    }

    public static void main(String[] args) {
        
        Student s1 = new Student("nihal", 21,10,99);
        s1.standard = 10;
        s1.roll = 21;
        System.out.println(s1.name+ s1.age+s1.roll+ s1.standard);
        s1.callStudent();
    }
}

class Student extends Child {

    // super keyword is necessary to be able to use parent classes attributes
        // Student(String name, int age) {
        //     super(name, age);
        // }
        int standard;
        int roll;

    Student(String name, int age,int standard, int roll){
        super(name, age);
        this.standard  = standard;
        this.roll = roll;
    }

    void callStudent(){
 System.out.println("hello my name is " + name + "roll :" +roll + age + standard);
    }
    
}