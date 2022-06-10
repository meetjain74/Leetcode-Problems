class MyStack {
    Queue<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }
    
    // Using a single queue
    // Time complexity - O(N)
    public void push(int x) {
        stack.add(x);
        for (int i=0;i<stack.size()-1;i++) {
            int num = stack.remove();
            stack.add(num);
        }
    }

    // Time complexity - O(1)
    public int pop() {
        return stack.remove();
    }
    
    // Time complexity - O(1)
    public int top() {
        return stack.peek();
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