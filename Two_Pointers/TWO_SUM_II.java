/*
LEETCODE 167 - TWO SUM II (INPUT ARRAY IS SORTED)
Given a 1-indexed array of integers numbers that
is already sorted in non-decreasing order,
find two numbers such that they add up to target.
Return the indices (1-based indexing).
Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- Try every pair
- If sum equals target,
  return indices
---------------------------------------------------
*/
class BruteForceSolution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
/*
---------------------------------------------------
BETTER APPROACH - HashMap
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Store visited numbers in HashMap
- Check whether target - current exists
---------------------------------------------------
*/
import java.util.HashMap;
class BetterSolution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
               int needed = target - numbers[i];
            if (map.containsKey(needed)) {
             return new int[]{
                    map.get(needed) + 1,
                    i + 1
                };
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
Idea:
- Since array is sorted:
    left -> smallest value
    right -> largest value
- If sum is too small:
    move left++
- If sum is too large:
    move right--
- If sum equals target:
    return indices
---------------------------------------------------
*/
class OptimalSolution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{
                    left + 1,
                    right + 1
                };
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
// DRY RUN CODE
/*
Input:
numbers = [2,7,11,15]
target = 9
------------------------------------------------
Initial:
left = 0
right = 3
numbers[left]  = 2
numbers[right] = 15
sum = 2 + 15 = 17
17 > 9
Move right--
------------------------------------------------
left = 0
right = 2
numbers[left]  = 2
numbers[right] = 11
sum = 2 + 11 = 13
13 > 9
Move right--
------------------------------------------------
left = 0
right = 1
numbers[left]  = 2
numbers[right] = 7
sum = 2 + 7 = 9
Target found
Return:
[left + 1, right + 1]
= [1,2]
------------------------------------------------
Final Output:
[1,2]
*/
