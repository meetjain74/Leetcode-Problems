class Node implements Comparable<Node>{
    int x;
    int y;
    int diff; //Absolute difference
    
    Node(int x,int y,int diff) {
        this.x=x;
        this.y=y;
        this.diff=diff;
    }
    
    // Ascending order of difference
    public int compareTo(Node n) {
        return this.diff-n.diff;
    }
}

class Solution {
    int[][] dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            visited[x][y]=true;
                        
            if (x==row-1 && y==col-1)
                return curr.diff;
            
            for (int[] d: dir) {
                int x1 = x+d[0];
                int y1 = y+d[1];
                
                if (x1<0 || x1>=row || y1<0 || y1>=col || visited[x1][y1])
                    continue;
                
                int diff = Math.abs(heights[x1][y1]-heights[x][y]);
                pq.add(new Node(x1,y1,Math.max(curr.diff,diff)));
            }
        }
        
        return -1;
    }
}