import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i]; // current number in the array
            int complement = target - current; // the number we need to find to reach target

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If it exists, return the indices of the complement and current number
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number and its index in the map
            map.put(current, i);
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution found");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        // Output the result
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}

/*
Step-by-step explanation:

HashMap usage:
We store numbers we’ve seen so far along with their indices.
Key = number, Value = index.

Complement calculation:
For each number num, calculate complement = target - num.
If the complement is already in the map, it means we found two numbers that sum to target.

Why HashMap?
Lookup in a HashMap is O(1) on average.
So we can find the complement efficiently without checking all previous elements.

Time Complexity:
Looping through nums → O(n)
HashMap operations → O(1)
→ Overall = O(n)

Space Complexity:
Storing numbers in the map → O(n) 
*/
