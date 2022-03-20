class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int val = hm.getOrDefault(nums[i],0);
            if (val==0) hm.put(nums[i],1);
            else hm.put(nums[i],val+1);
        }
        
        for (Map.Entry<Integer,Integer>e : hm.entrySet()) {
            if (e.getValue()%2!=0)
                return false;
        }
        return true;
    }
}