public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        // Step 1: Initialize current sum and max sum with first element
        int currentSum = nums[0];
        int maxSum = nums[0];

        // Step 2: Traverse the array starting from index 1
        for (int i = 1; i < nums.length; i++) {

            // Decide whether to start a new subarray at nums[i]
            // or extend the previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum subarray sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        // Step 3: Return the maximum sum
        return maxSum;
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
