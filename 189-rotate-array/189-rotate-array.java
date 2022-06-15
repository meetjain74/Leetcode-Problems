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
        while(startIndex<endIndex){
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}