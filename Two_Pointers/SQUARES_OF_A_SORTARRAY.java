package Two_Pointers;

/*
LEETCODE 977 - SQUARES OF A SORTED ARRAY

Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number
sorted in non-decreasing order.

Example:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n log n)
Space Complexity: O(n)

Idea:
- Square every element
- Sort the array
---------------------------------------------------
*/

import java.util.*;

class BruteForceSolution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        // Square all elements
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        // Sort squared array
        Arrays.sort(result);
        return result;
    }
}

/*
---------------------------------------------------
BETTER APPROACH - Using List
Time Complexity: O(n log n)
Space Complexity: O(n)

Idea:
- Store squares in list
- Sort list
- Convert back to array
---------------------------------------------------
*/

class BetterSolution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // Store squares
        for (int num : nums) {
            list.add(num * num);
        }
        // Sort list
        Collections.sort(list);
        int[] result = new int[nums.length];
        // Convert back to array
        for (int i = 0; i < nums.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Largest square comes from either
  leftmost negative or rightmost positive
- Compare absolute values
- Fill result array from end
---------------------------------------------------
*/

class OptimalSolution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            }
            else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        return result;
    }
}

/*
---------------------------------------------------
DRY RUN CODE

Input:
nums = [-4,-1,0,3,10]

---------------------------------------------------
Initial Array:
[-4,-1,0,3,10]

left = 0
right = 4
index = 4

---------------------------------------------------
leftSquare = 16
rightSquare = 100

100 is bigger

result[4] = 100

right--

right = 3
index--

---------------------------------------------------
leftSquare = 16
rightSquare = 9

16 is bigger

result[3] = 16

left++

left = 1
index--

---------------------------------------------------
leftSquare = 1
rightSquare = 9

9 is bigger

result[2] = 9

right--

right = 2
index--

---------------------------------------------------
leftSquare = 1
rightSquare = 0

1 is bigger

result[1] = 1

left++

left = 2
index--

---------------------------------------------------
leftSquare = 0
rightSquare = 0

result[0] = 0

---------------------------------------------------
Final Output:
[0,1,9,16,100]

---------------------------------------------------
*/
