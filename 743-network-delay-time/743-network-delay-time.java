class Node implements Comparable<Node> {
    int val;
    int wt;
    
    Node(int val,int wt) {
        this.val=val;
        this.wt=wt;
    }
    
    // Ascending order of wts
    public int compareTo(Node n) {
        return this.wt-n.wt;
    }
}


class Solution {
    List<List<Node>> graph = new ArrayList<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        buildGraph(n+1,times);
        // min time taken for signal to reach node from src k
        int[] minTime = new int[n+1];
        dijkstra(n,k,minTime);
        
        // Find max of all times
        int max = 0;
        for (int i=1;i<=n;i++) {
            if (minTime[i]==Integer.MAX_VALUE)
                return -1;
            max = Math.max(max,minTime[i]);
        }
        return max;
    }
    
    private void buildGraph(int n,int[][] times) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] time: times) {
            graph.get(time[0]).add(new Node(time[1],time[2]));
        }
    }
    
    private void dijkstra(int n,int src,int[] minTime) {
        Arrays.fill(minTime,Integer.MAX_VALUE); //infinity
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src,0));
        minTime[src]=0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node neighbor: graph.get(curr.val)) {
                int u = curr.val;
                int v = neighbor.val;
                int currTime = minTime[u];
                int neighWt = neighbor.wt;
                if (minTime[v]>currTime+neighWt) {
                    minTime[v]=currTime+neighWt;
                    pq.add(new Node(v,minTime[v]));
                }
            }
        }
    }
}

