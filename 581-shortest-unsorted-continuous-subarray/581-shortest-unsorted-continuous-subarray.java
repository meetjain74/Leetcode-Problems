class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int i=0,j=n-1;
        
        while (i<n-1 && nums[i]<=nums[i+1]) {
            i++;
        }
        
        while (j>0 && nums[j]>=nums[j-1]) {
            j--;
        }
        
        if (i==n-1)
            return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int k=i;k<=j;k++) {
            min = Math.min(min,nums[k]);
            max = Math.max(max,nums[k]);
        }
        
        int low = -1;
        int high = -1;
        for (int k=0;k<n;k++) {
            if (nums[k]>min) {
                low = k;
                break;
            }
        }
        
        for (int k=n-1;k>=0;k--) {
            if (nums[k]<max) {
                high = k;
                break;
            }
        }
        
        return high-low+1;
    }
}