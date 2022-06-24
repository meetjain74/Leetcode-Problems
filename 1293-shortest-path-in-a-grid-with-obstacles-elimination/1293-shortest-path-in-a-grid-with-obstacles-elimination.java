class Solution {
    int steps = Integer.MAX_VALUE;
    public int shortestPath(int[][] grid, int k) {
        return method2(grid,k);
    }
    
    /**************************************************************************/
    
    // Method 1: Using DFS -> Fails
    // Time limit exceeded- 28/52 test cases passed
    private int method1(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        
        // Represents minimum no of obstacles to be passed to reach i,j
        int obstacles[][] = new int[m][n];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                obstacles[i][j]=Integer.MAX_VALUE;
            }
        }
        
        helper(grid,k,0,0,m,n,0,visited,obstacles,0);
        return steps==Integer.MAX_VALUE ? -1 : steps;
    }
    
    private void helper(int[][] grid,int k,int currX,int currY,
                       int m,int n,int currSteps,boolean[][] visited,
                        int[][] obstacles,int currObstacles) {        
        if (currX>=m || currX<0 || currY<0 || currY>=n || visited[currX][currY]) {
            return;
        }
        
        // if current steps already greater than min so far
        if (currSteps>steps) {
            return;
        }
        
        if (currX==m-1 && currY==n-1) {
            steps = Math.min(steps,currSteps);
            return;
        }
        
        // If current block is an obstacle
        if (grid[currX][currY]==1) {
            currObstacles++;
            if (k==0)
                return;
            k--;
        }
        
        if (currObstacles>obstacles[currX][currY]) {
            return;
        }
        else {
            obstacles[currX][currY]=currObstacles;
        }
        
        visited[currX][currY]=true;
        
        // right down left up 
        helper(grid,k,currX,currY+1,m,n,currSteps+1,visited,obstacles,currObstacles);
        helper(grid,k,currX+1,currY,m,n,currSteps+1,visited,obstacles,currObstacles);
        helper(grid,k,currX,currY-1,m,n,currSteps+1,visited,obstacles,currObstacles);
        helper(grid,k,currX-1,currY,m,n,currSteps+1,visited,obstacles,currObstacles);
        
        visited[currX][currY]=false;
    }
    
    /******************************************************************************/
    
    // Method 2 : Using BFS
    private int method2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][][] = new boolean[m][n][k+1];
        
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,k));
        int minSteps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Point p = q.poll();
                
                // If curr is destination
                if (p.x==m-1 && p.y==n-1)
                    return minSteps;
                
                for (int[] d: dir) {
                    int currX = p.x+d[0];
                    int currY = p.y+d[1];
                    int obstacles = p.k;
                    
                    if (currX<0 || currX>=m || currY<0 || currY>=n) {
                        continue;
                    }
                    else {
                        // If cell is empty and not visited
                        if (grid[currX][currY]==0 && 
                            !visited[currX][currY][obstacles]) {
                            q.add(new Point(currX,currY,obstacles));
                            visited[currX][currY][obstacles]=true;
                        }
                        
                        else if (grid[currX][currY]==1 &&
                                obstacles>0 && !visited[currX][currY][obstacles-1]) {
                            q.add(new Point(currX,currY,obstacles-1));
                            visited[currX][currY][obstacles-1]=true;
                        }
                    }
                }
            }
            
            minSteps++;
        }
        
        return -1;
    }
    
    class Point {
        int x;
        int y;
        int k; // obstacles
        
        Point(int x,int y,int k) {
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }
    
}