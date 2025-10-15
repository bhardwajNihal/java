package mockvita;

public class Q2 {
//     CountTheShapes
// Problem Description
// In todays class, little Aadhya learned about closed figures, allowing her to differentiate between shapes that are closed and those that are not.

// She was tasked with identifying closed shapes formed from a given set of line segments. Feeling a bit confused, she has sought your help. Given a set of line segments that only intersect at their endpoints, determine the total number of closed figures formed. Note that there exist some line segments that do not intersect at all.

// Note: No more than 2 lines will intersect at a point.

// Constraints
// 1 <= N <= 1000

// 0 <= x, y <= 100

// Input
// First line consists of an integer N, denoting the number of line segments.

// The following N lines each contain 4 space-separated integers that represent the starting and ending points of a line segment in the format x1 y1 x2 y2.

// Output
// Print a single integer denoting the number of closed figured formed by the given set of line segments.

// Time Limit (secs)
// 1

// Examples
// Example 1

// Input

// 15

// 0 0 1 0

// 3 1 3 3

// 3 3 1 3

// 5 3 4 3

// 5 4 6 4

// 1 0 0 1

// 0 1 0 0

// 1 1 3 1

// 6 4 6 3

// 1 3 1 1

// 4 1 5 1

// 6 3 6 2

// 5 1 5 3

// 3 0 4 0

// 4 3 4 1

// Output

// 3

// Explanation

// The given lines when represented in a 2D plane looks like below.


// As we can see here there are 3 closed figures, hence print 3.

// Example 2

// Input

// 15

// 0 0 6 0

// 6 0 6 6

// 6 6 0 6

// 0 6 0 0

// 1 1 3 1

// 3 1 3 4

// 3 4 1 4

// 1 4 1 1

// 4 4 5 4

// 5 4 5 5

// 5 5 4 5

// 4 5 4 4

// 0 7 6 7

// 6 7 3 9

// 3 9 0 7

// Output

// 4

// Explanation

// The given lines when represented in a 2D plane looks like below.


// As we can see here there are 4 closed figures, hence print 4.

// Example 3

// Input

// 14

// 2 1 2 0

// 0 6 6 3

// 0 3 5 3

// 5 3 5 0

// 1 2 1 0

// 1 0 0 0

// 0 0 0 3

// 2 0 3 0

// 3 0 3 1

// 3 1 2 1

// 5 0 4 0

// 4 0 4 2

// 4 2 1 2

// 0 4 5 4

// Output

// 2

// Explanation

// The given lines when represented in a 2D plane looks like below.

// As we can see here there are 2 closed figures, hence print 2.


}
