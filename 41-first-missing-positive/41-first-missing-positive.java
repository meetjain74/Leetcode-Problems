class Solution {
    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> vals = new TreeSet<>();
        for (int i: nums) {
            if (i>0)
                vals.add(i);
        }
        
        for (int i=1;i<=nums.length;i++) {
            if (!vals.contains(i))
                return i;
        }
        
        return nums.length+1;
    }
}