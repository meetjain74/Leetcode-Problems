class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: arr) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            pq.add(e.getValue());
        }
        
        int count = 0;
        int target = arr.length/2;
        while (target>0 && !pq.isEmpty()) {
            int curr = pq.poll();
            count++;
            target -= curr;
        }
        
        return count;
    }
}