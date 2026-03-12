public class LongestSubstringWithoutRepeating {
    /*
        Given a string s, find the length of the longest substring without repeating characters.
        Input:  s = "abcabcbb"
        Output: 3
        Explanation: "abc" is the longest substring without repeating characters

        If interviewer asks "Why 128?"
        You can say:
        We use an array of size 128 because the ASCII character set contains 128 characters, 
        and char values can directly index this array for O(1) lookup instead of using a HashMap.

        int[] seen = new int[128];
        We create an array of 128 because ASCII has 128 standard characters.

        When we do:
        seen[s.charAt(right)]
        charAt() returns a character, but Java automatically converts it to its ASCII number.

        Example:
        s = "abc"

        Step:
        'a' → ASCII 97 → seen[97]
        'b' → ASCII 98 → seen[98]
        'c' → ASCII 99 → seen[99]

        So the array is used like a fast lookup table.

        seen[97] = 1  → 'a' is already in window
        seen[98] = 1  → 'b' is already in window

        Why not use HashMap?
        We could also write:
        Map<Character, Integer> map = new HashMap<>();
        But array is faster because:
        Method	            Time
        Array lookup	    O(1) very fast
        HashMap lookup	    O(1) but slower

        So interviewers prefer: int[128] 
        when the problem involves characters.

        Key Idea
        Two pointers create a sliding window.
        left → shrinks window
        right → expands window
        
        What seen[] stores
        seen[c] = 1 → character is in current window
        seen[c] = 0 → character not in window

        Time Complexity : O(n)
        Space complexity: O(1)
        */
    

public int lengthOfLongestSubstring(String s) {
    int[] seen = new int[128]; // stores if character is already in window
    int left = 0;              // start of window
    int max = 0;               // max length found
    
    for (int right = 0; right < s.length(); right++) {
        // if current char already exists in window
        
        while (seen[s.charAt(right)] == 1) { //seen[c] == 1 means character c is already in the substring.
            seen[s.charAt(left)] = 0; // remove left character
            left++;                   // shrink window
        }

        // add current char to window
        seen[s.charAt(right)] = 1;

        // update max length
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
