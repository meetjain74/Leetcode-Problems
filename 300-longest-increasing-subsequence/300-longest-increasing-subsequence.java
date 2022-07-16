class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n]; // Need not necessarily store lis
        int len = 0;
        
        for (int num: nums) {
            
            // Find correct position to replace/add num in lis
            // Using binary search
            int x = getPos(lis,num,len);
            
            // Low corresponds to that index 
            lis[x] = num;
            if (x==len)
                len++;
        }
        
        return len;
    }

    private int getPos(int[] lis,int num,int len) {
        int low = 0;
        int high = len-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (lis[mid]==num)
                return mid;
            else if (lis[mid]>num)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
        // low corresponds to first index whose value greater than or equal to num
    }
}