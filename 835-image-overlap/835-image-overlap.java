class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        
        // We apply convolution algorithm
        // Create a padding matrix for img2 
        //  N-1 extra row and columns on each side
        
        int paddedImg[][] = new int[3*n+2][3*n+2];
        
        // Fill the paddedImg with img2 ar center
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                paddedImg[i+n-1][j+n-1]=img2[i][j];
            }
        }
        
        int maxOverlaps = 0;
        for (int xShift=0;xShift<2*n-1;xShift++) {
            for (int yShift=0;yShift<2*n-1;yShift++) {
                int currOverlaps = getOverlaps(img1,paddedImg,xShift,yShift);
                maxOverlaps = Math.max(maxOverlaps,currOverlaps);
            }
        }
        
        return maxOverlaps;
    }
    
    private int getOverlaps(int[][] img1,int[][] paddedImg,int xShift,int yShift) {
        int overlaps = 0;
        int n = img1.length;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                overlaps += img1[i][j]*paddedImg[i+xShift][j+yShift];
            }
        }
        return overlaps;
    }
}