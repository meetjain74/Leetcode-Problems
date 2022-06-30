class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int mid1 = (n-1)/2;
        int mid2 = n/2;
        
        int moves1 = 0; // Move complete array to equal to mid1
        int moves2 = 0; // Move complete array to equal to mid2
        
        for (int i=0;i<n;i++) {
            if (i<mid1) {
                moves1 += (nums[mid1]-nums[i]);
                moves2 += (nums[mid2]-nums[i]);
            }
            else if (i<mid2) {
                moves1 += (nums[i]-nums[mid1]);
                moves2 += (nums[mid2]-nums[i]);
            }
            else {
                moves1 += (nums[i]-nums[mid1]);
                moves2 += (nums[i]-nums[mid2]);
            }
        }
        
        return Math.min(moves1,moves2);
    }
}