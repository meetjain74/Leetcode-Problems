class Solution {
    public int[] nextGreaterElements(int[] nums) {
        return method2(nums);
    }
    
    public int[] method1(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        for (int i=0;i<n;i++) {
            for (int j=(i+1)%n;j!=i;j=(j+1)%n) {
                if (nums[i]<nums[j]) {
                    nge[i]=nums[j];
                    break;
                }
            }
        }
        
        return nge;
    }
    
    // Optimized using stack
    public int[] method2(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<>();
        
        // Think of circular array as arrays written twice
        for (int i=2*n-1;i>=0;i--) {
            while (!s.isEmpty() && s.peek()<=nums[i%n]) {
                s.pop();
            }
            
            if (i<n) {
                if (s.isEmpty())
                    nge[i]=-1;
                else
                    nge[i]=s.peek();
            }
            
            s.push(nums[i%n]);
        }
        
        return nge;
    }
}