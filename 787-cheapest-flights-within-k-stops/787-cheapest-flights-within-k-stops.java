class Node implements Comparable<Node> {
    int val;
    int price;
    int stops;
    
    Node(int val,int price,int stops) {
        this.val=val;
        this.price=price;
        this.stops=stops;
    }
    
    public int compareTo(Node n) {
        if (this.price==n.price)
            return this.stops-n.stops;
        return this.price-n.price;
    }
}

class Solution {
    List<List<Node>> graph = new ArrayList<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        buildGraph(n,flights);
        int[] price = new int[n];
        int[] stops = new int[n];
        return dijkstra(src,price,stops,k,n,dst);
    }
    
    private void buildGraph(int n,int[][] edges) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e: edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            graph.get(u).add(new Node(v,wt,0));
        }
    }
    
    private int dijkstra(int src,int[] price,int[] stops,int k,int n,int target) {
        Arrays.fill(price,Integer.MAX_VALUE);
        Arrays.fill(stops,Integer.MAX_VALUE);
        price[src]=0;
        stops[src]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src,0,0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.val;
            if (u==target)
                return curr.price;
                
            // k+1 because we also count the detination stop
            if (curr.stops==k+1)
                continue; // Do not consider paths with more than k stops
            
            for (Node neigh: graph.get(u)) {
                int v = neigh.val;
                int wt = neigh.price;
                int nextPrice = curr.price+wt;
                int nextStops = curr.stops+1;
                
                // Consider both paths - Having less stops as well as less cost
                if (stops[v]>nextStops || price[v]>nextPrice) {
                    stops[v] = nextStops;
                    price[v] = nextPrice;
                    pq.add(new Node(v,nextPrice,nextStops));
                }
            }
        }
        
        return -1;
    }
}