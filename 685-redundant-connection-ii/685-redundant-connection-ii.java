class DisjointSet {
    int n;
    int parent[];
    int rank[];
    
    DisjointSet(int n) {
        this.n=n;
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent,-1);
    }
    
    public int find(int x) {
        if (parent[x]==-1)
            return x;
        return parent[x]=find(parent[x]);
    }
    
    public void union(int x,int y) {
        int xParent = find(x);
        int yParent = find(y);
        int xRank = rank[x];
        int yRank = rank[y];
        
        if (xParent==yParent)
            return;
        
        if (xRank>yRank) {
            parent[yParent]=xParent;
            rank[xParent]+=rank[yParent];
        }
        else {
            parent[xParent]=yParent;
            rank[yParent]+=rank[xParent];
        }
    }
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        
        // A tree has n-1 edges and we have n edges
        // If one edge is added to a tree- 
        // There are 3 possibilities
        // A node has 2 parent
        // An edge creates a cycle
        // An edge creates a cycle as well as a node having 2 parent
        
        // We first find the node having two parent
        // And one of the two edges which makes this is the answer
        int ans1 = -1;
        int ans2 = -1;
        int parent[] = new int[n+1];
        Arrays.fill(parent,-1);
        
        for (int i=0;i<n;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (parent[v]==-1) {
                parent[v]=i;
            }
            else {
                ans1 = i;
                ans2 = parent[v];
                break;
            }
        }
        
        // Now we do not consider the edge ans1 in list
        // And see if cycle exists in graph or not
        // If cycle does not exists, ans1 is answer
        // Else if cycle exists then if ans1!=-1 then ans2 is answer
        // else current edge is answer
        
        // To detect cycle in directed graph here we can now apply
        // Disjoint set considering it as undirected graph 
        
        DisjointSet ds = new DisjointSet(n+1);
        for (int i=0;i<n;i++) {
            if (i==ans1)
                continue; // Do not consider this edge
            
            int u = edges[i][0];
            int v = edges[i][1];
            if (ds.find(u)==ds.find(v)) {
                // Cycle exists
                if (ans1==-1) {
                    return edges[i];
                }
                else {
                    return edges[ans2];
                }
            }
            
            ds.union(u,v);
        }
        
        return edges[ans1];
    }
}