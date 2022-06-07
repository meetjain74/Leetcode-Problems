class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            int res = isMountain(arr,mid);
            if (res==0) {
                return mid;
            }
            else if (res==1) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        
        return -1;
    }
    
    // 0 means correct mountain
    // 1 means left part of mountain is incorrect
    // 2 means right part of mountain is incorrect
    public int isMountain(int[] arr,int i) {
        // Left part of mountain
        for (int x=1;x<=i;x++) {
            if (arr[x]<arr[x-1])
                return 1;
        }
        
        // Right part of mountain
        for (int x=i+1;x<arr.length;x++) {
            if (arr[x]>arr[x-1])
                return 2;
        }
        
        return 0;
    }
}