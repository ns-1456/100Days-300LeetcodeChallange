import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        if (isValid("()[]{}")){
            System.out.println("true");
        }
    }

    public static boolean validClosing(char opening, char closing) {
        if (opening == '(' && closing == ')' || opening == '{' && closing == '}' || opening == '[' && closing == ']' ) {return true;}
        return false;
    }

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();

        // Also check the professor Implementation
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !validClosing(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}