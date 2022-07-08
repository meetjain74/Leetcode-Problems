//Time complexity - O(log(min(n1,n2)))

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if (n1>n2)
            return findMedianSortedArrays(nums2,nums1);
        
        // nums1 is smaller array than nums2 - Apply binary search on small array
        // Divide merged array into two parts - left part and right part
        // For even no of elements both parts should have (n1+n2)/2 elements
        // For odd no of elements left part has (n1+n2+1)/2 elements and rest in right part
        
        // Find the partition in the first array to determine left part
        int low = 0;
        int high = n1;
        
        while(low<=high) {
            // Determine cut to be made in both the arrays
            
            int cut1 = (low+high)/2; // In nums1
            int cut2 = ((n1+n2+1)/2)-cut1; // In nums2
            
            // According to both cuts, both array is divided into two parts
            // Left part: [0,cut1) of nums1 & [0,cut2) of nums2
            // Right part: [cut1,n1) of nums1 & [cut2,n2) of nums2
            // Find the end points of left part and start point of right part
            
            int left1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
            
            int right1 = cut1==n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2==n2 ? Integer.MAX_VALUE : nums2[cut2];
            
            // Is the partition to left and right part correct
            if (left1<=right2 && left2<=right1) {
                
                // Get median
                if ((n1+n2)%2==0) { // Even no of elements
                    double median = (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                    return median;
                }
                else { // Odd no of elements
                    return Math.max(left1,left2);   
                }
            }
            
            // Incorrect partition
            else if (left1>right2) {
                high=cut1-1;
            }
            else {
                low=cut1+1;
            }
        }
        
        return 0.0;
    }
}
