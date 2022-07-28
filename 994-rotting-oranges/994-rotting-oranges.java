class Pair {
    int x;
    int y;
    
    Pair(int x,int y) {
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // BFS
        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]==1)
                    freshOranges++;
                if (grid[i][j]==2) {
                    q.add(new Pair(i,j));
                }
            }
        }
        
        int minutes=0;
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i=0;i<size;i++) {    
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                
                if (x<0 || x>=m || y<0 || y>=n)
                    continue;
                
                if (grid[x][y]==0 || grid[x][y]==3)
                    continue;
                
                if (grid[x][y]==1) {
                    freshOranges--;
                }
                
                if (freshOranges==0) {
                    return minutes;
                }
                
                grid[x][y]=3; // Mark current visited 
                
                q.add(new Pair(x-1,y));
                q.add(new Pair(x,y-1));
                q.add(new Pair(x,y+1));
                q.add(new Pair(x+1,y));
            }
            minutes++;
        }
        
        return (freshOranges!=0)?-1:0;
    }
}