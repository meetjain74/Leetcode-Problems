class Solution {
    int mod = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long res = 0;
        HashMap<Integer,Long> map= new HashMap<>();
        for (int i=0;i<n;i++) {
            map.put(arr[i],1L);
        }
        
        for (int i=0;i<n;i++) {
            int num = arr[i];
            // Consider tree rooted at num
            // Consider all pair products possible for num
            long temp = map.get(num);
            for (int d=2;d*d<=num;d++) {
                if (num%d==0) {
                    // num is divisible by d
                    // Other divisor- num/d
                    int p = num/d;
                    
                    // Check if both exists in map
                    // Consider subtree rooted at d and p
                    if (map.containsKey(d) && map.containsKey(p)) {
                        long ways = (map.get(d)*map.get(p))%mod;
                        if (d!=p)
                            ways = (ways*2)%mod;
                        temp = (temp+ways)%mod;
                    }
                }
            }
            map.put(num,temp);
            res = (res+temp)%mod;
        }
        
        return (int)res;
    }
}