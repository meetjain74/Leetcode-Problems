class Solution {
    public void rotate(int[] nums, int k) {
        k = k%(nums.length); // Reduce k if k>=length of array
        
        if (k==0)
            return;
        
        // Reverse the complete array
        reverseArray(nums,0,nums.length-1);
        
        // Reverse the first k elements and then reverse the remaining elements
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length-1);
    }
    
    public void reverseArray(int[] nums,int startIndex,int endIndex) {
        int reverseEnd = (endIndex-startIndex)/2;
        for (int i=0;i<=reverseEnd;i++) {
            // swap nums[startIndex] and nums[endIndex-i]
            int temp=nums[startIndex];
            nums[startIndex]=nums[endIndex-i];
            nums[endIndex-i]=temp;
            startIndex++;
        }
    }
}