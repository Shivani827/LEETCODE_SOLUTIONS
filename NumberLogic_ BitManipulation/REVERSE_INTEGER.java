/*
LEETCODE 7 - REVERSE INTEGER

Time Complexity: O(log10 n)
Space Complexity: O(1)

Idea:
- Extract last digit using % 10
- Before adding digit,
  check overflow condition
- Build reversed number
- Remove last digit using / 10
*/

class Solution {
    public int reverse(int x) {
        int digit = 0;
        int rev = 0;
        while (x != 0) {
            digit = x % 10;
            if (rev > Integer.MAX_VALUE / 10 ||
                rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return rev;
    }
}