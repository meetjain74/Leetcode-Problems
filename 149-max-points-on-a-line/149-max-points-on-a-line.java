class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n==1)
            return 1;
        
        int maxCount = 0;
        for (int i=0;i<n;i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j=i+1;j<n;j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                double m = slope(x1,y1,x2,y2);
                
                int count = 2;
                for (int k=0;k<n;k++) {
                    if (k==i || k==j)
                        continue;
                    
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
                
                maxCount = Math.max(count,maxCount);
            }
        }
        
        return maxCount;
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