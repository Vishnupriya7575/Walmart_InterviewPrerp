public class MaximumSubarray {
  //  (Kadane’s Algorithm)
  // Time: O(n) → single pass
  // Space: O(1) → no extra array needed

public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];   // max sum found so far
    int currentMax = nums[0]; // max sum ending at current position

    for (int i = 1; i < nums.length; i++) {
        // Either start a new subarray at i, or extend current one
        currentMax = Math.max(nums[i], currentMax + nums[i]);
        // Update global maximum
        maxSoFar = Math.max(maxSoFar, currentMax);
    }

    return maxSoFar;
}

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}

/*
Example

Input

[-2,1,-3,4,-1,2,1,-5,4]

Output

6

Explanation

The subarray giving maximum sum is:

[4, -1, 2, 1]
4 + (-1) + 2 + 1 = 6

  Step-by-step idea (Kadane’s Algorithm)

At every element we ask:

Should I:
1. Start a new subarray from this element?
OR
2. Extend the previous subarray?

So we compute:

currentSum = max(nums[i], currentSum + nums[i])

Then update the global maximum:

maxSum = max(maxSum, currentSum)

  */
