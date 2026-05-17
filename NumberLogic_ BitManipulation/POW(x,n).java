/*
LEETCODE 50 - POW(x, n)

BRUTE FORCE APPROACH

Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- If power is negative:
    convert x into 1/x
    convert negative power into positive
- Multiply x power times
*/

class Solution {

    public double myPow(double x, int n) {

        double result = 1;

        long power = n;

        // Handle negative powers
        if (power < 0) {

            x = 1 / x;
            power = -power;
        }

        // Multiply x power times
        for (long i = 0; i < power; i++) {

            result = result * x;
        }

        return result;
    }
}

/*
---------------------------------------------------
DRY RUN

Input:
x = 2
n = 5

Initial:
result = 1
power = 5

---------------------------------------------------
Iteration 1

result = 1 * 2
       = 2

---------------------------------------------------
Iteration 2

result = 2 * 2
       = 4

---------------------------------------------------
Iteration 3

result = 4 * 2
       = 8

---------------------------------------------------
Iteration 4

result = 8 * 2
       = 16

---------------------------------------------------
Iteration 5

result = 16 * 2
       = 32

---------------------------------------------------
Final Output:
32
---------------------------------------------------
*/
/*

BETTER APPROACH (RECURSION)

Time Complexity: O(log n)
Space Complexity: O(log n)

Idea:
- Find half power recursively
- If n is even:
      answer = half * half
- If n is odd:
      answer = x * half * half
- Handle negative powers separately
*/

class BSolution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        return powCal(x, power);
    }
    public double powCal(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = powCal(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        else {
            return x * half * half;
        }
    }
}

/*
---------------------------------------------------
DRY RUN

Input:
x = 2
n = 5

---------------------------------------------------
Function Calls

powCal(2,5)
    ↓
powCal(2,2)
    ↓
powCal(2,1)
    ↓
powCal(2,0)

---------------------------------------------------
Base Case

powCal(2,0)

n == 0

return 1

---------------------------------------------------
Returning Back

powCal(2,1)

half = 1

n is odd

return 2 * 1 * 1
      = 2

---------------------------------------------------

powCal(2,2)

half = 2

n is even

return 2 * 2
      = 4

---------------------------------------------------

powCal(2,5)

half = 4

n is odd

return 2 * 4 * 4
      = 32

---------------------------------------------------
Final Output:
32
---------------------------------------------------
*/
