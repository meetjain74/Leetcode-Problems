class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Consider rows in the following manner and calculate
        // the largest rectangular area in each case
        // Row 0 first (0 indexed)
        // Then row 0 and row 1
        // Then row 0, row 1 and row2
        // and so on until all rows
        
        int heights[] = new int[cols];
        int maxArea = 0;
        
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (matrix[i][j]=='1') {
                    heights[j] += 1;
                }
                else {
                    heights[j] = 0;
                }
            }
            
            int currMaxArea = largestRectangleArea(heights);
            maxArea = Math.max(maxArea,currMaxArea);
        }
        
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = previousSmallerIndex(heights);
        int[] nextSmaller = nextSmallerIndex(heights);
        
        int maxArea=0;
        for (int i=0;i<n;i++) {
            if (nextSmaller[i]==-1)
                nextSmaller[i]=n; // Rectangle width forward can be considered to the end
            
            int width = nextSmaller[i]-prevSmaller[i]-1;
            int currentArea = heights[i]*width;
            maxArea = Math.max(maxArea,currentArea);
        }
        return maxArea;
    }
    
    // Returns an array of indexes of previous smaller element 
    // for every element in nums array
    private int[] previousSmallerIndex(int[] nums) {
        int n = nums.length;
        int[] prevSmaller = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i=0;i<n;i++) {
            while (!s.isEmpty() && nums[s.peek()]>=nums[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                prevSmaller[i] = -1;
            }
            else {
                prevSmaller[i] = s.peek();
            }
            
            s.push(i);
        }
        return prevSmaller;
    }
    
    // Returns an array of indexes of next smaller element 
    // for every element in nums array
    private int[] nextSmallerIndex(int[] nums) {
        int n = nums.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i=n-1;i>=0;i--) {
            while (!s.isEmpty() && nums[s.peek()]>=nums[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                nextSmaller[i] = -1;
            }
            else {
                nextSmaller[i] = s.peek();
            }
            
            s.push(i);
        }
        return nextSmaller;
    }
}