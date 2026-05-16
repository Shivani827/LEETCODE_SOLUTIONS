/*
LEETCODE 11 - CONTAINER WITH MOST WATER
Given n non-negative integers height where each
represents a point at coordinate (i, height[i]),
Find two lines that together with the x-axis form
a container such that the container contains the
most water.
Return the maximum amount of water a container
can store.
Example:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- Try every possible pair
- Calculate area for every pair
- Store maximum area
---------------------------------------------------
*/
class BruteForceSolution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight =
                    Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxWater = Math.max(maxWater, area);
            }
        }
        return maxWater;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Start with widest container
- Area depends on:
    width * smaller height
- Move the smaller height pointer
  because only that can improve area
---------------------------------------------------
*/
class OptimalSolution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int width = right - left;
            int minHeight =
                Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxWater = Math.max(maxWater, area);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxWater;
    }
}
// DRY RUN CODE
/*
Input:
height = [1,8,6,2,5,4,8,3,7]
------------------------------------------------
Initial:
left = 0
right = 8
height[left]  = 1
height[right] = 7
width = 8 - 0 = 8
minHeight = min(1,7)
          = 1
area = width * minHeight
     = 8 * 1
     = 8
maxWater = 8
------------------------------------------------
Since:
height[left] < height[right]
1 < 7
Move left++
------------------------------------------------
left = 1
right = 8
height[left]  = 8
height[right] = 7
width = 8 - 1
      = 7
minHeight = min(8,7)
          = 7
area = 7 * 7
     = 49
maxWater = max(8,49)
         = 49
------------------------------------------------
Since:
height[left] > height[right]
8 > 7
Move right--
------------------------------------------------
left = 1
right = 7
height[left]  = 8
height[right] = 3
width = 6
area = 6 * 3
     = 18
maxWater remains 49
------------------------------------------------
Continue same process...
Maximum area found = 49
------------------------------------------------
Final Output:
49
*/
