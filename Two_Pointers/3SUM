/*
LEETCODE 15 - 3SUM
Given an integer array nums, return all the
triplets [nums[i], nums[j], nums[k]] such that:
i != j, i != k, and j != k
nums[i] + nums[j] + nums[k] == 0
The solution set must not contain duplicate triplets.
Example:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n³)
Space Complexity: O(k)
Idea:
- Try every possible triplet
- If sum becomes 0, store it
- Sort triplet before storing
- Use Set to avoid duplicates
---------------------------------------------------
*/
import java.util.*;
class BruteForceSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[k]
                        );
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
/*
---------------------------------------------------
BETTER APPROACH - HashSet
Time Complexity: O(n²)
Space Complexity: O(n)
Idea:
- Fix one element
- Use HashSet to find remaining pair
- Use Set to avoid duplicate triplets
---------------------------------------------------
*/
class BetterSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
         HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (set.contains(third)) {
                    List<Integer> temp = Arrays.asList(
                        nums[i],
                        nums[j],
                        third
                    );
                    Collections.sort(temp);
                    result.add(temp);
                }
                set.add(nums[j]);
}
        }
        return new ArrayList<>(result);
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Sorting + Two Pointers
Time Complexity: O(n²)
Space Complexity: O(1)
Idea:
- Sort the array
- Fix one element
- Use two pointers for remaining array
- Skip duplicates
---------------------------------------------------
*/
class OptimalSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
            int sum =nums[i] + nums[left] + nums[right];
                   if (sum == 0) {
                      ans.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));
                    left++;
                    right--;
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return ans;
    }
}
// DRY RUN CODE
/*
Input:
nums = [-1,0,1,2,-1,-4]
------------------------------------------------
After Sorting:
nums = [-4,-1,-1,0,1,2]
------------------------------------------------
i = 0
nums[i] = -4
left = 1
right = 5
sum = -4 + (-1) + 2
    = -3
sum < 0
Move left++
------------------------------------------------
left = 2
right = 5
sum = -4 + (-1) + 2
    = -3
Move left++
------------------------------------------------
left = 3
right = 5
sum = -4 + 0 + 2
    = -2
Move left++
------------------------------------------------
left = 4
right = 5
sum = -4 + 1 + 2
    = -1
Move left++
Loop Ends
------------------------------------------------
i = 1
nums[i] = -1
left = 2
right = 5
sum = -1 + (-1) + 2
    = 0
Triplet Found:
[-1,-1,2]
Move:
left++
right--
------------------------------------------------
left = 3
right = 4
sum = -1 + 0 + 1
    = 0
Triplet Found:
[-1,0,1]
------------------------------------------------
Final Output:
[[-1,-1,2],[-1,0,1]]
*/
