class Solution {
    int maxSubstring(String S) {
        // Understand 0 as 1
        // and 1 as -1
        // Find maximum subarray sum in array
        // Kadane algorithm
         
        int maxDiff = -1;
        
        int runningSum = 0;
        for (int i=0;i<S.length();i++) {
            int val = S.charAt(i)-'0';
            if (val==0)
                val=1;
            else // val==1
                val=-1;
                
            if (runningSum>0) 
                runningSum += val;
            else 
                runningSum = val;
                
            maxDiff = Math.max(runningSum,maxDiff);
        }
        
        return maxDiff;
    }
}
