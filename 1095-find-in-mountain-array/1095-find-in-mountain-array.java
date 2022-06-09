/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peakIndex = findPeakIndex(mountainArr);
        
        int result = orderAgnosticBinarySearch(mountainArr, target, 0, peakIndex);
        
        if (result==-1) {
            result = orderAgnosticBinarySearch(mountainArr, target, peakIndex, 
                                              mountainArr.length()-1);
        }
        
        return result;
    }
    
    private int findPeakIndex(MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length()-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            
            int elemAtMid = mountainArr.get(mid);
            int elemAtMidPlusOne = mountainArr.get(mid+1);
            
            if (elemAtMid>elemAtMidPlusOne) {
                high=mid-1;
            }
            else if (elemAtMid<elemAtMidPlusOne) {
                low=mid+1;
            }
        }
        
        return low;
    }
    
    private int orderAgnosticBinarySearch(MountainArray mountainArr, int target, 
                                          int low, int high) {
        
        boolean isAscending = mountainArr.get(high)>=mountainArr.get(low);
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            int elemAtMid = mountainArr.get(mid);
            
            if (elemAtMid==target)
                return mid;
            
            if (isAscending) {
                if (elemAtMid>target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else {
                if (elemAtMid>target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        
        return -1;
    }
}