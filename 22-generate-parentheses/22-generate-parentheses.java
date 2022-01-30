class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<> ();
        
        // Using Catalan number
        // Cn = C0Cn-1 + C1C1 + ...... + Cn-1C0
        
        /*
        For n = 0 -> nothing -> 1
        As for n=1 -> () -> 1
        For n=2 -> ()() or (()) -> 2
                {
                    ( 0 ) 1 => C0C1
                    ( 1 ) 0 => C1C0
                }
                
        For n=3 -> 
                {
                    ( 0 ) 2 => C0C2
                    ( 1 ) 1 => C1C1
                    ( 2 ) 0 => C2C0
                }
        
        */
        
        if (n==0)
            result.add("");
        
        for (int c=0;c<n;c++) {
            for (String left: generateParenthesis(c))
                for (String right: generateParenthesis(n-c-1))
                    result.add("("+left+")"+right);
        }
        
        return result;
    }
}