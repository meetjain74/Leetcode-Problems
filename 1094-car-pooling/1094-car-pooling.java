class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        // Sort trips in ascending order of "from" location
        Arrays.sort(trips,new Comparator<>() {
            public int compare(int[] t1,int[] t2) {
                return t1[1]-t2[1];
            }
        });
        
        // Ascending order of "to" location
        // PriorityQueue stores {to,numPassengers}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] p,int[] q) {
                return p[0]-q[0];
            }
        });
        
        int current = 0;
        for (int[] trip: trips) {
            while (!pq.isEmpty() && pq.peek()[0]<=trip[1]) {
                current -= pq.poll()[1];
            }
            pq.add(new int[]{trip[2],trip[0]});
            current += trip[0];
            if (current>capacity)
                return false;
        }
        
        return true;
    }
}