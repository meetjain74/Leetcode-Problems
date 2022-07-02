class DisjointSet
{
	int n;
	int parent[];
	int rank[];

	DisjointSet(int n) {
		this.n=n;
		parent=new int[n];
		rank=new int[n];
		makeSet();
	}

	public void makeSet(int x) {
		if (x>=n)
			throw new IllegalArgumentException("makeSet takes parameter"+ 
                                               " value which is not available");
		parent[x]=-1; // -1 represents elements are in their own set
		rank[x]=0;
	}

	private void makeSet() {
		for (int i=0;i<n;i++)
			makeSet(i);
	}

	// Find absolute parent of x
	public int find(int x) {
		if (parent[x]==-1)
			return x;
		return parent[x]=find(parent[x]);
	}

	// Union to make absolute parent of both same
	public void union(int x,int y) {
		int xParent=find(x);
		int yParent=find(y);
		int xRank=rank[xParent];
		int yRank=rank[yParent];

		// If elements are in same set - no need for union
		if (xParent==yParent)
			return;

		// If x's rank is greater than y's rank
		if (xRank>yRank)
			parent[yParent]=xParent;

		// Else If y's rank is greater than x's rank 
		else if (yRank>xRank)
			parent[xParent]=yParent;

		// If both ranks are equal
		else {
			// Move y under x 
			parent[yParent]=xParent;
			// Increment rank by 1 for resultant tree
			rank[xParent]++;
		}
	}
}


class Solution {
    public int makeConnected(int n, int[][] connections) {
        // For n computers to form a network, require n-1 connections
        if (connections.length < n-1)
            return -1; // Enough connections not available
        
        DisjointSet ds = new DisjointSet(n);
        for (int[] c:connections) {
            ds.union(c[0],c[1]);
        }
        
        int components = 0;
        for (int i=0;i<n;i++) {
            if (ds.parent[i]==-1)
                components++;
        }
        
        return components-1;
    }
}