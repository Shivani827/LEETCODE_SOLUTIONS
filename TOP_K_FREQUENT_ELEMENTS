/*
LEETCODE 347 - TOP K FREQUENT ELEMENTS
Given an integer array nums and an integer k,
return the k most frequent elements.
Example:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
---------------------------------------------------
BRUTE FORCE APPROACH
Time Complexity: O(n²)
Space Complexity: O(n)
Idea:
- Count frequency manually
- Store frequencies
- Repeatedly find maximum frequency
---------------------------------------------------
*/
import java.util.*;
class BruteForceSolution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map =
            new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            map.put(nums[i], count);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int maxFreq = 0;
            int element = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > maxFreq) {
                    maxFreq = map.get(key);
                    element = key;
                }
            }
            ans[i] = element;
            map.remove(element);
        }
        return ans;
    }
}
/*
---------------------------------------------------
BETTER APPROACH - Sorting Frequencies
Time Complexity: O(n log n)
Space Complexity: O(n)
Idea:
- Store frequency using HashMap
- Sort elements based on frequency
---------------------------------------------------
*/
class BetterSolution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap =
            new HashMap<>();
        for (int num : nums) {
            freqMap.put(
                num,
                freqMap.getOrDefault(num, 0) + 1
            );
        }
        List<Integer> list =
            new ArrayList<>(freqMap.keySet());
        list.sort((a, b) ->
            freqMap.get(b) - freqMap.get(a)
        );
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
/*
---------------------------------------------------
OPTIMAL APPROACH - Bucket Sort
Time Complexity: O(n)
Space Complexity: O(n)
Idea:
- Frequency can range from 1 to n
- Create buckets where:
    index = frequency
- Store numbers based on frequency
---------------------------------------------------
*/
class OptimalSolution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap =
            new HashMap<>();
        for (int num : nums) {
            freqMap.put(
                num,
                freqMap.getOrDefault(num, 0) + 1
            );
        }
        List<Integer>[] bucket =
            new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int[] ans = new int[k];
        int index = 0;
        for (int i = bucket.length - 1;
             i >= 0 && index < k;
             i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
// DRY RUN CODE
/*
Input:
nums = [1,1,1,2,2,3]
k = 2
------------------------------------------------
Step 1:
Store Frequencies
freqMap:
1 -> 3
2 -> 2
3 -> 1
------------------------------------------------
Step 2:
Create Buckets
bucket[1] = [3]
bucket[2] = [2]
bucket[3] = [1]
------------------------------------------------
Step 3:
Traverse bucket from end
Start from highest frequency
i = 3
bucket[3] = [1]
ans = [1]
------------------------------------------------
i = 2
bucket[2] = [2]
ans = [1,2]
index == k
Stop
------------------------------------------------
Final Output:
[1,2]
*/
