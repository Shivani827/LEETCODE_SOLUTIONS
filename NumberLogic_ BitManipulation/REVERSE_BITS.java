/*
LEETCODE 190 - REVERSE BITS

Reverse bits of a given 32 bits unsigned integer.

Example:
Input : 00000010100101000001111010011100
Output: 00111001011110000010100101000000

---------------------------------------------------
OPTIMAL APPROACH - BIT MANIPULATION
Time Complexity: O(1)   -> runs 32 times
Space Complexity: O(1)

Idea:
- Take last bit using (n & 1)
- Shift result left to make space
- Add extracted bit into result
- Shift n right
- Repeat 32 times
---------------------------------------------------
*/

class Solution {

    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }
}

/*
---------------------------------------------------
DRY RUN

Input:
n = 5

Binary:
101

Initial:
result = 0

---------------------------------------------------
Iteration 1

n = 101

Last bit:
n & 1 = 1

Shift result:
0 << 1 = 0

Add bit:
0 | 1 = 1

result = 1

Shift n:
101 >>> 1 = 10

---------------------------------------------------
Iteration 2

n = 10

Last bit:
10 & 1 = 0

Shift result:
1 << 1 = 10

Add bit:
10 | 0 = 10

result = 10

Shift n:
10 >>> 1 = 1

---------------------------------------------------
Iteration 3

n = 1

Last bit:
1 & 1 = 1

Shift result:
10 << 1 = 100

Add bit:
100 | 1 = 101

result = 101

---------------------------------------------------
Final Output:
101

Decimal:
5
---------------------------------------------------
*/