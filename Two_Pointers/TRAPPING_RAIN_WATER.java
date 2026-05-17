/*
LEETCODE 42 - TRAPPING RAIN WATER
Given n non-negative integers representing an
elevation map where the width of each bar is 1,
compute how much water it can trap after raining.
Example:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- For every index:
    find left maximum
    find right maximum
- Water stored:
    min(leftMax, rightMax) - height[i]
---------------------------------------------------
*/
class BruteForceSolution {
    public int trap(int[] height) {
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water +=
                Math.min(leftMax, rightMax) - height[i];
        }
        return water;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Prefix & Suffix Arrays
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store left maximum for every index
- Store right maximum for every index
- Calculate trapped water using:
  min(leftMax,rightMax) - height[i]
---------------------------------------------------
*/
class BetterSolution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] =
                Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] =
                Math.max(rightMax[i + 1], height[i]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water +=
                Math.min(leftMax[i], rightMax[i])
                - height[i];
        }
        return water;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Use two pointers:
    left and right
- Maintain:
    leftMax and rightMax
- Water depends on smaller boundary
---------------------------------------------------
*/
class OptimalSolution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                }
                else {
                    water += leftMax - height[left];
                }
                left++;
            }
            else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                }
                else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
// DRY RUN CODE
/*
Input:
height = [0,1,0,2,1,0,1,3,2,1,2,1]
------------------------------------------------
Initial:
left = 0
right = 11
leftMax = 0
rightMax = 0
water = 0
------------------------------------------------
height[left] = 0
height[right] = 1
0 < 1
height[left] >= leftMax
0 >= 0
leftMax = 0
Move left++
------------------------------------------------
left = 1
height[left] = 1
height[right] = 1
height[left] is NOT less
Process right side
height[right] >= rightMax
1 >= 0
rightMax = 1
Move right--
------------------------------------------------
right = 10
height[left] = 1
height[right] = 2
1 < 2
height[left] >= leftMax
1 >= 0
leftMax = 1
Move left++
------------------------------------------------
left = 2
height[left] = 0
0 < 2
height[left] < leftMax
0 < 1
Water trapped:
leftMax - height[left]
= 1 - 0
= 1
water = 1
Move left++
------------------------------------------------
Continue same process...
Total trapped water = 6
------------------------------------------------
Final Output:
6
*/
