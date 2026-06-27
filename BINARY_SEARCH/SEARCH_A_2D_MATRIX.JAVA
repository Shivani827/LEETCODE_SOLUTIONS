/*
LEETCODE 74 - SEARCH A 2D MATRIX
You are given an m x n integer matrix with the following properties:
- Integers in each row are sorted in ascending order.
- The first integer of each row is greater than the last integer of the previous row.
Given an integer target,
return true if target exists in the matrix,
otherwise return false.
Example:
Input:
matrix = [[1,3,5,7],
          [10,11,16,20],
          [23,30,34,60]]
target = 3
Output:
true
Explanation:
Target 3 is present in the matrix.
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(m × n)
Space Complexity: O(1)
Idea:
- Traverse every element in the matrix
- Compare each element with target
- Return true if found
- Otherwise return false
---------------------------------------------------
*/
class BruteForceSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
---------------------------------------------------
BETTER APPROACH
Time Complexity: O(m + log n)
Space Complexity: O(1)
Idea:
- Find the possible row where target can exist
- Perform Binary Search on that row
- Return true if target is found
---------------------------------------------------
*/
class BetterSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (target >= matrix[i][0] &&
                target <= matrix[i][cols - 1]) {
                int left = 0;
                int right = cols - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    }
                    if (matrix[i][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH
Time Complexity: O(log(m × n))
Space Complexity: O(1)
Idea:
- Treat the matrix as a single sorted array
- Apply Binary Search
- Convert 1D index into matrix indices
row = mid / cols
col = mid % cols
---------------------------------------------------
*/
class OptimalSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
// DRY RUN CODE
/*
Input:
matrix =
[
 [1,3,5,7],
 [10,11,16,20],
 [23,30,34,60]
]
target = 3
------------------------------------------------
rows = 3
cols = 4
Treat matrix as:
[1,3,5,7,10,11,16,20,23,30,34,60]
left = 0
right = 11
------------------------------------------------
Iteration 1
mid = 5
row = 5 / 4 = 1
col = 5 % 4 = 1
matrix[1][1] = 11
11 > 3
Search left half
right = 4
------------------------------------------------
Iteration 2
mid = 2
row = 2 / 4 = 0
col = 2 % 4 = 2
matrix[0][2] = 5
5 > 3
Search left half
right = 1
------------------------------------------------
Iteration 3
mid = 0
row = 0 / 4 = 0
col = 0 % 4 = 0
matrix[0][0] = 1
1 < 3
Search right half
left = 1
------------------------------------------------
Iteration 4
mid = 1
row = 1 / 4 = 0
col = 1 % 4 = 1
matrix[0][1] = 3
Target found
Return:
true
------------------------------------------------
Final Output:
true
*/

