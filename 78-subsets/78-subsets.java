class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        
        // No of subsets possible: 2^N where N is size of array
        int n = nums.length;
        
        int subsets = 1<<n;
        for (int i=0;i<subsets;i++) {
            list.add(getSubset(i,nums));
        }
        
        return list;
    }
    
    public List<Integer> getSubset(int i,int nums[]) {
        List<Integer> a = new ArrayList<>();
        
        int j=0;
        while (i>0) {
            int lastBit = (i&1);
            if (lastBit==1) {
                a.add(nums[j]);
            }
            j++;
            i = i>>1;
        }
        
        return a;
    }
}