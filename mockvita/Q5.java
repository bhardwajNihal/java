package mockvita;

public class Q5 {
    

//     Magic Stars Intensity
// Problem Description
// In the 1930s, King Krishnadevaraya, who had a great love for magic, kept a personal magician in his palace. Whenever he desired to witness a magical performance, he would command the magician to entertain him with his craft.

// The magician constantly aimed to impress the king with new magical tricks. One day, he cast magical lines across the vast expanse of the palace floor, which was covered in tiles. Each tile is a square with sides of 1 unit length; thus, you can say the palace floor resembles a 2d plane.

// Since these are magical lines, when they are drawn, they only align with the edges of the tiles or pass through their corners.

// When these magical lines intersect, they create points of light called n-stars, where n ranges from 2 to 8. Each n-star forms when n lines intersect, and all these stars generate light.

// For calculating the intensity of the star, there exist two cases which are explained below.

// Consider below cases carefully.

// Case 1 - The line is only one side to the star i.e., the star won't cut the line into two parts.

// Consider the lines (4, 4, 4, 2), (4, 4, 7, 7) and (4, 4, 3, 5). These lines are intersecting at the point (4, 4). Since three lines intersect at a point, they form a star known as a 3-star.

// Now, the intensity of the star = minimum (the number of cells these 3 lines are touching from the point of star formation to the last) = minimum (2, 3, 1) = 1

// So, the intensity of this star will be 1.

//     // image

// Case 2 - The line is two sides to the star i.e., the star cuts the line into two parts.

// Consider the lines (3, 3, 7, 7), (3, 5, 6,2) and (4, 2, 4, 6). These lines are intersecting at the point (4, 4). Since three lines intersect at a point, they form a star known as a 3-star.

// In this case, the intensity of the star = minimum (the number of cells these 3 lines are touching from the point of star formation to the last on both sides) = minimum (1, 1, 2, 2, 3, 2) = 1
    
    
//     // image


// Given N lines and the type of star for which you need to determine the intensity, calculate the intensity for all such stars according to the cases described and print their total sum. If no stars of the specified type are present, print 0.

// Constraints
// 1 <= N <= 50

// 2 <= K <= 8

// 0 <= x, y <= 100

// Lines will not overlap either partially or completely.

// Input
// First line consists of an integer N, denoting the number of magical lines the magician casted.

// The next N lines contain four space-separated integers each, representing the x and y coordinates of the starting and ending points of the magical lines.

// The last line consists of an integer K denoting the type of star for which you need to calculate the intensity.

// Output
// Print a single integer representing the total intensity of all stars of the specified type given in the input. If no such stars are present, print 0.

// Time Limit (secs)
// 1

// Examples
// Example 1

// Input

// 7

// 4 2 4 6

// 6 5 6 7

// 1 3 3 5

// 3 5 4 4

// 3 3 7 7

// 2 2 2 5

// 4 4 5 3

// 4

// Output

// 1

// Explanation

// The lines given in the above input are represented in the below figure.


//     // image


//     Here, the star formed at (4, 4) is a 4-star because it is created by 4 lines. According to given cases, the intensity of this star is minimum (2, 1, 1, 2, 1, 3), resulting in an intensity of 1. Since there is only one 4-star, the output is 1.

//     Example 2
    
//     Input
    
//     5
    
//     1 1 8 8
    
//     3 1 3 4
    
//     5 1 5 8
    
//     1 3 3 3
    
//     7 2 7 9
    
//     2
    
//     Output
    
//     4
    
//     Explanation
    
//     The lines given in the above input are represented in the below figure.


//     // image


// There are two 2-stars formed at the positions (5, 5) and (7, 7). The intensity of star at (5, 5) is minimum (4, 3, 3, 4) which is 3 and the intensity of star at (7, 7) is minimum (1, 2, 6, 5) which is 1. So, the total intensity of all 2-stars will be 3+1 = 4.


}
