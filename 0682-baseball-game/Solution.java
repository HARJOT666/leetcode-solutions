
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.peek();
                stack.push(num1);
                stack.push(num1 + num2);
            }
            else if (operations[i].equals("C")) {
                stack.pop();
            }
            else if (operations[i].equals("D")) {
                int num = stack.peek();
                stack.push(num * 2);
            }
            else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
