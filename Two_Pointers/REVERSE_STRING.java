package Two_Pointers;

/*LEETCODE 344 - REVERSE STRING

Write a function that reverses a string.
The input string is given as a character array s.

You must do this by modifying the input array
in-place with O(1) extra memory.

Example:
Input: s = ['h','e','l','l','o']
Output: ['o','l','l','e','h']

---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Create a new character array
- Copy elements from end to start
- Put reversed characters back into original array
---------------------------------------------------
*/

import java.util.*;

class BruteForceSolution {
    public void reverseString(char[] s) {

        char[] temp = new char[s.length];

        int index = 0;

        // Store reverse characters
        for (int i = s.length - 1; i >= 0; i--) {
            temp[index++] = s[i];
        }

        // Copy back to original array
        for (int i = 0; i < s.length; i++) {
            s[i] = temp[i];
        }
    }
}

/*
---------------------------------------------------
BETTER APPROACH - Using Stack
Time Complexity: O(n)
Space Complexity: O(n)

Idea:
- Push all characters into stack
- Pop characters back into array
- Stack automatically reverses order
---------------------------------------------------
*/

class BetterSolution {
    public void reverseString(char[] s) {

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char ch : s) {
            stack.push(ch);
        }

        // Pop back into array
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}

/*
---------------------------------------------------
OPTIMAL APPROACH - Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)

Idea:
- Use two pointers
- One at start and one at end
- Swap characters
- Move pointers inward
---------------------------------------------------
*/

class OptimalSolution {
    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            // Swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

/*
---------------------------------------------------
DRY RUN CODE

Input:
s = ['h','e','l','l','o']

---------------------------------------------------
Initial Array:
['h','e','l','l','o']

left = 0
right = 4

---------------------------------------------------
Swap s[left] and s[right]

Swap:
'h' <-> 'o'

Array becomes:
['o','e','l','l','h']

left++
right--

left = 1
right = 3

---------------------------------------------------
Swap s[left] and s[right]

Swap:
'e' <-> 'l'

Array becomes:
['o','l','l','e','h']

left++
right--

left = 2
right = 2

---------------------------------------------------
left is not less than right

Loop Ends

---------------------------------------------------
Final Output:
['o','l','l','e','h']

---------------------------------------------------
*/
