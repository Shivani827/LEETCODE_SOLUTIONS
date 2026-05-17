/*
LEETCODE 26 - REMOVE DUPLICATES FROM SORTED ARRAY

Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element
appears only once.

The relative order of the elements should be kept the same.

Return the number of unique elements k.

Example:
Input: nums = [1,1,2]
Output: 2
nums = [1,2,_]

---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Store unique elements in a temporary list
- Copy unique elements back into array
---------------------------------------------------
*/

import java.util.*;

class BruteForceSolution {
    public int removeDuplicates(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        // Add first element
        temp.add(nums[0]);

        // Store unique elements
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                temp.add(nums[i]);
            }
        }

        // Copy back to original array
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }

        return temp.size();
    }
}

/*
---------------------------------------------------
BETTER APPROACH - HashSet
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Use HashSet to store unique elements
- Copy unique elements back into array
---------------------------------------------------
*/

class BetterSolution {
    public int removeDuplicates(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store unique elements
        for (int num : nums) {
            set.add(num);
        }

        int index = 0;

        // Copy back into array
        for (int num : set) {
            nums[index++] = num;
        }

        return set.size();
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- Use two pointers
- One pointer tracks unique position
- If new element found, place it next
---------------------------------------------------
*/

class OptimalSolution {
    public int removeDuplicates(int[] nums) {

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {

                i++;

                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}

/*
---------------------------------------------------
DRY RUN CODE

Input:
nums = [1,1,2,2,3,4,4]

---------------------------------------------------
Initial Array:
[1,1,2,2,3,4,4]

i = 0

---------------------------------------------------
j = 1

nums[j] = 1
nums[i] = 1

Same element

Skip

---------------------------------------------------
j = 2

nums[j] = 2
nums[i] = 1

Different element found

i++

i = 1

nums[i] = nums[j]

Array becomes:
[1,2,2,2,3,4,4]

---------------------------------------------------
j = 3

nums[j] = 2
nums[i] = 2

Same element

Skip

---------------------------------------------------
j = 4

nums[j] = 3
nums[i] = 2

Different element found

i++

i = 2

nums[i] = nums[j]

Array becomes:
[1,2,3,2,3,4,4]

---------------------------------------------------
j = 5

nums[j] = 4
nums[i] = 3

Different element found

i++

i = 3

nums[i] = nums[j]

Array becomes:
[1,2,3,4,3,4,4]

---------------------------------------------------
j = 6

nums[j] = 4
nums[i] = 4

Same element

Skip

---------------------------------------------------
Final Output:
k = 4

nums = [1,2,3,4,_,_,_]

---------------------------------------------------
*/
