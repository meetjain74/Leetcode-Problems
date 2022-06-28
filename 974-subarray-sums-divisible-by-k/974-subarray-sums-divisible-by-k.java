class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Stores remainder of prefix sum with k in array
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int sum = 0;
        int count = 0;
        map.put(0,1); // remainder of sum 0 with k is 0
        for (int num: nums) {
            sum = sum+num;
            int rem = sum%k<0 ? sum%k+k : sum%k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        return count;
    }
}