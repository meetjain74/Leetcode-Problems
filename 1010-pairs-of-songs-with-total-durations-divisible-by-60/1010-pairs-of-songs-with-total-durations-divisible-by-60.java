class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int t: time) {
            int rem = t%60;
            if (map.containsKey(60-rem)) {
                count += map.get(60-rem);
            }
            else if (rem==0 && map.containsKey(0)) {
                count += map.get(0);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}