class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Finding nge for nums2
        int[] nge = new int[nums2.length];
        Stack<Integer> s = new Stack<>();
        
        // Element to nge for nums2
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i=nums2.length-1;i>=0;i--) {
            while (!s.isEmpty() && s.peek()<=nums2[i]) {
                s.pop();
            }
            
            if (s.isEmpty()) {
                nge[i]=-1;
            }
            else {
                nge[i]=s.peek();
            }
            
            s.push(nums2[i]);
            map.put(nums2[i],nge[i]);
        }
        
        int ans[] = new int[nums1.length];
        
        for (int i=0;i<nums1.length;i++) {
            ans[i]=map.get(nums1[i]);
        }
        
        return ans;
    }
}