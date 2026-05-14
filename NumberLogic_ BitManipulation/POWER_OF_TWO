/*
LEETCODE 231 - POWER OF TWO
Given an integer n, return true if it is a power of two.
Otherwise, return false.
An integer n is a power of two if there exists an
integer x such that:
n = 2^x
Example:
Input: n = 16
Output: true
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(log n)
Space Complexity: O(1)

Idea:
- Keep dividing n by 2
- If at any point n becomes odd before 1,
  then it is not a power of two
---------------------------------------------------
*/
class BruteForceSolution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Count Set Bits
Time Complexity: O(log n)
Space Complexity: O(1)
Idea:
- Power of two contains exactly one set bit
Examples:
1  -> 0001
2  -> 0010
4  -> 0100
8  -> 1000
---------------------------------------------------
*/
class BetterSolution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count == 1;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Bit Manipulation
Time Complexity: O(1)
Space Complexity: O(1)
Idea:
- Power of two has only one set bit
- n & (n - 1) removes the rightmost set bit
For powers of two:
n & (n - 1) = 0
Example:
8  = 1000
7  = 0111
     ----
     0000
---------------------------------------------------
*/
class OptimalSolution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
// DRY RUN CODE
/*
Input:
n = 16
Binary of 16:
10000
------------------------------------------------
Check:
n > 0
16 > 0
TRUE
------------------------------------------------
n - 1
16 - 1 = 15
Binary of 15:
01111
------------------------------------------------
Perform AND Operation
   10000
&  01111
   -----
   00000

Result = 0
------------------------------------------------
Condition:
(n & (n - 1)) == 0
TRUE
------------------------------------------------
Final Output:
true
*/
