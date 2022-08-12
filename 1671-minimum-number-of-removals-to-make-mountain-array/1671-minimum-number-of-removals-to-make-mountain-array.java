class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // LIS from left to right including current element
        int left[] = new int[n];
        int lis[] = new int[n];
        int len = 0;
        for (int i=0;i<n;i++) {
            int temp = getPos(lis,nums[i],len);
            lis[temp] = nums[i];
            if (temp==len)
                len++;
            
            left[i] = temp+1;
        }
        
        // LIS from right to left including current element
        int right[] = new int[n];
        lis = new int[n];
        len = 0;
        for (int i=n-1;i>=0;i--) {
            int temp = getPos(lis,nums[i],len);
            lis[temp] = nums[i];
            if (temp==len)
                len++;
            
            right[i] = temp+1;
        }
        
        int maxLen = 0; //Max length of bitonic subarray
        for (int i=0;i<n;i++) {
            if (right[i]==1 || left[i]==1)
                continue;
            maxLen = Math.max(maxLen,right[i]+left[i]-1);
        }

        return n-maxLen;
    }
    
    private int getPos(int[] nums,int key,int n) {
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (nums[mid]==key)
                return mid;
            if (nums[mid]>key)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
}