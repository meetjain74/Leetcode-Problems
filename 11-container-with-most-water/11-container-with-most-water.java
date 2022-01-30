class Solution {
    public int maxArea(int[] height) {
        int start = 0,end = height.length-1; 
        int max = -1;
        
        while (start<end) {
            max = Math.max(max, (end-start)*Math.min(height[start],height[end]));
            if (height[start]<height[end])
                start++;
            else
                end--;
        }
        
        return max;
    }
}