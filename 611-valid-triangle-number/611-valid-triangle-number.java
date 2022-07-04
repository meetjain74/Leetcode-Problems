class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        
        for (int k=nums.length-1;k>=2;k--) {
            int c = nums[k]; // Third side of triangle
            
            int start = 0;
            int end = k-1;
            
            while (start<end) {
                int a = nums[start]; // First side of traingle
                int b = nums[end]; // Second side of triangle
                
                // As a,b,c is sorted just need to check if a+b>c
                if (a+b>c) {
                    // At current start this holds true
                    // Means true for all between start and end as value of a increases
                    count += (end-start);
                    end--;
                }
                else {
                    // Increment start to increase the sum of a+b
                    start++;
                }
            }
        }

        return count;
    }
}