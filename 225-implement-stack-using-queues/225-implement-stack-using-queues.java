class MyStack {
    Queue<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        while(!stack.isEmpty()) {
            temp.add(stack.remove());
        }
        stack.add(x);
        while(!temp.isEmpty()) {
            stack.add(temp.remove());
        }
    }
    
    public int pop() {
        return stack.remove();
    }
    
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