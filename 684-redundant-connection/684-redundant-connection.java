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
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        int[] ans = new int[2];
        for (int[] edge:edges) {
            int x = edge[0];
            int y = edge[1];
            if (ds.find(x)==ds.find(y))
                ans=edge;
            ds.union(x,y);
        }
        return ans;
    }
}