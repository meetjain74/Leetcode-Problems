class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int cpos = -1; // Current position of char c in string
        int ans[] = new int[n];
        
        // Traversing from left to right
        for (int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if (ch==c) {
                ans[i]=0;
                cpos=i;
                continue;
            }
            if (cpos==-1) {
                ans[i]=n; // Char not found- Store infinity
            }
            else {
                ans[i]=i-cpos;
            }
        }
        
        cpos = -1;
        // Traversing from right to left
        for (int i=n-1;i>=0;i--) {
            char ch = s.charAt(i);
            if (ch==c) {
                ans[i]=0;
                cpos=i;
                continue;
            }
            if (cpos!=-1) {
                ans[i]=Math.min(ans[i],cpos-i);
            }
        }
        
        return ans;
    }
}