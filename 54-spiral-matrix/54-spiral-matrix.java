class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        
        int rowBegin=0,rowEnd=rows-1;
        int colBegin=0,colEnd=cols-1;
        
        while (rowBegin<=rowEnd && colBegin<=colEnd) {
            for (int c=colBegin;c<=colEnd;c++)
                ans.add(matrix[rowBegin][c]);
            for (int r=++rowBegin;r<=rowEnd;r++)
                ans.add(matrix[r][colEnd]);
            for (int c=--colEnd;c>=colBegin && rowBegin<=rowEnd;c--)
                ans.add(matrix[rowEnd][c]);
            for (int r=--rowEnd;r>=rowBegin && colBegin<=colEnd;r--)
                ans.add(matrix[r][colBegin]);
            colBegin++;
        }
        return ans;
    }
}