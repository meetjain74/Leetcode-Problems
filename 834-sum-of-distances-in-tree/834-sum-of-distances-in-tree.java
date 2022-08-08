class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        buildGraph(n,edges,graph);
        
        int[] res = new int[n];
        int[] count = new int[n];
        
        // Consider tree rooted at node 0
        // Count[i] stores the number of nodes in the subtree rooted at i 
        // res[i] stores the sum of distances in tree for node i
        
        // Count nodes of each subtree - Using postorder Traversal
        postorder(graph,count,res,0,-1);
        
        // res stores correct answer only for node 0
        
        // Approach 1
        // We can apply the above postorder for every node and find sum
        // of distances in tree for each node 
        
        // Approach 2 
        // We can see that when we move from parent to child
        // count[child] nodes comes closer to child 
        // N-count[child] nodes get farther from child 
        // Hence we can update this accordingly using preorder traversal
        
        preorder(graph,count,res,0,-1,n);
        
        return res;
    }
    
    private void postorder(List<List<Integer>> graph,int[] count,int[] res,
                          int curr,int parent) {
        //  Iterate over all childs
        for (int child: graph.get(curr)) {
            if (child==parent)
                continue;
            postorder(graph,count,res,child,curr);
            
            // Add child nodes count
            count[curr] += count[child];
            
            // Distance of each nodes in subtree at child increases by 1
            // For count[child] nodes, total distance increases by count[child]
            res[curr] += res[child] + count[child];
        }
        
        count[curr]++; // Count itself
    }
    
    private void preorder(List<List<Integer>> graph,int[] count,int[] res,
                          int curr,int parent,int n) {
        //  Iterate over all childs
        for (int child: graph.get(curr)) {
            if (child==parent)
                continue;
            
            res[child] = res[curr] - count[child] + (n-count[child]);
            preorder(graph,count,res,child,curr,n);
        }
    }
    
    private void buildGraph(int n,int[][] edges,List<List<Integer>> graph) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge:edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}