package mockvita;

public class Q3 {
    

//     MirrorMaze
// Problem Description
// In the mysterious island named Reflectia, there's a grid made up of M rows and N columns. Some cells in this grid are empty, while others hold mirrors which are placed diagonally to the cells. These mirrors are the reason why the island is called Reflectia - they bounce light beams in the opposite direction when the light hits them. The mirrors are placed in two ways viz. slanted forward (/) or slanted backwards (\).

// Rohit, a curious young explorer, decided to explore the Matrix with a flashlight in his hand as the island is very dark and is rumoured to be haunted. Once he entered, he aimed to find out the maximum number of cells the light could travel to, making a closed loop, within the grid when it is bounced on one of the mirrors in the grid. As it was too dark, he noted the structure of the grid and came out.

// Given the structure of the grid that Rohit noted, find out what's the maximum number of cells the light could travel to, making a closed loop [a closed polygon shape], within the grid when it is bounced on one of the mirrors in the grid.

// Constraints
// 3 < M, N < 50

// Input
// First line contains two integers separated by space, representing M and N.

// Next M Lines contains N space separated characters viz. {'/', '\', '0'} representing the grid structure.

// Output
// Single integer representing the maximum number of cells that can be covered in the loop formed by the reflected light beam.

// Time Limit (secs)
// 1

// Examples
// Example 1

// Input

// 5 5

// / / 0 0 \

// 0 0 0 / 0

// 0 \ 0 0 /

// \ / \ / 0

// 0 0 \ \ \

// Output

// 10

// Explanation

// The below diagram depicts the input.



// The mirror at indices [1,2], [1,5], [3,2] and [3,5] can form a loop covering 10 cells, which is the maximum possible.

// Example 2

// Input

// 6 6

// 0 0 0 0 / \

// / 0 / 0 / 0

// 0 \ 0 \ / 0

// 0 / \ \ / 0

// 0 / \ / 0 0

// 0 0 / \ 0 /

// Output

// 0

// Explanation

// The below diagram depicts the input.


// We cannot form any loop inside the given grid. Hence, print 0.
}
