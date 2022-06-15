class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int index=0; // Represents index where non-zero elements to be placed
        for (int i=0;i<n;i++) {
            if (nums[i]!=0) {
                swapAtIndex(nums,i,index++);
            }
        }
    }
    
    private void swapAtIndex(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}