class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i=0;i<nums.length-2;i++) {
            int a = nums[i]; // First side of triangle
            
            for (int j=i+1;j<nums.length-1;j++) {
                int b = nums[j]; // Second side of triangle 
                
                for (int k=j+1;k<nums.length;k++) {
                    int c = nums[k]; // Third side of triangle
                    
                    // As a,b,c is sorted just need to check if a+b>c
                    if (a+b>c) {
                        count++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}