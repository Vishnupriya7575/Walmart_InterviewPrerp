import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        // Use a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push the corresponding closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If it's a closing bracket, check if it matches the top of the stack
                if (stack.isEmpty() || stack.pop() != c) {
                    // Either no opening bracket to match, or mismatch found
                    return false;
                }
            }
        }

        // If stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([{}])";

        System.out.println(s1 + " -> " + isValid(s1)); // true
        System.out.println(s2 + " -> " + isValid(s2)); // false
        System.out.println(s3 + " -> " + isValid(s3)); // true
    }
}

/*
Step-by-step explanation:

Why use a stack?

Stacks follow Last-In-First-Out (LIFO).

The most recent opening bracket must be closed first, which matches perfectly with a stack.

Mapping opening to closing:

Push the expected closing bracket when you see an opening bracket.

This way, when a closing bracket appears, you can directly check if it matches the top of the stack.

Checking mismatches:

If the stack is empty when a closing bracket appears → invalid.

If stack.pop() != c → the closing bracket does not match → invalid.

Final check:

If the stack is empty at the end → all brackets matched correctly.

If not empty → there are unmatched opening brackets → invalid.

Time Complexity: O(n)

Each character is processed once.

Space Complexity: O(n)

Stack stores at most n characters.
  */
