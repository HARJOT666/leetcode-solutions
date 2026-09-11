class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        while(n < tokens.length){
            if(!tokens[n].equals("+") &&
                !tokens[n].equals("-") &&
                !tokens[n].equals("*") &&
                !tokens[n].equals("/")) 
                {
                    stack.push(Integer.parseInt(tokens[n]));
                }
            else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int answer;
                switch (tokens[n]) {
                    case "+":
                        answer = operand1 + operand2;
                        break;
                    case "-":
                        answer = operand1 - operand2;
                        break;
                    case "*":
                        answer = operand1 * operand2;
                        break;
                    case "/":
                        answer = operand1 / operand2;
                        break;
                    default:
                        answer = 0;
                }
                stack.push(answer);
            }
            n++;
        }
        return stack.pop();
    }
}