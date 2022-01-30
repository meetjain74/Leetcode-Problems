class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character> ();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '{':
                case '(':
                case '[': st.push(ch);
                          break;
                    
                case '}': if (st.isEmpty() || st.pop()!='{')
                            return false;
                          break;
                    
                case ')': if (st.isEmpty() || st.pop()!='(')
                            return false;
                          break;
                    
                case ']': if (st.isEmpty() || st.pop()!='[')
                            return false; 
                          break;
            }
        }
        
        if (st.isEmpty())
            return true;
        return false;
    }
}