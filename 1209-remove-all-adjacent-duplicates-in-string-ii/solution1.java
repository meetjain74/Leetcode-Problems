class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<String> stack = new Stack<>();
        for (char ch:s.toCharArray()) {
            String p = "";
            if (!stack.isEmpty())
                p=stack.peek();
            
            if (p.length()!=0 && p.charAt(0)==ch) {
                if (p.length()+1==k)
                    stack.pop();
                else {
                    stack.pop();
                    stack.push(p+ch);
                }
            }
            else {
                stack.push(ch+"");
            }
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            String p = stack.pop();
            ans = p+ans;
        }
        
        return ans;
    }
}
