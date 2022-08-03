class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0]; //max product so far
        int min = nums[0]; //min product so far
        int ans = max;

        for (int i=1;i<nums.length;i++) {
            int num = nums[i];
            if (num<0) {
                // swap min and max
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(num,max*num);
            min = Math.min(num,min*num);
            ans = Math.max(ans,max);
        }
        
        return ans;
    }
}