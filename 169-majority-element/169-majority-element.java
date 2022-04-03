class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = findElement(nums);
        return count(nums,majorityElement)>nums.length/2 ? majorityElement : -1;
    }
    
    
    public int findElement(int[] nums) {
        int max = nums[0];
        int count = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]!=max) {
                count--;
            }else{
                count++;
            }
            if (count==0) {
                max = nums[i];
                count++;
            }
        }
        return max;
    }
    
    public int count(int nums[],int x) {
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==x) 
                count++;
        }
        return count;
    }
}