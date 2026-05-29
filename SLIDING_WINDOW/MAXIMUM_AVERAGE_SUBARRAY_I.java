/*
LEETCODE 643 - MAXIMUM AVERAGE SUBARRAY I
Given an integer array nums consisting of n elements,
and an integer k,
find a contiguous subarray whose length is equal to k
that has the maximum average value and return it.
Example:
Input:
nums = [1,12,-5,-6,50,3]
k = 4
Output:
12.75
Explanation:
Maximum average is:
(12 + (-5) + (-6) + 50) / 4
= 51 / 4
= 12.75
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n * k)
Space Complexity: O(1)
Idea:
- Generate every subarray of size k
- Find sum of every window
- Store maximum sum
---------------------------------------------------
*/
class BruteForceSolution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        for (int i = 0;i <= nums.length - k;i++) {
            int sum = 0;
            for (int j = i;j < i + k;j++) {
                sum += nums[j];
            }
            maxAvg =Math.max(maxAvg,(double)sum / k);
        }
        return maxAvg;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Sliding Window
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Find sum of first window
- Slide the window:
    add next element
    remove previous element
- Track maximum sum
---------------------------------------------------
*/
class OptimalSolution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        for (int i = k;i < nums.length;i++) {
            windowSum += nums[i];
            windowSum -= nums[i - k];
            maxSum =
                Math.max(maxSum, windowSum);        }
        return (double) maxSum / k;
    }
}
// DRY RUN CODE
/*
Input:
nums = [1,12,-5,-6,50,3]
k = 4
------------------------------------------------
Step 1:
Find first window sum
Window:
[1,12,-5,-6]
windowSum =
1 + 12 + (-5) + (-6)
= 2
maxSum = 2
------------------------------------------------
Slide Window
i = 4
Add nums[4]
= 50
Remove nums[0]
= 1
windowSum =
2 + 50 - 1
= 51
Window:
[12,-5,-6,50]
maxSum =
max(2,51)
= 51
------------------------------------------------
i = 5
Add nums[5]
= 3
Remove nums[1]
= 12
windowSum =
51 + 3 - 12
= 42
Window:
[-5,-6,50,3]
maxSum =
max(51,42)
= 51
------------------------------------------------
Final Average:
maxSum / k
= 51 / 4
= 12.75
------------------------------------------------
Final Output:
12.75
*/
