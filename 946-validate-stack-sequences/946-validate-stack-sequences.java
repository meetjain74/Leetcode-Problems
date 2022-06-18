class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        
        while (i<pushed.length && j<popped.length) {
            
            if (pushed[i]!=popped[j]) {
                while (!stack.isEmpty() && stack.peek()==popped[j]) {                   
                    stack.pop();
                    j++;
                }
                
                stack.push(pushed[i]);
                i++;
            }
            
            else if (pushed[i]==popped[j]) {
                // Push into stack and pop from stack
                i++;
                j++;
            }
        }
        
        while (j<popped.length) {
            if (stack.pop()!=popped[j])
                return false;
            j++;
        }
        
        return true;
    }
}