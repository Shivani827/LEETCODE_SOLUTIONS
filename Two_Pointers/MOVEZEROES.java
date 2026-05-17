package Two_Pointers;
/*
LEETCODE 283 - MOVE ZEROES

Given an integer array nums, move all 0's to the
end of it while maintaining the relative order
of the non-zero elements.

Note:
- You must do this in-place
- Do not make a copy of the array

Example:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Store all non-zero elements in a temporary list
- Fill remaining positions with 0
---------------------------------------------------
*/

import java.util.*;

class BruteForceSolution {
    public void moveZeroes(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        // Store non-zero elements
        for (int num : nums) {
            if (num != 0) {
                temp.add(num);
            }
        }

        // Put non-zero elements back
        int index = 0;

        for (int num : temp) {
            nums[index++] = num;
        }

        // Fill remaining places with 0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}

/*
---------------------------------------------------
BETTER APPROACH - Two Pass Method
Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- Move all non-zero elements to front
- Then fill remaining positions with 0
---------------------------------------------------
*/

class BetterSolution {
    public void moveZeroes(int[] nums) {

        int index = 0;

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill remaining positions with 0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers + Swapping
Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- Find first zero position
- Swap non-zero elements with zero
- Maintain order automatically
---------------------------------------------------
*/

class OptimalSolution {
    public void moveZeroes(int[] nums) {

        int j = -1;

        // Find first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero exists
        if (j == -1) {
            return;
        }

        // Swap non-zero elements with zero
        for (int i = j + 1; i < nums.length; i++) {

            if (nums[i] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}

/*
---------------------------------------------------
DRY RUN CODE

Input:
nums = [0,1,0,3,12]

---------------------------------------------------
Initial Array:
[0,1,0,3,12]

Find first zero:
j = 0

---------------------------------------------------
i = 1
nums[i] = 1

Swap nums[i] and nums[j]

Array becomes:
[1,0,0,3,12]

j++

j = 1

---------------------------------------------------
i = 2
nums[i] = 0

Skip

---------------------------------------------------
i = 3
nums[i] = 3

Swap nums[i] and nums[j]

Array becomes:
[1,3,0,0,12]

j++

j = 2

---------------------------------------------------
i = 4
nums[i] = 12

Swap nums[i] and nums[j]

Array becomes:
[1,3,12,0,0]

j++

j = 3

---------------------------------------------------
Final Output:
[1,3,12,0,0]

---------------------------------------------------
*/