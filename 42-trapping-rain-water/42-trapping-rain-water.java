class Solution {
    public int trap(int[] height) {
        // Create two auxiliary arrays - left and right
        // Left stores maximum index in its left
        // Right stores maximum index in its right
        
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        
        int maxSoFar = height[0];
        for (int i=0;i<n;i++) {
            if (maxSoFar<height[i]) {
                maxSoFar = height[i];
            }
            left[i] = maxSoFar;
        }
        
        int maxAhead = height[n-1];
        for (int i=n-1;i>=0;i--) {
            if (maxAhead<height[i]) {
                maxAhead = height[i];
            }
            right[i] = maxAhead;
        }
        
        int trapWater = 0;
        for (int i=0;i<n;i++) {
            trapWater = trapWater + Math.min(left[i],right[i]) - height[i];
        }
        
        return trapWater;
    }
}