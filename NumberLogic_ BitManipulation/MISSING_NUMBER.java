/*
LEETCODE 268 - MISSING NUMBER
Given an array nums containing n distinct numbers
in the range [0, n], return the only number in the
range that is missing from the array.
Example:
Input: nums = [3,0,1]
Output: 2
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- Traverse from 0 to n
- For every number, check whether it exists
  in the array
- The missing number is the answer
---------------------------------------------------
*/
class BruteForceSolution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
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
- Number should match its index
- First mismatch gives missing number
---------------------------------------------------
*/
import java.util.Arrays;
class SortingSolution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - HashSet
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store all numbers in HashSet
- Traverse from 0 to n
- Missing number will not exist in set
---------------------------------------------------
*/
import java.util.HashSet;
class BetterSolution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Sum Formula
Time Complexity: O(n)
Space Complexity: O(1)
Formula:
Sum of first n natural numbers:
n * (n + 1) / 2
Idea:
- Find expected sum
- Subtract actual array sum
- Remaining value is missing number
---------------------------------------------------
*/
class OptimalSolution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
}
/*
---------------------------------------------------
ANOTHER OPTIMAL APPROACH - XOR
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- XOR all indices and array elements
- Equal numbers cancel each other
- Remaining value is missing number
Properties:
a ^ a = 0
a ^ 0 = a
---------------------------------------------------
*/
class XORSolution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
}   
return xor;
    }
}


// DRY RUN CODE
/*
Input:
nums = [3,0,1]
Initial:
xor = nums.length
    = 3
------------------------------------------------
i = 0
xor = xor ^ i ^ nums[i]
    = 3 ^ 0 ^ 3
Step 1:
3 ^ 0 = 3
Step 2:
3 ^ 3 = 0
xor = 0
------------------------------------------------
i = 1
xor = xor ^ i ^ nums[i]
    = 0 ^ 1 ^ 0
Step 1:
0 ^ 1 = 1
Step 2:
1 ^ 0 = 1
xor = 1
------------------------------------------------
i = 2
xor = xor ^ i ^ nums[i]
    = 1 ^ 2 ^ 1
Step 1:
1 ^ 2 = 3
Step 2:
3 ^ 1 = 2
xor = 2
------------------------------------------------
Loop Ends
Remaining value:
xor = 2
------------------------------------------------
Final Output:
2
*/

