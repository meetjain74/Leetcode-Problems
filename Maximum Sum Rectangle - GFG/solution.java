/*Problem link - https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1*/

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        int maxSum = Integer.MIN_VALUE;
        
        // Iterate over columns - Fix two columns left and right
        // Find sum of all rows between these columns
        // and store it in a temporary array of size C
        for (int left=0;left<C;left++) {
            int[] array = new int[R];
            for (int right=left;right<C;right++) {
                
                // Iterate over all rows
                for (int i=0;i<R;i++) {
                    array[i]+=M[i][right];
                }
                
                // Apply Kadane algorithm on array now
                int currMax = kadane(array,R);
                maxSum = Math.max(maxSum,currMax);
            }
        }
        
        return maxSum;
    }
    
    int kadane(int[] array,int n) {
        int maxSum = array[0];
        int currSum = array[0];
        for (int i=1;i<n;i++) {
            currSum = Math.max(array[i],currSum+array[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
};
