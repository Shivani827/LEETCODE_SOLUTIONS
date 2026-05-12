/*
---------------------------------------------------
Given an integer n, return an array ans where:
ans[i] = number of 1's in binary representation of i
Example:
Input: n = 5
Output: [0,1,1,2,1,2]
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n log n)
Space Complexity: O(n)
Idea:
- Traverse from 0 to n
- Convert each number into binary
- Count number of set bits
---------------------------------------------------
*/
class BruteForceSolution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int val = i;
            while (val > 0) {
                if (val % 2 == 1) {
                    count++;
                }
                val = val / 2;
            }
            ans[i] = count;
        }
        return ans;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Brian Kernighan Algorithm
Time Complexity: O(n log n)
Space Complexity: O(n)

Idea:
- Remove rightmost set bit using:
  n & (n - 1)
---------------------------------------------------
*/
class BetterSolution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int val = i;
            while (val > 0) {
                val = val & (val - 1);
                count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Dynamic Programming
Time Complexity: O(n)
Space Complexity: O(n)

Formula:
ans[i] = ans[i >> 1] + (i & 1)

Explanation:
- i >> 1 removes last bit
- i & 1 checks if last bit is 1
---------------------------------------------------
*/
class OptimalSolution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
// DRY RUN CODE
/*Input:
n = 5
Initial:
ans = [0,0,0,0,0,0]
------------------------------------------------
i = 1
Binary of 1 = 1
ans[1] = ans[1 >> 1] + (1 & 1)
1 >> 1 = 0
1 & 1 = 1
ans[1] = ans[0] + 1
        = 0 + 1
        = 1
ans = [0,1,0,0,0,0]
------------------------------------------------
i = 2
Binary of 2 = 10
ans[2] = ans[2 >> 1] + (2 & 1)
2 >> 1 = 1
2 & 1 = 0
ans[2] = ans[1] + 0
        = 1 + 0
        = 1
ans = [0,1,1,0,0,0]
------------------------------------------------
i = 3
Binary of 3 = 11
ans[3] = ans[3 >> 1] + (3 & 1)
3 >> 1 = 1
3 & 1 = 1
ans[3] = ans[1] + 1
        = 1 + 1
        = 2
ans = [0,1,1,2,0,0]
------------------------------------------------
i = 4
Binary of 4 = 100
ans[4] = ans[4 >> 1] + (4 & 1)
4 >> 1 = 2
4 & 1 = 0
ans[4] = ans[2] + 0
        = 1 + 0
        = 1

ans = [0,1,1,2,1,0]
------------------------------------------------
i = 5
Binary of 5 = 101
ans[5] = ans[5 >> 1] + (5 & 1)
5 >> 1 = 2
5 & 1 = 1
ans[5] = ans[2] + 1
        = 1 + 1
        = 2
ans = [0,1,1,2,1,2]
------------------------------------------------
Final Output:
[0,1,1,2,1,2]*/