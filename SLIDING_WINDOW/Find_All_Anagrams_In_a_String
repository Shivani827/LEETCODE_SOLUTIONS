/*
LEETCODE 438 - FIND ALL ANAGRAMS IN A STRING
Given two strings s and p,
return an array of all the start indices of
p's anagrams in s.
Example:
Input:
s = "cbaebabacd"
p = "abc"
Output:
[0,6]
Explanation:
Substring starting at index 0 is "cba"
Substring starting at index 6 is "bac"
Both are anagrams of "abc"
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O((n-k+1) * k log k)
Space Complexity: O(k)
n = length of s
k = length of p
Idea:
- Generate every substring of length k
- Sort substring and p
- Compare both
---------------------------------------------------
*/
import java.util.*;
class BruteForceSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedP = new String(pArr);
        int k = p.length();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            char[] arr = sub.toCharArray();
            Arrays.sort(arr);
            String sortedSub = new String(arr);
            if (sortedSub.equals(sortedP)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Frequency Arrays
Time Complexity: O(26 * (n-k))
Space Complexity: O(1)
Idea:
- Store frequency of characters
- Compare frequencies for every window
---------------------------------------------------
*/
class BetterSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }
        for (int i = 0;
             i <= s.length() - p.length();
             i++) {
            if (Arrays.equals(pFreq, sFreq)) {
                ans.add(i);
            }
            if (i + p.length() < s.length()) {
                sFreq[s.charAt(i) - 'a']--;
                sFreq[s.charAt(i + p.length()) - 'a']++;
            }
        }
        return ans;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Sliding Window
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Store frequency of p
- Maintain sliding window of size p.length()
- Add new character
- Remove old character
- Compare frequencies
---------------------------------------------------
*/
class OptimalSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }
        int left = 0;
        for (int right = 0;
             right < s.length();
             right++) {
            windowFreq[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }
            if (Arrays.equals(pFreq, windowFreq)) {
                ans.add(left);
            }
        }
        return ans;
    }
}
// DRY RUN CODE
/*
Input:
s = "cbaebabacd"
p = "abc"
------------------------------------------------
Step 1:
Store frequency of p
pFreq:
a -> 1
b -> 1
c -> 1
------------------------------------------------
Initial:
left = 0
window = ""
------------------------------------------------
right = 0
Add 'c'
window = "c"
Window size < p.length()
------------------------------------------------
right = 1
Add 'b'
window = "cb"
------------------------------------------------
right = 2
Add 'a'
window = "cba"
Window size = 3
Compare frequencies
Both match
Add index:
0
ans = [0]
------------------------------------------------
right = 3
Add 'e'
Window becomes size 4
Remove left character:
'c'
left++
Current window:
"bae"
Not an anagram
------------------------------------------------
right = 4
Add 'b'
Window:
"aeb"
Not anagram
------------------------------------------------
Continue same process...
------------------------------------------------
right = 8
Window:
"bac"
Frequencies match
Add index:
6
ans = [0,6]
------------------------------------------------
Final Output:
[0,6]
*/
