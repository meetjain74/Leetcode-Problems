class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstIndexOfElement(nums,target);
        ans[1] = lastIndexOfElement(nums,target);
        return ans;
    }
    
    private int firstIndexOfElement(int nums[],int target) {
        int low = 0;
        int high = nums.length-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            if ( (nums[mid]==target) && ((mid==0) || (mid!=0 && nums[mid-1]!=target)) )
                return mid;
            else if (nums[mid]>=target)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return -1;
    }
    
    private int lastIndexOfElement(int nums[],int target) {
        int low = 0;
        int high = nums.length-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            if ( (nums[mid]==target) && 
                ((mid==nums.length-1) || (mid!=nums.length-1 && nums[mid+1]!=target)) )
                return mid;
            else if (nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return -1;
    }
}