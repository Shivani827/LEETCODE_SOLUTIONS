/*
LEETCODE 3 - LONGEST SUBSTRING WITHOUT
REPEATING CHARACTERS
Given a string s, find the length of the
longest substring without repeating characters.
Example:
Input: s = "abcabcbb"
Output: 3
Explanation:
The answer is "abc", with length 3.
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n³)
Space Complexity: O(n)
Idea:
- Generate all substrings
- Check whether substring contains duplicates
- Store maximum valid length
---------------------------------------------------
*/
import java.util.HashSet;
class BruteForceSolution {
    public boolean isUnique(String str) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isUnique(sub)) {
                    maxLen =
                        Math.max(maxLen, sub.length());
                }
            }
        }
        return maxLen;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Sliding Window + HashSet
Time Complexity: O(2n)
Space Complexity: O(n)
Idea:
- Use sliding window
- Expand right pointer
- If duplicate found,
  remove from left side
---------------------------------------------------
*/
class BetterSolution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0;
             right < s.length();
             right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen =
                Math.max(maxLen,
                right - left + 1);
        }
        return maxLen;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - HashMap + Sliding Window
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store latest index of characters
- Directly move left pointer
- Avoid unnecessary removals
---------------------------------------------------
*/
import java.util.HashMap;
class OptimalSolution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map =
            new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0;
             right < s.length();
             right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
         map.put(ch, right);
            maxLen = Math.max(maxLen,right - left + 1);}
      return maxLen;
    }
}
// DRY RUN CODE
/*
Input:
s = "abcabcbb"
------------------------------------------------
Initial:
left = 0
maxLen = 0
map = {}
------------------------------------------------
right = 0
ch = 'a'
Not present in map
Store:
a -> 0
Current Length:
0 - 0 + 1 = 1
maxLen = 1
------------------------------------------------
right = 1
ch = 'b'
Store:
b -> 1
Current Length:
1 - 0 + 1 = 2
maxLen = 2
------------------------------------------------
right = 2
ch = 'c'
Store:
c -> 2
Current Length:
2 - 0 + 1 = 3
maxLen = 3
------------------------------------------------
right = 3
ch = 'a'
Already exists
Move left:
left =
max(0, map.get('a') + 1)
= max(0, 0 + 1)
= 1
Update:
a -> 3
Current Length:
3 - 1 + 1 = 3
maxLen remains 3
------------------------------------------------
Continue same process...
Longest substring:
"abc"
Length = 3
------------------------------------------------
Final Output:
3
*/
