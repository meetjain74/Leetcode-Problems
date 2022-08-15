class Solution {
    public boolean checkStraightLine(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        
        double m = slope(x1,y1,x2,y2);
        
        int count=2;
        for (int k=2;k<points.length;k++) {
            int x3 = points[k][0];
            int y3 = points[k][1];

            if (m==Integer.MAX_VALUE) {
                count += (x3==x1)?1:0;
                continue;
            }
            if (m==0) {
                count += (y3==y1)?1:0;
                continue;
            }

            double m1 = slope(x1,y1,x3,y3);
            if (m==m1)
                count++;
        }
        
        return count==points.length;
    }
    
    public double slope(int x1,int y1,int x2,int y2) {
        if (x2==x1)
            return Integer.MAX_VALUE;
        if (y2==y1)
            return 0;
        
        double slope = (y2-y1)/((x2-x1)*1.0);
        return slope;
    }
}