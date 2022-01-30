class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<> ();
        
        // Sort the array
        Arrays.sort(nums);
        
        // Iterate through the array till length-2
        for (int i=0;i<nums.length-2;i++) {
            
            // Do not calculate triplets for duplicate elements
            if (i==0 || (i>0 && nums[i]!=nums[i-1])) {
                
                // Two sum problem in the front array with sum as target=0-nums[i]
                int low = i+1;
                int high = nums.length-1;
                int target = 0-nums[i];
                
                while (low<high) {
                    if (nums[low]+nums[high]==target) {
                        answer.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        
                        // Do not consider for duplicates now
                        while (low<high && nums[low]==nums[low+1])
                            low++;
                        
                        while (low<high && nums[high]==nums[high-1])
                            high--;
                        
                        low++;
                        high--;
                    }
                    else if (nums[low]+nums[high]>target) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
                
            }   
            
        }
         
        return answer;
    }
}