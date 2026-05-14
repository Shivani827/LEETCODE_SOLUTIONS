/*
LEETCODE 136 - SINGLE NUMBER
Given a non-empty array of integers nums,
every element appears twice except for one.
Find that single one.
Example:
Input: nums = [2,2,1]
Output: 1
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- For every element, count its frequency
- The element with frequency 1 is the answer
---------------------------------------------------
*/
class BruteForceSolution {
    public int singleNumber(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
          if (nums[i] == nums[j]) 
               {
                    count++;
                } }

            if (count == 1) {
                return nums[i];
            }
        }
      return -1;
    }
}
/*
---------------------------------------------------
SORTING APPROACH
Time Complexity: O(n log n)
Space Complexity: O(1)
Idea:
- Sort the array
- Equal elements will come together
- Traverse in pairs:
    nums[i] and nums[i+1]
- If pair is not equal, nums[i] is answer
- If all pairs are equal,
  last element is the single number
---------------------------------------------------
*/

import java.util.Arrays;

class SortingSolution {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {

            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}
/*
---------------------------------------------------
BETTER APPROACH - HashMap
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Store frequency of every element
- Return element whose frequency is 1
---------------------------------------------------
*/

import java.util.*;

class BetterSolution {
    public int singleNumber(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
      for (int num : nums) {
        if (map.get(num) == 1) {
                return num;
            }
        }
      return -1;
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH - XOR
Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- Same numbers cancel each other using XOR

Properties:
a ^ a = 0
a ^ 0 = a

So only single element remains
---------------------------------------------------
*/

class OptimalSolution {
    public int singleNumber(int[] nums) {
      int ans = 0;
      for (int num : nums) {
            ans = ans ^ num;
        }
      return ans;
    }
}


// DRY RUN CODE

/*
Input:
nums = [4,1,2,1,2]
Initial:
ans = 0
------------------------------------------------
num = 4
ans = ans ^ num
    = 0 ^ 4
    = 4
ans = 4
------------------------------------------------
num = 1
ans = 4 ^ 1
    = 5
ans = 5
------------------------------------------------
num = 2
ans = 5 ^ 2
    = 7
ans = 7
------------------------------------------------
num = 1
ans = 7 ^ 1
    = 6
ans = 6
------------------------------------------------
num = 2
ans = 6 ^ 2
    = 4
ans = 4
------------------------------------------------
Final Output:
4
*/
