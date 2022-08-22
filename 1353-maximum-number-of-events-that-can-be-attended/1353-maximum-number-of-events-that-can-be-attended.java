class Solution {
    public int maxEvents(int[][] events) {
        // Sort on start time
        Arrays.sort(events,new Comparator<>(){
            public int compare(int a[],int b[]) {
                if (a[0]==b[0])
                    return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        
        int maxDay = 0;
        for (int i=0;i<events.length;i++) {
            maxDay = Math.max(maxDay,events[i][1]);
        }
        
        // Stores end day of events in ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int curr = 0;
        int day[] = new int[maxDay+1];
        int count = 0;
        
        for (int d=1;d<=maxDay;d++) {
            // Remove events that have been ended before today
            while (!pq.isEmpty() && pq.peek()<d) {
                pq.poll();
            }
            
            // Add events that start today
            while (curr<events.length && events[curr][0]==d) {
                pq.add(events[curr][1]);
                curr++;
            }
            
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }
        
        return count;
    }
}