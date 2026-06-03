/*LEETCODE 76 - MINIMUM WINDOW SUBSTRING
------------------------------------------------
Given two strings s and t of lengths m and n
respectively, return the minimum window substring
of s such that every character in t (including
duplicates) is included in the window.
If there is no such substring, return "".
Example:
Input:
s = "ADOBECODEBANC"
t = "ABC"
Output:
"BANC"
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n³)
Space Complexity: O(1)
Idea:
- Generate all substrings
- Check if substring contains all characters
  of t with correct frequency
- Keep track of minimum valid substring
---------------------------------------------------
*/
class BruteForceSolution {
    private boolean isValid(String sub, String t) {
        int[] freq = new int[128];
        for (char ch : sub.toCharArray()) {
            freq[ch]++;        }

        for (char ch : t.toCharArray()) {
            if (--freq[ch] < 0) {
                return false;
            }
        }
       return true;
    }
    public String minWindow(String s, String t) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isValid(sub, t)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        ans = sub;
                    }
                }
            }
        }

        return ans;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Sliding Window + HashMap
Time Complexity: O(n + m)
Space Complexity: O(m)
Idea:
- Store frequency of characters in t
- Expand right pointer
- When all required characters are found,
  shrink window from left
---------------------------------------------------
*/
import java.util.HashMap;
class BetterSolution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map =new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        int required = t.length();
        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0;right < s.length();right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    required--;
                }
                map.put(ch, map.get(ch) - 1);
            }
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar,map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        required++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE
            ? "": s.substring(start, start + minLen);
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Sliding Window + Array
Time Complexity: O(n + m)
Space Complexity: O(1)
Idea:
- Same sliding window concept
- Use array instead of HashMap
- Faster lookups
---------------------------------------------------
*/
class OptimalSolution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0;right < s.length();right++) {
            char ch = s.charAt(right);
            if (freq[ch] > 0) {
                count--;
            }
            freq[ch]--;
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                if (freq[leftChar] > 0) {
                    count++;
                }
              left++;
            }
        }
      return minLen == Integer.MAX_VALUE
            ? "": s.substring(start, start + minLen);
    }
}
// DRY RUN CODE
/*
Input:
s = "ADOBECODEBANC"
t = "ABC"
------------------------------------------------
Frequency Array:
A -> 1
B -> 1
C -> 1
count = 3
left = 0
------------------------------------------------
right = 0
Character = 'A'
freq['A'] > 0
count--
count = 2
freq['A']--
------------------------------------------------
right = 3
Character = 'B'
count--
count = 1
------------------------------------------------
right = 5
Character = 'C'
count--
count = 0
Valid Window:
"ADOBEC"
Length = 6
minLen = 6
------------------------------------------------
Shrink Window
Move left forward
Continue searching for
smaller valid windows
------------------------------------------------
Eventually reach:
Window = "BANC"
Contains:
A, B, C
Length = 4
minLen = 4
------------------------------------------------
No smaller valid window exists
------------------------------------------------
Final Output:
"BANC"
*/
