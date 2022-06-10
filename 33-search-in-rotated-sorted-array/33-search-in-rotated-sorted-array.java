class Solution {
    public int search(int[] nums, int target) {
        // Find index at which array is rotated 
        // i.e find index of minimum element in array
        int pivot = getRotationIndex(nums);
        
        // Search on the left array of pivot as well as
        // right array of pivot including pivot
        
        int result = binarySearch(nums,target,0,pivot-1);
        if (result==-1) {
            result = binarySearch(nums,target,pivot,nums.length-1);
        }
        
        return result;
    }
    
    private int getRotationIndex(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while (low<=high) {
            if (nums[low]<=nums[high])
                return low;
            
            int mid = low + (high-low)/2;
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            
            if (nums[mid]<nums[prev] && nums[mid]<nums[next])
                return mid;
            
            if (nums[low]<=nums[mid])
                low=mid+1;
            
            else //if (nums[mid]<nums[high])
                high=mid-1;  
        }
        return -1;
    }
    
    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (nums[mid]==target)
                return mid;
            if (nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}