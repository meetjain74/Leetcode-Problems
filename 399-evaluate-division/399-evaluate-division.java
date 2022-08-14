class Node {
    String val;
    double wt;
    
    Node(String val,double wt) {
        this.val=val;
        this.wt=wt;
    }
}

class Solution {
    HashMap<String,List<Node>> graph = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        buildGraph(equations,values,n);
        
        int q = queries.size();
        double res[] = new double[q];
        for (int i=0;i<q;i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            
            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                res[i]=-1;
                continue;
            }
            
            HashSet<String> visited = new HashSet<>();
            visited.add(src);
            res[i] = dfs(src,dst,visited);
            if (res[i]==Double.MAX_VALUE)
                res[i] = -1;
        }
        
        return res;
    }
    
    private void buildGraph(List<List<String>> equations,double[] values,int n) {
        for (int i=0;i<n;i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];
            
            if (!graph.containsKey(u)) {
                graph.put(u,new ArrayList<Node>());
            }
            
            List<Node> temp = graph.get(u);
            temp.add(new Node(v,wt));
            
            if (!graph.containsKey(v)) {
                graph.put(v,new ArrayList<Node>());
            }
            
            temp = graph.get(v);
            temp.add(new Node(u,1/wt));
        }
    }
    
    private double dfs(String src,String dst,HashSet<String> visited) {
        if (src.equals(dst))
            return 1.0;
        
        for (Node neigh: graph.get(src)) {
            String v = neigh.val;
            double wt = neigh.wt;
            if (!visited.contains(v)) {
                visited.add(v);
                double tmp = dfs(v,dst,visited);
                if (tmp!=Double.MAX_VALUE)
                    return wt*tmp;
            }
        }
        
        return Double.MAX_VALUE;
    }
}