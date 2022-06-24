class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j]==word.charAt(0) &&
                   searchWord(i,j,0,board,word,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean searchWord(int currX,int currY,int index,char[][] board,
                              String word, boolean[][] visited){
        if (index==word.length()) {
            return true;
        }

        if (currX<0 || currX>=board.length || currY<0 || currY>=board[0].length ||
           board[currX][currY]!=word.charAt(index) || visited[currX][currY]){
            return false;
        }

        visited[currX][currY]=true;        
        if (searchWord(currX+1,currY,index+1,board,word,visited) || 
            searchWord(currX-1,currY,index+1,board,word,visited) ||
            searchWord(currX,currY+1,index+1,board,word,visited) || 
            searchWord(currX,currY-1,index+1,board,word,visited)) {
            return true;
        }
        visited[currX][currY]=false;
        
        return false;
    }
}