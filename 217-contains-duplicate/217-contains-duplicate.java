class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> vals = new HashSet<>();
        for (int i: nums) {
            if (!vals.add(i))
                return true;
        }
        return false;
    }
}