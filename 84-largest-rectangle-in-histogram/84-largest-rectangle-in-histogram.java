class Solution {
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
    
    // Returns an array of indexes of previous greater element 
    // for every element in nums array
    private int[] previousGreaterIndex(int[] nums) {
        int n = nums.length;
        int[] prevGreater = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i=0;i<n;i++) {
            while (!s.isEmpty() && nums[s.peek()]<=nums[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                prevGreater[i] = -1;
            }
            else {
                prevGreater[i] = s.peek();
            }
            
            s.push(i);
        }
        return prevGreater;
    }
    
    // Returns an array of indexes of next greater element 
    // for every element in nums array
    private int[] nextGreaterIndex(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i=n-1;i>=0;i--) {
            while (!s.isEmpty() && nums[s.peek()]<=nums[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            }
            else {
                nextGreater[i] = s.peek();
            }
            
            s.push(i);
        }
        return nextGreater;
    }
}