class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Stores all values inside nums2
        HashSet<Integer> vals = new HashSet<>();
        for (int i=0,len=nums2.length;i<len;i++) {
            vals.add(nums2[i]);
        }
        
        HashSet<Integer> intersections = new HashSet<>();
        for (int i=0,len=nums1.length;i<len;i++) {
            if (vals.contains(nums1[i])) 
                intersections.add(nums1[i]);
        }
        
        int[] ans = new int[intersections.size()];
        int j=0;
        for (Integer i: intersections) {
            ans[j++] = i;
        }
        
        return ans;
    }
}