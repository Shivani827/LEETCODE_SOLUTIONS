/*
LEETCODE 35 - SEARCH INSERT POSITION
Given a sorted array of distinct integers and a target value,
return the index if the target is found.
If not, return the index where it would be inserted
to keep the array sorted.
Example:
Input:
nums = [1,3,5,6]
target = 5
Output:
2
Explanation:
Target 5 is present at index 2.
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(1)
Idea:

- Traverse the array from left to right
- If current element is greater than or equal to target,
  return its index
- If target is greater than all elements,
  return nums.length
---------------------------------------------------
*/
class BruteForceSolution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Binary Search
Time Complexity: O(log n)
Space Complexity: O(1)
Idea:
- Since the array is sorted,
  use Binary Search
- If target is found,
  return its index
- Otherwise,
  return the position where search ends
  (left pointer)
---------------------------------------------------
*/
class BetterSolution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Safe Binary Search
Time Complexity: O(log n)
Space Complexity: O(1)
Idea:
- Perform Binary Search
- Compute middle safely using:
  left + (right - left) / 2
- If target exists,
  return its index
- Otherwise,
  left will point to the correct insert position
---------------------------------------------------
*/
class OptimalSolution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
// DRY RUN CODE
/*
Input:
nums = [1,3,5,6]
target = 2
------------------------------------------------
Initial:
left = 0
right = 3
------------------------------------------------
Iteration 1
mid = 0 + (3-0)/2
mid = 1
nums[mid] = 3
3 > 2
Search left half
left = 0
right = 0
------------------------------------------------
Iteration 2
mid = 0 + (0-0)/2
mid = 0
nums[mid] = 1
1 < 2
Search right half
left = 1
right = 0
------------------------------------------------
Loop ends because:
left > right
Insert position = left
Return:
1
------------------------------------------------
Final Output:
1
*/
