/*
LEETCODE 191 - NUMBER OF 1 BITS



Example:
Input : n = 11

Binary:
1011

Output:
3
*/

/*
---------------------------------------------------
BRUTE FORCE APPROACH

Time Complexity: O(32)
Space Complexity: O(1)

Idea:
- Traverse all 32 bits
- Check last bit using (n & 1)
- If last bit is 1, increase count
- Shift n right
---------------------------------------------------
*/

class bruteSolution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}

/*
---------------------------------------------------
BETTER APPROACH

Time Complexity: O(number of bits)
Space Complexity: O(1)

Idea:
- Traverse until n becomes 0
- Extract last bit using (n & 1)
- Add it into count
- Shift n right
---------------------------------------------------
*/

class betterSolution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count = count + (n & 1);
            n >>>= 1;
        }
        return count;
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH

Time Complexity: O(number of set bits)
Space Complexity: O(1)

Idea:
- n & (n - 1) removes last set bit
- Count how many times we remove set bit
---------------------------------------------------
*/

class optimalSolution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

/*
---------------------------------------------------
DRY RUN

Input:
n = 11

Binary:
1011

Initial:
count = 0

---------------------------------------------------
Iteration 1

n = 1011

Last bit:
1011 & 1 = 1

count = 1

Shift n:
1011 >>> 1 = 101

---------------------------------------------------
Iteration 2

n = 101

Last bit:
101 & 1 = 1

count = 2

Shift n:
101 >>> 1 = 10

---------------------------------------------------
Iteration 3

n = 10

Last bit:
10 & 1 = 0

count = 2

Shift n:
10 >>> 1 = 1

---------------------------------------------------
Iteration 4

n = 1

Last bit:
1 & 1 = 1

count = 3

Shift n:
1 >>> 1 = 0

---------------------------------------------------
Final Output:
3
---------------------------------------------------
*/