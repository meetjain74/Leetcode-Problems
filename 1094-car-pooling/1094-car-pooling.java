class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        return method2(trips,capacity);
    }
    
    // Sort + PriorityQueue
    public boolean method1(int[][] trips, int capacity) {
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
    
    // O(N) Time and space
    public boolean method2(int[][] trips, int capacity) {
        int loc[] = new int[1001]; // No of passengers at each location in bus
        for (int[] trip: trips) {
            loc[trip[1]] += trip[0];
            loc[trip[2]] -= trip[0];
        }
        
        int current = 0; // Current passengers
        for (int i=0;i<1001;i++) {
            current += loc[i];
            if (current>capacity)
                return false;
        }
        
        return true;
    }
}