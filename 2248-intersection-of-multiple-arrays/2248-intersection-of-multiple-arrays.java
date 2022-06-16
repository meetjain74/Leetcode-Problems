class Solution {
    public List<Integer> intersection(int[][] nums) {
        return method2(nums);
    }
    
    private List<Integer> method1(int[][] nums) {
        int noOfArrays = nums.length;
        int[] res;
        if (noOfArrays==1)
            res=nums[0];
        else {
            res=intersectionOfTwoArrays(nums[0],nums[1]);
            for (int i=2;i<noOfArrays;i++) {
                if (res.length==0)
                    break;
                res = intersectionOfTwoArrays(res,nums[i]);
            }
        }
        
        Arrays.sort(res);
        List<Integer> ans = new ArrayList<>();
        for (int i: res) {
            ans.add(i);
        }
        
        return ans;
    }
    
    private int[] intersectionOfTwoArrays(int[] nums1,int[] nums2) {
        // Stores all values inside nums2
        HashSet<Integer> vals = new HashSet<>();
        for (int i: nums2) {
            vals.add(i);
        }
        
        HashSet<Integer> intersections = new HashSet<>();
        for (int i: nums1) {
            if (vals.contains(i)) 
                intersections.add(i);
        }
        
        int[] ans = new int[intersections.size()];
        int j=0;
        for (Integer i: intersections) {
            ans[j++] = i;
        }
        
        return ans;
    }
    
    private List<Integer> method2(int[][] nums) {
        int noOfArrays = nums.length;
        int[] counts = new int[1001];
        for (int[] arr : nums) {
        	for (int i: arr) 
                counts[i]++;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i=0,len=counts.length;i<len;i++) {
        	if (counts[i]==noOfArrays) 
                ans.add(i);
        }
        return ans;
    }
}