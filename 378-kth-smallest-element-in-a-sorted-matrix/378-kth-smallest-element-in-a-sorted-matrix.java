class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int low = matrix[0][0];
        int high = matrix[rows-1][cols-1];
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            int countLessThanMid = getCountLessThanElement(matrix,mid);
            if (countLessThanMid<k)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;
    }
    
    private int getCountLessThanElement(int[][] matrix,int element) {
        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Going over each row and counting
        for (int i=0;i<rows;i++) {
            int low = 0;
            int high = cols-1;
            while (low<=high) {
                int mid = low + (high-low)/2;
                if (matrix[i][mid]<=element)
                    low=mid+1;
                else
                    high=mid-1;
            }
            count += low;
        }
        
        return count;
    }
}