/*
LEETCODE 36 - VALID SUDOKU
Determine if a 9 x 9 Sudoku board is valid.
Rules:
1. Each row must contain digits 1-9 without repetition
2. Each column must contain digits 1-9 without repetition
3. Each 3x3 sub-box must contain digits 1-9
   without repetition
Note:
- Empty cells are represented by '.'
Example:
Input:
board =
[
["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]
]
Output: true
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(9³)
Space Complexity: O(1)
Idea:
- For every filled cell:
    check row
    check column
    check 3x3 box
---------------------------------------------------
*/
class BruteForceSolution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                char current = board[row][col];
                // Check Row
                for (int j = 0; j < 9; j++) {
                    if (j != col &&
                        board[row][j] == current) {
                        return false;
                    }
                }

                // Check Column
                for (int i = 0; i < 9; i++) {
                    if (i != row &&
                        board[i][col] == current) {
                        return false;
                    }
                }
                // Check 3x3 Box
                int startRow = (row / 3) * 3;
                int startCol = (col / 3) * 3;
                for (int i = startRow;
                     i < startRow + 3;
                     i++) {
                    for (int j = startCol;
                         j < startCol + 3;
                         j++) {
                        if ((i != row || j != col) &&
                            board[i][j] == current) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - HashSet
Time Complexity: O(1)
(81 cells only)
Space Complexity: O(1)
Idea:
- Use HashSet to store:
    row values
    column values
    box values
Format:
"5 in row 0"
"5 in col 1"
"5 in box 0-0"
If duplicate exists,
board is invalid
---------------------------------------------------
*/
import java.util.HashSet;
class OptimalSolution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char current = board[row][col];
                if (current == '.') {
                    continue;
                }
                String rowKey =
                    current + " in row " + row;
                String colKey =
                    current + " in col " + col;
                String boxKey =
                    current + " in box "
                    + (row / 3) + "-"
                    + (col / 3);
                if (set.contains(rowKey) ||
                    set.contains(colKey) ||
                    set.contains(boxKey)) {
                    return false;
                }
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }
        return true;
    }
}
// DRY RUN CODE
/*
Input:
board[0][0] = '5'
------------------------------------------------
Current Cell:
row = 0
col = 0
current = '5'
------------------------------------------------
Create Keys:
rowKey = "5 in row 0"
colKey = "5 in col 0"
boxKey = "5 in box 0-0"
------------------------------------------------
Check if keys already exist
NO
Add all keys to set
------------------------------------------------
Move to next filled cell
board[0][1] = '3'
rowKey = "3 in row 0"
colKey = "3 in col 1"
boxKey = "3 in box 0-0"
No duplicates
Add to set
------------------------------------------------
Suppose later another '5'
appears in same row
rowKey = "5 in row 0"
Already exists in set
Return false
------------------------------------------------
If no duplicates found
throughout board
Return true
------------------------------------------------
Final Output:
true
*/
