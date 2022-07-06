class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        
        //BFS
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int init = image[sr][sc]; // Initial color
        q.add(new int[]{sr,sc});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0]<0 || curr[1]<0 || curr[0]>=m || curr[1]>=n || 
                visited[curr[0]][curr[1]] || image[curr[0]][curr[1]]!=init)
                continue;
            
            image[curr[0]][curr[1]]=color;
            visited[curr[0]][curr[1]]=true;
            
            int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
            for (int[] dir: dirs) {
                int x = curr[0]+dir[0];
                int y = curr[1]+dir[1];
                
                q.add(new int[]{x,y});
            }
        }
        
        return image;
    }
}