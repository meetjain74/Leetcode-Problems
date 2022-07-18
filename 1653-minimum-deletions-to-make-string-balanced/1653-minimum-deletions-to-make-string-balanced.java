class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        // a[i] stores the number of a's present from ith index to end
        int a[] = new int[n];
        a[n-1] = s.charAt(n-1)=='a' ? 1:0;
        for (int i=n-2;i>=0;i--) {
            a[i] = a[i+1] + (s.charAt(i)=='a'?1:0);
        }
        
        int minDel = Integer.MAX_VALUE;
        int b = 0; // Stores count of b till now 
        for (int i=0;i<n;i++) {
            if (s.charAt(i)=='b') {
                // Break at this point - a before this point and b after this point
                int currDel = b+a[i];
                b++;
                minDel = Math.min(minDel,currDel);
            }
        }
        
        minDel = Math.min(minDel,b); // Might happen no b exists
        
        return minDel;
    }
}