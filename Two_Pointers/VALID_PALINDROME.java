/*
LEETCODE 125 - VALID PALINDROME
Given a string s, determine if it is a palindrome,
considering only alphanumeric characters and
ignoring cases.
Example:
Input: s = "A man, a plan, a canal: Panama"
Output: true
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Remove non-alphanumeric characters
- Convert string to lowercase
- Reverse the cleaned string
- Compare both strings
---------------------------------------------------
*/
class BruteForceSolution {
    public boolean isPalindrome(String s) {
        String cleaned = "";
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                cleaned += Character.toLowerCase(ch);
            }
        }
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }
        return cleaned.equals(reversed);
    }
}
/*
---------------------------------------------------
BETTER APPROACH - StringBuilder
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store valid characters using StringBuilder
- Reverse using built-in reverse() method
---------------------------------------------------
*/
class BetterSolution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String original = sb.toString();
        String reversed = sb.reverse().toString();
        return original.equals(reversed);
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Use two pointers:
    left -> start
    right -> end
- Ignore non-alphanumeric characters
- Compare lowercase characters
---------------------------------------------------
*/
class OptimalSolution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// DRY RUN CODE
/*
Input:
s = "A man, a plan, a canal: Panama"
------------------------------------------------
Initial:
left = 0
right = 29
------------------------------------------------
Step 1
s[left]  = 'A'
s[right] = 'a'
Convert to lowercase:
'A' -> 'a'
'a' -> 'a'
Both are equal
Move pointers:
left++
right--
------------------------------------------------
Step 2
Skip spaces and commas
left points to 'm'
right points to 'm'
Both are equal
Move pointers
------------------------------------------------
Step 3
left -> 'a'
right -> 'a'
Equal
------------------------------------------------
Continue same process...
All valid characters match
------------------------------------------------
Loop Ends
No mismatch found
------------------------------------------------
Final Output:
true
*/
