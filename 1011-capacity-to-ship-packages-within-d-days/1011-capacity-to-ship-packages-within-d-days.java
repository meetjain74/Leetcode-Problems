class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Applying binary search on container weight
        
        // Minimum weight of container is equal to maximum weight of available package
        int low = getMax(weights); 
        
        // Maximum weight of container is equal to sum of weights of all packages
        int high = getSum(weights);
        
        int ans = high;
        while (low<=high) {
            int mid = low + (high-low)/2;
            int daysRequired = getNumberOfDays(weights,mid);
            
            if (daysRequired<=days) {
                ans=mid;
                high=mid-1; // Takes less days - Decrease the capacity
            }
            else {
                low=mid+1; // Takes more days - Increase the capacity
            }
        }
        return ans;
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i=1,size=nums.length;i<size;i++) {
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    
    private int getSum(int[] nums) {
        int sum=0;
        for (int i=0,size=nums.length;i<size;i++) {
            sum += nums[i];
        }
        return sum;
    }
    
    // Returns the number of days required to deliver all packages
    // if capacity of container is given
    private int getNumberOfDays(int[] weights, int capacity) {
        int daysCount = 0;
        
        int sum = 0;
        for (int i=0,size=weights.length;i<size;i++) {
            sum = sum+weights[i];
            if (sum>capacity) {
                daysCount++;
                sum=weights[i];
            }
            
            if (sum==capacity) {
                daysCount++;
                sum=0;
            }
        }
        return daysCount + (sum==0 ? 0 : 1);
    }
}