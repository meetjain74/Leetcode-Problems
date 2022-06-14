class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        
        // Hashmap stores the fruit type as key and no of trees with such fruits
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int maxFruits = 0;

        while (end<n) {
            // Add tree detail to map
            if (hm.containsKey(fruits[end])) {
                int val = hm.get(fruits[end]);
                hm.put(fruits[end],val+1);
            }
            else {
                hm.put(fruits[end],1);
            }
            
            // Map size should be 2 for ans
            int size = hm.size();
            if (size<=2) {
                maxFruits = Math.max(maxFruits,end-start+1);
                end++;
            }
            else { //size>2
                while (start<end && size>2) {
                    int val = hm.get(fruits[start]);
                    if (val==1) 
                        hm.remove(fruits[start]);
                    else
                        hm.put(fruits[start],val-1);
                    size=hm.size();
                    start++;
                }
                end++;
            }
        }
        
        return maxFruits;
    }
}