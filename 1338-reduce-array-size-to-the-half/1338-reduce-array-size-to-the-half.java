class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer> l=new ArrayList<>();
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            l.add(e.getValue());
        }
        
        Collections.sort(l,Collections.reverseOrder());
        
        int count = 0;
        int target = arr.length/2;
        int i = 0;
        while (target>0 && !l.isEmpty()) {
            int curr = l.get(i++);
            count++;
            target -= curr;
        }
        
        return count;
    }
}