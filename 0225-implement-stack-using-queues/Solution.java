class MyStack {
Deque<Integer> stack = new ArrayDeque<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        stack.addFirst(x);
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */