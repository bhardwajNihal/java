package mockvita;

public class Q4 {

//     FaultySegment
// Problem Description
// Gagan, along with his friend, recently launched a small firm that manufactures basic calculators, which use seven-segment displays to show results.

// One day, an employee brought a faulty calculator to Gagan, reporting that it was giving incorrect results due to a software glitch. After analysing its behaviour, Gagan discovered that it wasn't a software issue but rather a flaw in the 7-segment display, where one of the LEDs was malfunctioning.

// So, Gagan thought of finding the LED which is malfunctioning.

// The calculator only has buttons for the digits 0-9 and the symbols +, -, %, =, and *. When clicked, these buttons will display their respective symbols as a seven-segment display, represented by a 3x3 matrix.

// The arrangement of 7 segment display for each number from 0-9 and for the five mathematical operators is shown below.


// Given the equation that Gagan typed and the current display on the calculator, determine which character corresponds to the LED that should be toggled to make the equation correct.

// Note: Solve the equation sequentially from left to right, without considering the precedence of operators.

// Constraints
// 5 <= N <= 30

// It is guaranteed that RHS or the equal to symbol will not be faulty.

// RHS will not have any operators.

// It is guaranteed that all the testcases will have only one solution.

// Input
// First line consists of N denoting the number of characters in the given equation.

// Next 3 lines will have the 7-segment display of the equation which Gagan typed.

// Output
// Print the position corresponding to the faulty character displayed. Count starts from one.

// Time Limit (secs)
// 1

// Examples
// Example 1

// Input

// 5

//        _     _ 
//   ||_  _| _ |_|
//   ||  |_  _  _|

// Output

// 1

// Explanation

// After processing each character (represented as a 3x3 matrix), we get the equation 1+2 = 9, which is incorrect. To correct it, we need to toggle one LED in the first character (1) to make it 7, resulting in the correct equation 7+2 = 9. Since the error is in the first character, print 1.

// Example 2

// Input

// 6

//  _     _          
//  _||_  _| _   |  |
// |_ |   _| _   |  |

// Output

// 3

// Explanation

// After processing each character (represented as a 3x3 matrix), we get the equation 2+3=11, which is incorrect. To correct it, we need to toggle one LED in the third character (3) to make it 9, resulting in the correct equation 2+9=11. Since the error is in the third character, print 3.

}

