class FindSumPairs {
    // Integer,Count in nums2
    HashMap<Integer,Integer> hashmap;
    int[] nums1;
    int[] nums2;
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        hashmap = new HashMap<>();
        for(int i: nums2)
            hashmap.put(i,hashmap.getOrDefault(i,0)+1);
        this.nums1 = nums1;
        this.nums2 = nums2;
    }
    
    public void add(int index, int val) {
        // Removing one occurence of value in current index;
        hashmap.put(nums2[index],hashmap.getOrDefault(nums2[index],0)-1);
        if(hashmap.get(nums2[index]) == 0)
            hashmap.remove(nums2[index]);
        nums2[index] += val;
        hashmap.put(nums2[index],hashmap.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int result = 0;
        for(int i: nums1)
        {
            int diff = tot-i;
            if(hashmap.containsKey(diff))
                result+=hashmap.get(diff);
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */