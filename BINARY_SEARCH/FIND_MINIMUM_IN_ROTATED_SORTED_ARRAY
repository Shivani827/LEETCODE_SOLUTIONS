/*
LEETCODE 153 - FIND MINIMUM IN ROTATED SORTED ARRAY
Suppose an array of length n sorted in ascending order
is rotated between 1 and n times.
Given the sorted rotated array nums of unique elements,
return the minimum element of the array.
Example:
Input:
nums = [3,4,5,1,2]
Output:
1
Explanation:
The original sorted array was [1,2,3,4,5]
After rotation, the minimum element is 1.
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Traverse the entire array
- Keep track of the minimum element
- Return the minimum
---------------------------------------------------
*/
class BruteForceSolution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}
/*
---------------------------------------------------
BETTER APPROACH
Time Complexity: O(log n)
Space Complexity: O(1)
Idea:
- Use Binary Search
- If current subarray is already sorted,
  the leftmost element is the minimum
- Otherwise,
  compare mid with right element
- Decide which half contains the minimum
---------------------------------------------------
*/
class BetterSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }
            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
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
- If left half is sorted,
  minimum lies in right half
- Otherwise,
  minimum lies in left half
- Keep updating answer
---------------------------------------------------
*/
class OptimalSolution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }
            int mid = left + (right - left) / 2;
            ans = Math.min(ans, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
// DRY RUN CODE
/*
Input:
nums = [3,4,5,1,2]
------------------------------------------------
Initial:
left = 0
right = 4
ans = 3
------------------------------------------------
Iteration 1
mid = 0 + (4-0)/2
mid = 2
nums[mid] = 5
Left half:
[3,4,5]
Left half is sorted
ans = min(3,5) = 3
Search right half
left = 3
right = 4
------------------------------------------------
Iteration 2
Current subarray:
[1,2]
Already sorted
Minimum is nums[left]
ans = min(3,1)
ans = 1
Break
------------------------------------------------
Final Output:
1
*/
