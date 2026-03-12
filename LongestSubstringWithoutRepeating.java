public class LongestSubstringWithoutRepeating {
    /*
        Given a string s, find the length of the longest substring without repeating characters.
        Input:  s = "abcabcbb"
        Output: 3
        Explanation: "abc" is the longest substring without repeating characters
        */

    public static int lengthOfLongestSubstring(String s) {
        // Array to keep track of characters we've seen.
        // Assuming ASCII, so 128 possible characters
        int[] seen = new int[128];

        int left = 0; // Left pointer of the sliding window
        int max = 0;  // Maximum length of substring found so far

        // Iterate through the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right); // Current character at right pointer

            // If we've already seen this character in the current window
            while (seen[currentChar] == 1) {
                // Remove the leftmost character from the window
                seen[s.charAt(left)] = 0;
                left++; // Shrink the window from the left
            }

            // Mark the current character as seen
            seen[currentChar] = 1;

            // Update maximum length: current window size = right - left + 1
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}



/*
✅ Step-by-step explanation:

Sliding Window Concept:

Use two pointers (left and right) to represent the current substring window.

Expand right to include new characters.

Shrink left when a duplicate character is found.

Tracking Characters:

seen array keeps track of characters in the current window.

seen[c] == 1 means character c is already in the substring.

Updating Window:

If currentChar is a duplicate, remove characters from the left until it’s gone.

Always mark currentChar as seen after processing.

Calculating Max Length:

Current window length = right - left + 1.

Update max whenever current window is longer.

Time Complexity: O(n)

Each character is visited at most twice (once by right, once by left).

Space Complexity: O(1)

seen array size is constant (128 for ASCII).
*/
