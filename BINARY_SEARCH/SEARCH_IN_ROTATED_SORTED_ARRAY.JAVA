/*
LEETCODE 33 - SEARCH IN ROTATED SORTED ARRAY
There is an integer array nums sorted in ascending order
with distinct values.
Before being passed to your function,
nums is possibly rotated at an unknown pivot.
Given the array nums and an integer target,
return the index of target if it exists,
otherwise return -1.
Example:
Input:
nums = [4,5,6,7,0,1,2]
target = 0
Output:
4
Explanation:
Target 0 is present at index 4.
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Traverse the entire array
- Compare every element with target
- Return its index if found
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
- Use Binary Search
- At every step,
  one half of the array is always sorted
- Check whether target lies in the sorted half
- Otherwise search in the other half
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
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] &&
                    target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] &&
                    target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
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
- Apply Binary Search
- Calculate middle safely using:
  left + (right - left) / 2
- Identify the sorted half
- Search only in the half where target can exist
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
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] &&
                    target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] &&
                    target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// DRY RUN CODE
/*
Input:
nums = [4,5,6,7,0,1,2]
target = 0
------------------------------------------------
Initial:
left = 0
right = 6
------------------------------------------------
Iteration 1
mid = 0 + (6-0)/2
mid = 3
nums[mid] = 7
Left half:
[4,5,6,7]
Target 0 is not in left half
Search right half
left = 4
right = 6
------------------------------------------------
Iteration 2
mid = 4 + (6-4)/2
mid = 5
nums[mid] = 1
Left half:
[0,1]
Target lies in left half
right = 4
------------------------------------------------
Iteration 3
mid = 4 + (4-4)/2
mid = 4
nums[mid] = 0
Target found
Return:
4
------------------------------------------------
Final Output:
4
*/
