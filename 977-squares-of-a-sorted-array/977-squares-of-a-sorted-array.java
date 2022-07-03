class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int pos = 0; // index of first positive number
        while (pos<n && nums[pos]<0) {
            pos++;
        }
        
        int neg = pos-1; // index of last negative number
        
        // Two pointer approach
        int index = 0;
        int[] sortedSquares = new int[n];
        
        while (pos<n && neg>=0) {
            int x = nums[pos]*nums[pos];
            int y = nums[neg]*nums[neg];
            
            if (x>y) {
                sortedSquares[index++]=y;
                neg--;
            }
            else {
                sortedSquares[index++]=x;
                pos++;
            }
        }
        
        while (pos<n) {
            sortedSquares[index++]=nums[pos]*nums[pos];
            pos++;
        }
        
        while (neg>=0) {
            sortedSquares[index++]=nums[neg]*nums[neg];
            neg--;
        }
        
        return sortedSquares;
    }
}