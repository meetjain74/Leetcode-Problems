class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n==1) 
            return 0;
        
        int low = 0;
        int high = n-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (mid>0 && mid<n-1) {
                if (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
                    return mid;
                
                else if (nums[mid]>nums[mid+1]) // Answer surely exists in left part
                    high=mid-1; 
                else // Answer surely exists in right part
                    low=mid+1;
            }
            
            else if (mid==0) {
                if (nums[mid]>nums[mid+1])
                    return 0;
                else
                    return 1;
            }
            
            else { // mid == n-1
                if (nums[mid]>nums[mid-1])
                    return n-1;
                else
                    return n-2;
            }
        }
        
        return -1;
    }
}