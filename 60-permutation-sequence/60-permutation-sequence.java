class Solution {
    public String getPermutation(int n, int k) {
        return getPermutation(n,k,new boolean[n+1]);
    }
    
    private String getPermutation(int n,int k,boolean[] visited) {
        if (n<=0)
            return "";
        
        int f = fact(n-1);
        int count = 0;
        while (k>f) {
            k=k-f;
            count++;
        }
        
        for (int i=1;i<=9;i++) {
            if (!visited[i]) {
                if (count==0) {
                    visited[i]=true;
                    return i+getPermutation(n-1,k,visited);
                }
                count--;
            }
        }
        
        return ""; // Never reach here
    }
    
    private int fact(int n) {
        if (n==1 || n==0)
            return 1;
        return n*fact(n-1);
    }
}