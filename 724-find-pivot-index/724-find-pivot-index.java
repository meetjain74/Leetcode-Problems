class Solution {
    public int pivotIndex(int[] nums) {
        int sumRight = sumOfArray(nums);
        int sumLeft = 0;
        for (int i=0;i<nums.length;i++) {
            sumRight -= nums[i];
            if (sumLeft==sumRight)
                return i;
            sumLeft += nums[i];
        }
        
        return -1;
    }
    
    private int sumOfArray(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        return sum;
    }
}