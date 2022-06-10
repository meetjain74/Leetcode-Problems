class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Finding first element belongs to which row
        // i.e finding floor of target in first column
        int index = getFloorInIthColumn(matrix,target,0);
        
        if (index==-1)
            return false;
        
        // Now search inside the row given by index
        return binarySearch(matrix,target,index);
    }
    
    // Returns the index of floor of target value in the ith column of matrix
    private int getFloorInIthColumn(int[][] matrix, int target, int i) {
        int low = 0;
        int high = matrix.length-1;
        
        // If target less than the lowest element return -1
        if (target<matrix[low][i])
            return -1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            
            if (matrix[mid][i]==target)
                return mid;
            else if (matrix[mid][i]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        
        return high;
    }
    
    private boolean binarySearch(int[][] matrix, int target, int row) {
        int low=0;
        int high=matrix[row].length-1;
        
        while (low<=high) {
            int mid = low + (high-low)/2;
            
            if (matrix[row][mid]==target)
                return true;
            else if (matrix[row][mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        
        return false;
    }
}