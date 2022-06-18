// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends

//User function Template for Java

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	return method1(M,n);
    }
    
    
    // Method 1
    // Time complexity - O(N^2)
    // Space complexity - O(1)
    private int method1(int M[][],int n) {
        // Check for all persons if he is a celebrity
        
        for (int i=0;i<n;i++) {
            // Checking person i is celebrity or not
            
            // knows no one: row with all zeroes
            boolean knowNobody = true;
            for (int j=0;j<n;j++) {
                if (M[i][j]==1) {
                    knowNobody = false;
                    break;
                }
            }
            
            if (!knowNobody)
                continue;
            
            // known by everyone: column with all ones except diagonal element
            boolean knownByAll = true;
            for (int j=0;j<n;j++) {
                if (j!=i && M[j][i]==0) {
                    knownByAll = false;
                    break;
                }
            }
            
            if (knowNobody && knownByAll)
                return i;
        }
        
        return -1;
    }
}