package OOPs.principals.polymorphism.compileTime;

// Java decides at compile-time which method to call based on arguments.

public class MathUtils {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

class TestOverloading {
    public static void main(String[] args) {
        MathUtils mu = new MathUtils();
        System.out.println(mu.add(2, 3));          // int + int → 5
        System.out.println(mu.add(2.5, 3.5));      // double + double → 6.0
        System.out.println(mu.add(1, 2, 3));       // 3 ints → 6
    }
}
