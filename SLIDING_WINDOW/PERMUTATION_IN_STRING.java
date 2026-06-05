/*
LEETCODE 567 - PERMUTATION IN STRING
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is a substring of s2.
Example:
Input:
s1 = "ab"
s2 = "eidbaooo"
Output:
true
Explanation:
"ba" is a permutation of "ab"
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O((n-m+1) * m log m)
Space Complexity: O(m)
m = length of s1
n = length of s2
Idea:
- Sort s1
- Generate every substring of length m from s2
- Sort substring
- Compare with sorted s1
---------------------------------------------------
*/
import java.util.Arrays;
class BruteForceSolution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        String target = new String(arr1);
        for (int i = 0; i <= n - m; i++) {
            String sub = s2.substring(i, i + m);
            char[] arr2 = sub.toCharArray();
            Arrays.sort(arr2);
            String current = new String(arr2);
            if (target.equals(current)) {
                return true;            }
        }
        return false;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Sliding Window
Time Complexity: O(26 * n)
Space Complexity: O(26)
Idea:
- Store frequency of s1
- Maintain window of size s1.length()
- Compare frequency arrays
---------------------------------------------------
*/
class BetterSolution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        for (int i = m; i < n; i++) {

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - m) - 'a']--;
        }
        return Arrays.equals(freq1, freq2);
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Sliding Window + Match Count
Time Complexity: O(n)
Space Complexity: O(26)
Idea:
- Maintain frequency arrays
- Track how many characters match
- Avoid comparing entire arrays every time
---------------------------------------------------
*/
class OptimalSolution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < m; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == window[i]) {
                matches++;
            }
        }
        int left = 0;
        for (int right = m; right < n; right++) {
            if (matches == 26) {
                return true;
            }
            int index = s2.charAt(right) - 'a';
            window[index]++;
            if (window[index] == s1Count[index])
            {
                matches++;
            }
            else if (window[index] == s1Count[index] + 1) {
                matches--;
            }
            index =  s2.charAt(left) - 'a';
            window[index]--;
            if (window[index] ==  s1Count[index]) {
                matches++;
            }
            else if (window[index] ==  s1Count[index] - 1) {
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}
// DRY RUN CODE
/*
Input:
s1 = "ab"
s2 = "eidbaooo"
------------------------------------------------
m = 2
Frequency of s1:
a -> 1
b -> 1
------------------------------------------------
Initial Window:
"ei"
Frequency:
e -> 1
i -> 1
Not equal
------------------------------------------------
Slide Window
Window:
"id"
Frequency:
i -> 1
d -> 1
Not equal
------------------------------------------------
Slide Window
Window:
"db"
Frequency:
d -> 1
b -> 1
Not equal
------------------------------------------------
Slide Window
Window:
"ba"
Frequency:
b -> 1
a -> 1
Matches frequency of s1
------------------------------------------------
Permutation Found
Return true
------------------------------------------------
Final Output:
true
*/


