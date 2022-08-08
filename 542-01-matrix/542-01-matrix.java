class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        //BFS starting with all nodes with 0
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (mat[i][j]==0) {
                    res[i][j]=0;
                    q.add(new int[]{i,j});
                }
                else {
                    res[i][j]=-1; //Not processed yet
                }
            }
        }
        
        int dir[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i=0;i<size;i++) {
                int[] curr = q.poll();
                int a = curr[0];
                int b = curr[1];
                for (int d[]: dir) {
                    int x=a+d[0];
                    int y=b+d[1];
                    
                    if (x<0 || x>=m || y<0 || y>=n || res[x][y]!=-1)
                        continue;
                    
                    res[x][y]=res[a][b]+1;
                    q.add(new int[]{x,y});
                }
            }
        }
    
        return res;
    }
}