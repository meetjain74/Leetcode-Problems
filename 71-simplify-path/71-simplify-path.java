class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> s = new Stack<>();
        
        for (int i=0;i<tokens.length;i++) {
            String curr = tokens[i];
            if (curr.equals("") || curr.equals("."))
                continue;
            else if (curr.equals("..")) {
                if (!s.isEmpty())
                    s.pop();
                continue;
            }
            else {
                s.push(curr);
            }
        }
        
        if (s.isEmpty()) {
            return "/";
        }
        
        String ans = "";
        while (!s.isEmpty()) {
            ans = "/"+s.pop()+ans;
        }
        
        return ans;
    }
}