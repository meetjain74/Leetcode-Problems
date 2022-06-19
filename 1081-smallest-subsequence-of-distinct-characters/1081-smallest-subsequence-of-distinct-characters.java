class Solution {
    public String smallestSubsequence(String s) {
        // Stores the last index of every character
        int lastIndex[] = new int[26];
        boolean visited[] = new boolean[26];
        getLastIndex(s,lastIndex);
        
        // Create a stack to store the answer i.e
        // stack stores smallest lexicographical string of distinct chars
        Stack<Character> stack = new Stack<>();
        
        for (int i=0,len=s.length();i<len;i++) {
            char ch = s.charAt(i);
            
            if (visited[ch-'a'])
                continue; // Already added 
            
            // Pop elements from stack until top is less than current
            // or top element doesn't have further existence
            
            while (!stack.isEmpty() && stack.peek()>=ch 
                   && lastIndex[stack.peek()-'a']>i) {
                char c = stack.pop();
                visited[c-'a']=false; // Mark again unvisited
            }
            
            // Push current char to stack if not already added
            stack.push(ch);
            
            // Mark character as visited
            visited[ch-'a']=true;
        }
        
        String lexSmallest = "";
        while (!stack.isEmpty()) {
            lexSmallest = stack.pop() + lexSmallest;
        }
        
        return lexSmallest;
    }
    
    private void getLastIndex(String s,int[] lastIndex) {
        for (int i=s.length()-1;i>=0;i--) {
            char ch = s.charAt(i);
            if (lastIndex[ch-'a']==0)
                lastIndex[ch-'a']=i;
        }
    }
}