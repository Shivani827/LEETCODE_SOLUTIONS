/*
LEETCODE 704 - BINARY SEARCH
Given an integer array nums sorted in ascending order
and an integer target,
return the index of target if it exists,
otherwise return -1.
Example:
Input:
nums = [-1,0,3,5,9,12]
target = 9
Output:
4
Explanation:
Target 9 is present at index 4.
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Traverse the array from left to right
- Compare every element with target
- Return index if found
- Otherwise return -1
---------------------------------------------------
*/
class BruteForceSolution {
    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
/*
---------------------------------------------------
BETTER APPROACH
Time Complexity: O(log n)
Space Complexity: O(1)
Idea:
- Since array is already sorted
- Use Binary Search
- Compare middle element with target
- If target is smaller search left half
- If target is greater search right half
- Repeat until found
---------------------------------------------------
*/
class BetterSolution {
    public int search(int[] nums, int target) {
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
        return -1;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH
Time Complexity: O(log n)
Space Complexity: O(1)
Idea:
- Perform Binary Search
- Calculate middle safely using:
  left + (right - left) / 2
- Avoid integer overflow
- Eliminate half of the search space every iteration
---------------------------------------------------
*/
class OptimalSolution {
    public int search(int[] nums, int target) {
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
        return -1;
    }
}
// DRY RUN CODE
/*
Input:
nums = [-1,0,3,5,9,12]
target = 9
------------------------------------------------
Initial:
left = 0
right = 5
------------------------------------------------
Iteration 1
mid = 0 + (5-0)/2
mid = 2
nums[mid] = 3
3 < 9
Search right half
left = 3
right = 5
------------------------------------------------
Iteration 2
mid = 3 + (5-3)/2
mid = 4
nums[mid] = 9
Target found
Return index:
4
------------------------------------------------
Final Output:
4
*/

