class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int answer=nums[0]+nums[1]+nums[2];
        for (int i=0;i<nums.length-2;i++) {
            int low=i+1;
            int high=nums.length-1;
            
            while (low<high) {
                int current_sum = nums[i]+nums[low]+nums[high];
                if (current_sum>target)
                    high--;
                else
                    low++;
                
                if (Math.abs(current_sum-target)<Math.abs(answer-target))
                    answer = current_sum;
            }
        }
        return answer;
    }
}