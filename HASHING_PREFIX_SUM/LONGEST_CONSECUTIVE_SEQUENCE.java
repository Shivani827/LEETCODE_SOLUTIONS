/*
LEETCODE 128 - LONGEST CONSECUTIVE SEQUENCE
Given an unsorted array of integers nums,
return the length of the longest consecutive
elements sequence.
You must write an algorithm that runs in O(n).
Example:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation:
The longest consecutive sequence is:
[1,2,3,4]
Length = 4
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n³)
Space Complexity: O(1)
Idea:
- For every number:
    keep checking next consecutive numbers
- Use linear search to find next element
---------------------------------------------------
*/
class BruteForceSolution {
    public boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
}
        }
        return false;
    }
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        for (int num : nums) {
            int current = num;
            int count = 1;
            while (linearSearch(nums, current + 1)) {
                current++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Sorting
Time Complexity: O(n log n)
Space Complexity: O(1)
Idea:
- Sort the array
- Count consecutive elements
- Ignore duplicates
---------------------------------------------------
*/
import java.util.Arrays;
class BetterSolution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
}
            else if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            }
            else {
                longest =
                    Math.max(longest, currentStreak);
                currentStreak = 1;
            }
        }
        return Math.max(longest, currentStreak);
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - HashSet
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store all numbers in HashSet
- Start sequence only if:
    num - 1 does NOT exist
This ensures sequence starts only from
beginning element
---------------------------------------------------
*/
import java.util.HashSet;
class OptimalSolution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
}
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
// DRY RUN CODE
/*
Input:
nums = [100,4,200,1,3,2]
------------------------------------------------
Store elements in HashSet:
set = {100,4,200,1,3,2}
longest = 0
------------------------------------------------
num = 100
Check:
set.contains(99)
FALSE
Start new sequence
current = 100
count = 1
Check:
101 exists?
NO
longest = max(0,1)
         = 1
------------------------------------------------
num = 4
Check:
set.contains(3)
TRUE
Skip because sequence already started
from smaller number
------------------------------------------------
num = 200
Check:
set.contains(199)
FALSE
Start sequence
current = 200
count = 1
201 exists?
NO
longest = max(1,1)
         = 1
------------------------------------------------
num = 1
Check:
set.contains(0)
FALSE
Start sequence
current = 1
count = 1
2 exists? YES
count = 2
3 exists? YES
count = 3
4 exists? YES
count = 4
5 exists? NO
longest = max(1,4)
         = 4
------------------------------------------------
Final Output:
4
*/
