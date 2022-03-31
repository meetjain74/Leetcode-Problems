class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // No of subsets possible: 2^N where N is size of array
        int n = nums.length;
        
        int subsets = 1<<n;
        Set<List<Integer>> res = new HashSet<>();
        
        for (int i=0;i<subsets;i++) {
            res.add(getSubset(i,nums));
        }     
        return new ArrayList<>(res);
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
        Collections.sort(a);
        return a;
    }
}