/*
LEETCODE 1 - TWO SUM
Given an array of integers nums and an integer
target, return indices of the two numbers such
that they add up to target.
You may assume that each input would have
exactly one solution.
Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- Try every possible pair
- If pair sum equals target,
  return indices
*/

class BruteForceSolution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
/*
---------------------------------------------------
BETTER APPROACH - HashMap
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store visited numbers in HashMap
- Check whether target - current element exists
---------------------------------------------------
*/
import java.util.HashMap;
class BetterSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];
            if (map.containsKey(needed)) {
                return new int[]
                {
                    map.get(needed),i
                };
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - HashMap
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Same as better approach
- HashMap gives best possible complexity
---------------------------------------------------
*/
class OptimalSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (map.containsKey(remaining)) {
                return new int[]
                {
                    map.get(remaining),i
                };
            }
          map.put(nums[i], i);
        }
      return new int[]{-1, -1};
    }
}
// DRY RUN CODE
/*
Input:
nums = [2,7,11,15]
target = 9
------------------------------------------------
Initial:
map = {}
------------------------------------------------
i = 0
nums[i] = 2
remaining = 9 - 2
          = 7
Is 7 present in map?
NO
Store:
2 -> 0
map = {2=0}
------------------------------------------------
i = 1
nums[i] = 7
remaining = 9 - 7
          = 2
Is 2 present in map?
YES
Return:
[map.get(2), 1]
= [0,1]
------------------------------------------------
Final Output:
[0,1]
*/
