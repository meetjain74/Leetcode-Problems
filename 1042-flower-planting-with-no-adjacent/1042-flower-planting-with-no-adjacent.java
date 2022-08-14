class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int[] gardenNoAdj(int n, int[][] paths) {
        buildGraph(paths,n+1);
        int[] flower = new int[n];
        Arrays.fill(flower,-1);
        
        boolean[] available = new boolean[5];
        Arrays.fill(available,true); // Initially all flowers available
        
        // Give first flower to first garden
        flower[1-1]=1;
        available[1]=false;
        
        for (int i=2;i<=n;i++) {
            
            // For current garden, check which flowers are not available
            // i.e check which flowers are already used by neighbors
            for (int neigh: graph.get(i)) {
                if (flower[neigh-1]!=-1) {
                    available[flower[neigh-1]]=false;
                }
            }
            
            int color = 0;
            for (int j=1;j<=4;j++) {
                if (available[j]) {
                    color=j;
                    break;
                }
            }
            
            flower[i-1] = color;
            
            //Reset available flowers for next iteration
            Arrays.fill(available,true);
        }
        
        return flower;
    }
    
    private void buildGraph(int[][] paths,int n) {
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] p: paths) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }
    }
}