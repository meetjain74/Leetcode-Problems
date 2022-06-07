class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        List<List<Integer>> diagonalsList = new ArrayList<>();
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                int diagNum = i+j;
                List<Integer> diagonal;
                if (diagonalsList.size()<=diagNum) {
                    // diagonal list don't exist yet - Create new one
                    diagonal = new ArrayList<Integer>();
                    diagonalsList.add(diagonal);
                }
                else {
                    diagonal = diagonalsList.get(diagNum);
                }
                diagonal.add(mat[i][j]);
            }
        }
        
        int k = 0;
        int res[] = new int[m*n];
        
        // Making answer array
        for (int i=0,size=diagonalsList.size();i<size;i++) {
            List<Integer> diagonal = diagonalsList.get(i);
            // Diagonal indexes which are even should be reversed
            if (i%2==0)
                Collections.reverse(diagonal);
            
            // Add elements to array
            for (int j=0,len=diagonal.size();j<len;j++) {
                res[k++]=diagonal.get(j);
            }
        }
        
        return res;
    }
}