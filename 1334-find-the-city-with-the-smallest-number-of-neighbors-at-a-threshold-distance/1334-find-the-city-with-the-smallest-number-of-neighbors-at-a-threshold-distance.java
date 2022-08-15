class Node implements Comparable<Node> {
    int val;
    int wt;
    
    Node(int val,int wt) {
        this.val=val;
        this.wt=wt;
    }
    
    public int compareTo(Node n) {
        return this.wt-n.wt;
    }
}

class Solution {
    List<List<Node>> graph = new ArrayList<>();
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        buildGraph(n,edges);
        int count[] = new int[n]; //Count neighbors for each city
        
        for (int i=0;i<n;i++) {
            count[i]=getNeighbors(i,distanceThreshold,n);
        }
                
        int min = n-1;
        int minCount = count[n-1];
        for (int i=n-2;i>=0;i--) {
            if (count[i]<minCount) {
                minCount = count[i];
                min = i;
            }
        }
        
        return min;
    }
    
    private void buildGraph(int n,int[][] edges) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            graph.get(u).add(new Node(v,wt));
            graph.get(v).add(new Node(u,wt));
        }
    }
    
    private int getNeighbors(int src,int threshold,int n) {
        //Apply dijkstra algorithm at source 
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src,0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.val;
            
            if (curr.wt>threshold)
                break;
            
            for (Node neigh: graph.get(u)) {
                int v = neigh.val;
                int wt = neigh.wt;
                
                if (dist[v]>dist[u]+wt) {
                    dist[v]=dist[u]+wt;
                    pq.add(new Node(v,dist[v]));
                }
            }
        }
        
        
        int count = 0;
        for (int i=0;i<n;i++) {
            if (i!=src && dist[i]<=threshold)
                count++;
        }
        
        return count;
    }
}