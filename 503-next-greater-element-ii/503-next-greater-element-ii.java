class Solution {
    public int[] nextGreaterElements(int[] nums) {
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
}