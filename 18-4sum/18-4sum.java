class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<> ();
        
        // Sort the array
        Arrays.sort(nums);
        int low,high,myTarget;
        
        // Iterate through array till length-3
        for (int i=0;i<nums.length-3;i++) {
            
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
        
                // Iterate through array till length-2
                for (int j=i+1;j<nums.length-2;j++) {
                    
                    if (j==i+1 || (j>i+1 && nums[j]!=nums[j-1])) {
                        low=j+1;
                        high=nums.length-1;
                        myTarget=target-nums[i]-nums[j];
                        
                        while (low<high) {
                            if (nums[low]+nums[high]==myTarget) {
                                answer.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                                while (low<high && nums[low]==nums[low+1])
                                    low++;
                                while (low<high && nums[high]==nums[high-1])
                                    high--;
                                
                                low++;
                                high--;
                            }
                            else if (nums[low]+nums[high]>myTarget)
                                high--;
                            else
                                low++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}