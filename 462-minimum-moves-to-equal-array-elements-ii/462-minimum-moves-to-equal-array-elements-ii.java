class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int mid = n/2;
        
        int moves = 0; // Move complete array to equal to mid
        
        for (int i=0;i<n;i++) {
            moves += Math.abs(nums[mid]-nums[i]);
        }
        
        return moves;
    }
}