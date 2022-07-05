class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        int minSteps = 0;
        
        queue.add(entrance);
        visited[entrance[0]][entrance[1]]=true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i=0;i<size;i++) {
                int[] curr=queue.poll();
                // check if we have reached boundary
                if (!isEntrance(entrance,curr) && isExit(curr,m,n))
                    return minSteps;
                
                for (int[] dir: dirs) {
                    int x = dir[0]+curr[0];                    
                    int y = dir[1]+curr[1];
                    
                    if (x<0 || x>=m ||y<0 || y>=n || visited[x][y] || maze[x][y]=='+') 
                        continue;
					
                    queue.add(new int[]{x,y});
                    visited[x][y]=true;
                }
            }
            
            minSteps++;
        }
        
        return -1;
    }
    
    private boolean isEntrance(int[] entrance,int[] curr) {
        if (entrance[0]==curr[0] && entrance[1]==curr[1])
            return true;
        return false;
    }
    
    private boolean isExit(int[] curr,int m,int n) {
        if (curr[0]==0 || curr[0]==m-1 || curr[1]==0 || curr[1]==n-1) 
            return true;
        return false;
    }
}