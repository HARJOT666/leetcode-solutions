class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int i = 0;

        while (i < n) {

            if (!stack.isEmpty() &&
                stack.peek() == '(' && s.charAt(i) == ')') {

                stack.pop();
            }

            else if (!stack.isEmpty() &&
                     stack.peek() == '[' && s.charAt(i) == ']') {

                stack.pop();
            }

            else if (!stack.isEmpty() &&
                     stack.peek() == '{' && s.charAt(i) == '}') {

                stack.pop();
            }

            else {
                stack.push(s.charAt(i));
            }

            i++;
        }

        return stack.isEmpty();
    }
}