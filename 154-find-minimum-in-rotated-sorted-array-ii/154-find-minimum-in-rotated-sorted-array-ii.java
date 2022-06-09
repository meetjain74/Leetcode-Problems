class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        while (low<=high) {
            // Found the min element window
            if (nums[low]<nums[high] || low==high) {
                return nums[low];
            }
            
            int mid = low + (high-low)/2;
            int prev = (mid+n-1)%n; // mid-1
            int next = (mid+1)%n; // mid+1
            
            //System.out.println(low+" "+high+" "+mid);

            // Mid is min element if minimum than both mid+1 and mid-1
            if (nums[mid]<nums[prev] && nums[mid]<nums[next])
                return nums[mid];
            
            
            if (low<high && nums[low]==nums[low+1])
                low++;
            else if (low<high && nums[high]==nums[high-1])
                high--;
            
            // Move to the unsorted array
            else if (nums[mid]>=nums[low])
                low=mid+1;
            
            else //if (nums[mid]<nums[high])
                high= (mid+1<=high && nums[mid]==nums[mid+1]) ? mid : mid-1;
        }
    
        return -1;
    }
}