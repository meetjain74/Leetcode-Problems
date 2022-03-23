// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean visited[][] = new boolean[n][n]; // Matrix with default value false
        ArrayList<String> ans = new ArrayList<>();
        
        if (m[0][0]==0 || m[n-1][n-1]==0) {
            ans.add("-1");
            return ans;
        }
        
        visited[0][0] = true;
        helper(ans,m,visited,0,0,n,"");
        
        if (ans.size()==0) 
            ans.add("-1");
        
        return ans;
    }
    
    public static void helper(ArrayList<String> ans,int[][] m,boolean[][] visited,
                int currX,int currY,int n,String str) {
        
        // Base case - If reached at destination
        if (currX==n-1 && currY==n-1) {
            ans.add(str);
            return;
        }
        
        // Recursive case
        
        // Down
        if (currX<n-1 && m[currX+1][currY]==1 && !visited[currX+1][currY]) {
            visited[currX+1][currY]=true;
            helper(ans,m,visited,currX+1,currY,n,str+"D");
            visited[currX+1][currY]=false;
        }
        
        // Left
        if (currY>0 && m[currX][currY-1]==1 && !visited[currX][currY-1]) {
            visited[currX][currY-1]=true;
            helper(ans,m,visited,currX,currY-1,n,str+"L");
            visited[currX][currY-1]=false;
        }
        
        // Right
        if (currY<n-1 && m[currX][currY+1]==1 && !visited[currX][currY+1]) {
            visited[currX][currY+1]=true;
            helper(ans,m,visited,currX,currY+1,n,str+"R");
            visited[currX][currY+1]=false;
        }
        
        // Up
        if (currX>0 && m[currX-1][currY]==1 && !visited[currX-1][currY]) {
            visited[currX-1][currY]=true;
            helper(ans,m,visited,currX-1,currY,n,str+"U");
            visited[currX-1][currY]=false;
        }
    }
}