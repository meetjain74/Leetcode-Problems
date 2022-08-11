class Node implements Comparable<Node> {
    int val;
    double wt;
    
    Node(int val,double wt) {
        this.val=val;
        this.wt=wt;
    }
    
    // Descending order of wts
    public int compareTo(Node n) {
        if (n.wt>this.wt)
            return 1;
        else if (n.wt<this.wt)
            return -1;
        return 0;
    }
}

class Solution {
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        buildGraph(n,edges,succProb);
        // max probability for each node
        double[] maxProb = new double[n];
        dijkstra(start,maxProb);
        return maxProb[end];
    }
    
    private void buildGraph(int n,int[][] edges,double[] succProb) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];
            
            graph.get(u).add(new Node(v,wt));
            graph.get(v).add(new Node(u,wt));
        }
    }
    
    private void dijkstra(int src,double[] dist) {
        Arrays.fill(dist,0);
        dist[src]=1;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src,1));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node neigh: graph.get(curr.val)) {
                if (dist[neigh.val]<dist[curr.val]*neigh.wt) {
                    dist[neigh.val]=dist[curr.val]*neigh.wt;
                    pq.add(new Node(neigh.val,dist[neigh.val]));
                }
            }
        }
    }
}