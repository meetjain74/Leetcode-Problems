class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minElems;
 
    public MinStack() {
        stack = new Stack<>();
        minElems = new Stack<>();
    }
    
    public void push(int val) {
        if (minElems.isEmpty() || val<=minElems.peek()) {
            minElems.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int x = stack.pop();
        if (x==minElems.peek()) {
            minElems.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minElems.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */