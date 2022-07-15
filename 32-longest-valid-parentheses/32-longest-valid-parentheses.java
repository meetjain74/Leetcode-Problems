class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        // Stores the last valid index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initially
        int maxLen = 0;
        
        for (int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if (ch=='(') {
                stack.push(i); // Can be valid for ()
            }
            else { //ch=')'
                stack.pop(); // Pop index of last ( -> one valid ()
                if (stack.isEmpty()) {
                    // String from start upto this point is invalid
                    // Add new last valid
                    stack.push(i);
                }
                else {
                    // Update maxlen with last valid index
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}