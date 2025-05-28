import javax.sound.midi.SysexMessage;

public class B2_Fundamentals {

    // todos
    // 1. variables and constants
    // 2. primitive and reference types
    // 3. casting
    // 4. numbers, strings
    // 5. arrays
    // 6. inputs

    public static void main(String args[]) {

        // System.out.println("hello");
        // //variables
        // int age = 30;
        // System.out.println(age);

        // // reassignment
        // age = 10;
        // System.out.println(age);

        // // assignment to some other variable
        // int age2 = age;
        // System.out.println(age2);

    
    // PRIMITIVE DATATYPES
        /*
         * | Type | Size | Default Value | Range | Example |
         * |----------|----------|----------------|-----------------------------------|-
         * -------------------|
         * | byte | 1 byte | 0 | -128 to 127 | byte b = 100; |
         * | short | 2 bytes | 0 | -32,768 to 32,767 | short s = 3200; |
         * | int | 4 bytes | 0 | -2,147,483,648 to 2,147,483,647 | int i = 10000; |
         * | long | 8 bytes | 0L | -9,223,372,036,854,775,808 to | long l = 100L; |
         * | | | | 9,223,372,036,854,775,807 | |
         * | float | 4 bytes | 0.0f | ~±3.4e−038 to ±3.4e+038 | float f = 3.14f; |
         * | double | 8 bytes | 0.0d | ~±1.7e−308 to ±1.7e+308 | double d = 3.1415; |
         * | char | 2 bytes | '\u0000' | Unicode 0 to 65,535 | char c = 'A'; |
         * | boolean | ~1 bit* | false | true / false | boolean b = true; |
         */

        // boolean size is JVM-dependent, not precisely 1 bit.

        // byte num1 = 100;
        // short num2 = 10000;
        // int num3 = 1000000000;
        // long num4 = 1000000000000000000L; // the suffix L is necessary to tell
        // compiler that its a long, by default it's inferrered to as integer only.
        // System.out.println(num4);

        // float num5 = 12312.1123f; // need to specify the suffix f, to infer it to
        // float
        // double num6 = 13400003.5234234;
        // System.out.println(num5);
        // System.out.println(num6);

        // char alph = 'a';
        // System.out.println(alph);

        // boolean val = true;
        // System.out.println(val);


// Operators 
    // 1. arithmetic --> + ,- ,* ,/ ,% , ++ , --
    // 2. assignment --> ==, +=, -=
    // 3. logical  ---> &&, ||, !
    // 4. comparison --> <,>, <=, >=
    // 5. bitwise ---> &, |

    // 6. increment/decrement Operators
        // ++i  --> pre-increment
        // i++  --> post-increment
        // --i  --> pre-decrement
        // i--  --> post-decrement

        
// Java Operator Precedence Table (High → Low)
// Precedence  Operators Type Associativity
// 1	[] . ()	Access	Left to Right
// 2	++ -- (postfix)	Unary	Left to Right
// 3	++ -- + - ~ ! (prefix)	Unary	Right to Left
// 4	* / %	Arithmetic	Left to Right
// 5	+ -	Arithmetic	Left to Right
// 6	<< >> >>>	Bitwise shift	Left to Right
// 7	< <= > >= instanceof	Relational	Left to Right
// 8	== !=	Equality	Left to Right
// 9	&	Bitwise AND	Left to Right
// 10	^	Bitwise XOR	Left to Right
// 11	`	`	Bitwise OR
// 12	&&	Logical AND	Left to Right
// 13	`		`
// 14	?:	Ternary Conditional	Right to Left
// 15	= += -= *= /= etc.	Assignment	Right to Left
// 16	,	Comma	Left to Right
    

// output is governed by the datatype of the result
    System.out.println(7/4*9/2);    // o/p ==> 4  (int)
    System.out.println(7.0/4*9.0/2);    // o/p ==> 7.875  (int) 


// typecasting
    char grade = 'B';
    char encryptedGrade = (char)(grade + 8);    // int + char --> gives char as a result
    System.out.println(encryptedGrade);

    char decryptedGrade = (char)(encryptedGrade - 8);    // int + char --> gives char as a result
    System.out.println(decryptedGrade);


// (v*v - u*u)/2*a*s

    }
}
