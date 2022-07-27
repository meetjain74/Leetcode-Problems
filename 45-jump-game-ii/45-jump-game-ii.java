class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int current = 0;
        int farthest = 0; // Farthest index where you can reach
        
        for (int i=0;i<nums.length-1;i++) {
            // Farthest index that can be reached from current index
            farthest = Math.max(farthest,i+nums[i]);
            
            if (i==current) {
                jumps++; // Consider one jump from current to farthest
                current = farthest; // Update the current now to farthest
            }
        }
        
        return jumps;
    }
}