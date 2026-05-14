/*
LEETCODE 9 - PALINDROME NUMBER

Given an integer x,
return true if x is palindrome integer,
otherwise return false.

A palindrome reads same forward and backward.

Example:
Input : x = 121
Output: true

Input : x = -121
Output: false
*/

/*
---------------------------------------------------
BRUTE FORCE APPROACH

Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Convert number into string
- Reverse string
- Compare original and reversed string
---------------------------------------------------
*/

class bruteSolution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }
        String original = Integer.toString(x);
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        return original.equals(reversed);
    }
}

/*
---------------------------------------------------
BETTER APPROACH

Time Complexity: O(log10 n)
Space Complexity: O(1)

Idea:
- Reverse the entire number
- Compare reversed number with original
---------------------------------------------------
*/

class betterSolution {

    public boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }
        return original == reversed;
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH

Time Complexity: O(log10 n)
Space Complexity: O(1)

Idea:
- Reverse only half of the number
- Compare first half and second half

Why?
- Faster
- Avoids integer overflow
---------------------------------------------------
*/

class optimalSolution {

    public boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        // Numbers ending with 0 are not palindrome
        // except 0 itself

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x = x / 10;
        }

        // Even digits:
        // x == reversedHalf

        // Odd digits:
        // x == reversedHalf / 10
        return (x == reversedHalf || x == reversedHalf / 10);
    }
}

/*
---------------------------------------------------
DRY RUN

Input:
x = 121

Initial:
x = 121
reversedHalf = 0

---------------------------------------------------
Iteration 1

digit = 121 % 10
      = 1

reversedHalf = 0 * 10 + 1
             = 1

x = 121 / 10
  = 12

---------------------------------------------------
Iteration 2

digit = 12 % 10
      = 2

reversedHalf = 1 * 10 + 2
             = 12

x = 12 / 10
  = 1

---------------------------------------------------
Now:
x = 1
reversedHalf = 12

Loop stops because:
x > reversedHalf is false

---------------------------------------------------
Check:

x == reversedHalf / 10

1 == 12 / 10

1 == 1

true

---------------------------------------------------
Final Output:
true
---------------------------------------------------
*/