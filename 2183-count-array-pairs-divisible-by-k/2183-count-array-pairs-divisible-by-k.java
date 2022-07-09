class Solution {
    public long countPairs(int[] nums, int k) {
        // Map to store gcd value and its count in array
        HashMap<Integer,Integer> map = new HashMap<>();
        long ans = 0;
        
        for (int i=0;i<nums.length;i++) {
            int x = gcd(nums[i],k);
            // x*y=k and we got x already in nums[i] 
            // Search if a multiple of y exists in map
            int y = k/x;
            for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
                if (entry.getKey()%y==0) {
                    ans += entry.getValue();
                }
            }
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        return ans;
    }
    
    private int gcd(int a,int b) {
        if (a%b==0)
            return b;
        return gcd(b,a%b);
    }
}