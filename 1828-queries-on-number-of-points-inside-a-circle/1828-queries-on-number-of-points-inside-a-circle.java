class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int q = queries.length;
        int n = points.length;
        int ans[] = new int[q];
        for (int i=0;i<q;i++) {
            int[] query = queries[i];
            int count = 0;
            for (int j=0;j<n;j++) {
                if (isInside(points[j],query))
                    count++;
            }
            ans[i]=count;
        }
        
        return ans;
    }
    
    private boolean isInside(int point[],int query[]) {
        int dist = (query[0]-point[0])*(query[0]-point[0]) + 
                    (query[1]-point[1])*(query[1]-point[1]);
        int r = query[2];
        if (dist>r*r) 
            return false;
        
        return true;
    }
}

