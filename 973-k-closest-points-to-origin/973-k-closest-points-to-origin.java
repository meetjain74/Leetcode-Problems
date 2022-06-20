class Solution {
    
    class Point implements Comparable<Point>{
        int x;
        int y;
        int distance; // Distance square with origin
        
        public Point(int x,int y) {
            this.x=x;
            this.y=y;
            this.distance=x*x+y*y;
        }
        
        // Descending order of distance
        public int compareTo(Point p) {
            return p.distance-this.distance;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        
        for (int i=0;i<points.length;i++) {
            Point p = new Point(points[i][0],points[i][1]);
            pq.add(p);
            
            if (pq.size()>k) {
                pq.poll();
            } 
        }
        
        int[][] ans = new int[k][2];
        int index=0;
        while (pq.size()!=0) {
            Point p = pq.poll();
            ans[index][0]=p.x;
            ans[index][1]=p.y;
            index++;
        }
        
        return ans;
    }
}