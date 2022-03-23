class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        // Chess board - true representing queen exists
        boolean chess[][] = new boolean[n+1][n+1];
        
        placeQueens(ans,chess,n,1);
        
        return ans;
    }
    
    // Placing queens row wise
    public void placeQueens(List<List<String>> ans,boolean[][] chess,
                            int n,int rowNum) {
        
        // Base case
        if (rowNum>n) {
            ans.add(getStringList(chess,n));
            return;
        }
        
        // Placing one by one at each column
        for (int i=1;i<=n;i++) {
            if (!isConflict(chess,rowNum,i,n)) {
                System.out.println("f"+rowNum+" "+i);
                chess[rowNum][i]=true;
                placeQueens(ans,chess,n,rowNum+1);
                chess[rowNum][i]=false;
            }
        }
    }
    
    // Check whether conflict exists at pos (x,y)
    public boolean isConflict(boolean[][] chess,int x,int y,int n) {
        
        // Check if queen exist in the given row
        for (int i=1;i<=n;i++) {
            if (chess[x][i])
                return true;
        }
        
        // Check if queen exist in the given column
        for (int i=1;i<=n;i++) {
            if (chess[i][y])
                return true;
        }
        
        // Check if queen exist in the -ve slope diagonal
        int row=x-1,col=y-1;
        while(row>0 && col>0) {
            if (chess[row--][col--])
                return true;
        }
        
        row=x+1;
        col=y+1;
        while(row<=n && col<=n) {
            if (chess[row++][col++])
                return true;
        }
        
        // Check if queen exist in the +ve slope diagonal
        row=x-1;
        col=y+1;
        while(row>0 && col<=n) {
            if (chess[row--][col++])
                return true;
        }
        
        row=x+1;
        col=y-1;
        while(row<=n && col>0) {
            if (chess[row++][col--])
                return true;
        }
        
        return false;
    }
    
    public List<String> getStringList(boolean[][] matrix,int n) {
        List<String> res = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            String str = "";
            for (int j=1;j<=n;j++) {
                str+= matrix[i][j] ? "Q" : ".";
            }
            res.add(str);
        }
        return res;
    }
}