import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        // Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i); // current character

            // If it's an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            // If it's a closing bracket
            else {

                // If stack is empty, there is no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element from the stack
                char top = stack.pop();

                // Check if the popped bracket matches the closing bracket
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // If stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([{}])";

        System.out.println(isValid(s1)); // true
        System.out.println(isValid(s2)); // false
        System.out.println(isValid(s3)); // true
    }
}


/*
    Input
s = "()[]{}"
Output
true
Explanation
( matches )
[ matches ]
{ matches }

All brackets close in the correct order.

    Key Idea (Stack)

A stack follows Last In First Out (LIFO).

Example:

Input: ([{}])

Step-by-step:

(  -> push
[  -> push
{  -> push
}  -> pop {
]  -> pop [
)  -> pop (

Stack becomes empty → Valid

Time Complexity
O(n)

We scan the string once.

Space Complexity
O(n)

Stack may store up to n brackets.

    */
