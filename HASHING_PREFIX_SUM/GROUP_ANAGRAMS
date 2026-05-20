/*
LEETCODE 49 - GROUP ANAGRAMS
Given an array of strings strs, group the
anagrams together.
You can return the answer in any order.
Example:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output:
[["bat"],["nat","tan"],["ate","eat","tea"]]
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n² * k log k)
Space Complexity: O(n)
k = average length of string
Idea:
- Compare every string with remaining strings
- Sort characters of strings
- If sorted strings are equal,
  they are anagrams
---------------------------------------------------
*/
import java.util.*;
class BruteForceSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            char[] arr1 = strs[i].toCharArray();
            Arrays.sort(arr1);
            String sorted1 = new String(arr1);
            for (int j = i + 1; j < strs.length; j++) {
                if (visited[j]) {
                    continue;
                }
                char[] arr2 = strs[j].toCharArray();
                Arrays.sort(arr2);
                String sorted2 = new String(arr2);
                if (sorted1.equals(sorted2)) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(group);
        }
        return ans;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - HashMap + Sorting
Time Complexity: O(n * k log k)
Space Complexity: O(n)
Idea:
- Sort every string
- Sorted string becomes key
- Store all anagrams in same group
---------------------------------------------------
*/
class OptimalSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map =
            new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
// DRY RUN CODE
/*
Input:
strs = ["eat","tea","tan","ate","nat","bat"]
------------------------------------------------
Initial:
map = {}
------------------------------------------------
str = "eat"
Convert to char array:
['e','a','t']
After sorting:
['a','e','t']
key = "aet"
Store in map:
"aet" -> ["eat"]
------------------------------------------------
str = "tea"
After sorting:
"aet"
Key already exists
Add "tea"
"aet" -> ["eat","tea"]
------------------------------------------------
str = "tan"
After sorting:
"ant"
Store:
"ant" -> ["tan"]
------------------------------------------------
str = "ate"
After sorting:
"aet"
Add to existing group
"aet" -> ["eat","tea","ate"]
------------------------------------------------
str = "nat"
After sorting:
"ant"
Add to existing group
"ant" -> ["tan","nat"]
------------------------------------------------
str = "bat"
After sorting:
"abt"
Store:
"abt" -> ["bat"]
------------------------------------------------
Final Map:
"aet" -> ["eat","tea","ate"]
"ant" -> ["tan","nat"]
"abt" -> ["bat"]
------------------------------------------------
Final Output:
[["eat","tea","ate"],
 ["tan","nat"],
 ["bat"]]
*/
