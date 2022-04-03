class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        List<Integer> tempMax = findElement(nums);
        if (count(nums,tempMax.get(0))>nums.length/3)
            ans.add(tempMax.get(0));
        if (tempMax.get(1)!=tempMax.get(0) && count(nums,tempMax.get(1))>nums.length/3)
            ans.add(tempMax.get(1));
        
        return ans;
    }
    
    public List<Integer> findElement(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        int count1 = 1;
        int count2 = 0;
        
        for (int i=1;i<nums.length;i++) {
            if (nums[i]==first) {
                count1++;
            }
            else if (nums[i]==second) {
                count2++;
            }
            
            else if (count1==0) {
                first=nums[i];
                count1++;
            }
            else if (count2==0) {
                second=nums[i];
                count2++;
            }
            
            else {
                count1--;
                count2--;
            }
        }
        
        temp.add(first);
        temp.add(second);
        
        return temp;
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