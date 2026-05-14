/*
LEETCODE 7 - REVERSE INTEGER

BETTER APPROACH

Time Complexity: O(log10 n)
Space Complexity: O(1)

Idea:
- Extract last digit using % 10
- Check overflow condition
- Build reversed number
- Remove last digit using / 10
*/

class betterSolution {

    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            if (reversed > Integer.MAX_VALUE / 10 ||
                reversed < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reversed = reversed * 10 + digit;
            x = x / 10;
        }
        return reversed;
    }
}

/*
---------------------------------------------------
DRY RUN

Input:
x = 123

Initial:
reversed = 0

---------------------------------------------------
Iteration 1

digit = 123 % 10
      = 3

reversed = 0 * 10 + 3
         = 3

x = 123 / 10
  = 12

---------------------------------------------------
Iteration 2

digit = 12 % 10
      = 2

reversed = 3 * 10 + 2
         = 32

x = 12 / 10
  = 1

---------------------------------------------------
Iteration 3

digit = 1 % 10
      = 1

reversed = 32 * 10 + 1
         = 321

x = 1 / 10
  = 0

---------------------------------------------------
Final Output:
321
---------------------------------------------------
*/