class MinStack {
    Stack<Integer> stack  = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public MinStack() {
       
    }
    public void push(int value) {
        stack.push(value);
        if(stack2.isEmpty() || value <=stack2.peek()){
            stack2.push(value);
        }
    }
    public void pop() {
        int val = stack.pop();
        if(val == stack2.peek()){
            stack2.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        //How to calculate min in O(1) complexity BC
        return stack2.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */