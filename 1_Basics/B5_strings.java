import java.util.Arrays;
import java.util.Scanner;

public class B5_strings {
    
    // in java string is class
    public static void main(String[] args) {
        
        // can be defined both ways
            // String name = "nihal learns java";               // as normal datatype
            // String name1 = new String("nihal");     // as an object instance
            // name1 = "hello";
            // System.out.println(name);
            // System.out.println(name1);



    // Different print statements
        // String name2 = "nihal bhardwaj";
        // System.out.println("hello mr : ");   // prints and add a nextline
        //     System.out.println(name2);
        // System.out.print("hello Mr : ");      // simply prints, without adding nextline
        //     System.out.println(name2);

        // System.out.printf("hello mr %s", name2);        // C lang like syntax, where variables can be place using format specifiers

        // float num = 5.235532f;
        // System.out.printf("the num is : %.2f \n",num);  //mentioning bout how many digits after decimal to print

    
    // String user input
        // Scanner strInput = new Scanner(System.in);
        // System.out.print("Enter you name : ");
        // String inputName = strInput.nextLine();
        // System.out.println("hello mr : " + inputName);
        // strInput.close();       // avoid memory leak.


        
// STRING METHODS : 

// // Creation & Basic Info
    String str = "Hello";
//     System.out.println(str.length());       // 5
//     System.out.println(str.isEmpty());      // false
//     System.out.println("  ".isBlank());     // true (Java 11+)
//     System.out.println(str.charAt(1));      // 'e'
    System.out.println(Arrays.toString(str.toCharArray())); // [H, e, l, l, o]
    System.out.println(Arrays.toString(str.toCharArray()));
    System.out.println(Arrays.toString(str.split("")));
    System.out.println(Arrays.toString(str.getBytes()));    // Byte array


// // Search & Matching
    String str2 = "Java Programming";

//     System.out.println(str2.contains("Java"));       // true
//     System.out.println(str2.indexOf("a"));           // 1
    System.out.println(str2.lastIndexOf("a"));       // 10
//     System.out.println(str2.startsWith("Java"));     // true
//     System.out.println(str2.endsWith("ing"));        // true
//     System.out.println(str2.matches(".*Program.*")); // true


// // Substrings & Modification
//     String str3 = "Java Programming";

//     System.out.println(str3.substring(5));          // Programming
//     System.out.println(str3.substring(0, 4));       // Java
//     System.out.println(str3.replace("a", "@"));     // J@v@ Progr@mming
//     System.out.println(str3.replaceAll("\\s", "_")); // Java_Programming
//     System.out.println(str3.replaceFirst("a", "@")); // J@va Programming
//     System.out.println("   Hello  ".trim());        // Hello
//     System.out.println("   Hello  ".strip());       // Hello (Unicode-aware)
//     System.out.println("   Hello  ".stripLeading());// Hello  
//     System.out.println("   Hello  ".stripTrailing());//    Hello
//     System.out.println("Hello ".concat("World"));   // Hello World
//     System.out.println("Hi ".repeat(3));            // Hi Hi Hi  (Java 11+)


// // Comparison
    String a = "Java";
    String b = "java";

//     System.out.println(a.equals(b));              // false
//     System.out.println(a.equalsIgnoreCase(b));    // true

// The compareTo() method compares two strings lexicographically (dictionary order) and returns an integer:
// 0 → Strings are equal
// < 0 → Calling string is less than argument
// > 0 → Calling string is greater than argument
    System.out.println(a.compareTo("Jaba"));      // > 0
    System.out.println(a.compareToIgnoreCase(b)); // 0   

// // Case conversion
//     String str = "Java";

//     System.out.println(str.toUpperCase()); // JAVA
//     System.out.println(str.toLowerCase()); // java

// // 📦 Splitting & Joining
    String data = "apple,banana,cherry";

    String[] fruits = data.split(",");
// Java does not automatically print the contents of arrays. Instead, it prints the reference to the array object.
    System.out.println(fruits);                    //[Ljava.lang.String;@7ad041f3
        // [L = it's an array
        // java.lang.String = type of the array elements
        // @7ad041f3 = hash code of the array (in hex)

// Arrays.toString() is a utility method that formats the array contents as a readable string.
    System.out.println(Arrays.toString(fruits));  // [apple, banana, cherry]

    System.out.println(String.join(" | ", fruits)); // apple | banana | cherry



// // other utils
//     String s = new String("Java");
//     String poolString = s.intern();  // Refers to pooled string

//     System.out.println(poolString == "Java"); // true (same reference)

//     String formatted = String.format("Hi %s, age %d", "Nihal", 25);
//     System.out.println(formatted); // Hi Nihal, age 25

//     System.out.println(String.valueOf(123));   // "123"
//     System.out.println(String.valueOf(true));  // "true"


// Strings are IMMUTABLE
//here the output is harsh because the variable now points to some other memory location with value "harsh"
// nihal is still present in the memory
    // String str1 = "nihal";
    // str1 = "harsh";
    // System.out.println(str1);

    }
}
