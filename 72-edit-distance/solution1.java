class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length()==0)
            return word2.length(); // Insert all characters
        if (word2.length()==0)
            return word1.length(); // Delete all characters
        
        int dp[][] = new int[word1.length()][word2.length()];
        for (int i=0;i<word1.length();i++) {
            Arrays.fill(dp[i],-1);
        }
        
        return match(word1,word2,0,0,dp);
    }
    
    private int match(String word1,String word2,int i,int j,int[][] dp) {
        if (i==word1.length()) {
            return word2.length()-j; //Insert remaining chars
        }
        else if (j==word2.length()) {
            return word1.length()-i; // Delete remaining chars
        }
        
        if (dp[i][j]!=-1)
            return dp[i][j];
            
        if (word1.charAt(i)==word2.charAt(j)) {
            return dp[i][j]=match(word1,word2,i+1,j+1,dp);
        }
        else {
            //Insert
            int a = match(word1,word2,i,j+1,dp);
            //Delete
            int b = match(word1,word2,i+1,j,dp);
            //Replace
            int c = match(word1,word2,i+1,j+1,dp);
            
            return dp[i][j]=1+Math.min(a,Math.min(b,c));
        }
    }
}
