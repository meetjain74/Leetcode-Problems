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
    int celebrity(int M[][], int n) {
    	return method4(M,n);
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
    
    // Method 2
    // Time complexity - O(N^2)
    // Space complexity - O(N)
    private int method2(int M[][],int n) {
        // Create a graph of n persons as vertices
        // ans store its indegree and outdegree
        
        int indegree[] = new int[n]; // No of persons ith person is known by
        int outdegree[] = new int[n]; // No of persons ith person knows
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (M[i][j]==1) {
                    // Person i knows person j
                    outdegree[i]++;
                    // Person j is known by person i
                    indegree[j]++;
                }
            }
        }
        
        for (int i=0;i<n;i++) {
            if (indegree[i]==n-1 && outdegree[i]==0)
                return i;
        }
        
        return -1;
    }
    
    // Method 3
    // Time complexity - O(N)
    // Space complexity - O(1)
    private int method3(int M[][],int n) {
        // Assume person 0 is a potential celebrity candidate
        int celeb = 0;
        
        for (int i=1;i<n;i++) {
            if (M[celeb][i]==1) {
                // Celeb c knows person i - can't be celeb
                // Update the celeb
                celeb = i;
            }
        }
        
        // Now check if celeb is really a celeb
        for (int i=0;i<n;i++) {
            if (M[celeb][i]==1) // If celeb knows ith person
                return -1;
            if (i!=celeb && M[i][celeb]==0) // If celeb is not known by ith person
                return -1;
        }
        
        return celeb;
    }
    
    // Method 4: Using stack
    // Time complexity - O(N)
    // Space complexity - O(1)
    private int method4(int M[][],int n) {
        Stack<Integer> celebs = new Stack<>();
        
        // Push all persons to stack first
        for (int i=0;i<n;i++) {
            celebs.push(i);
        }
        
        // Remove persons from stack until one potential celeb remains on stack
        while (celebs.size()>1) {
            // Pop the top persons from stack
            int first = celebs.pop();
            int second = celebs.pop();
            
            // If first knows second as well as second knows first
            // Both are invalid - Do not push anyone again
            
            // If first knows second - First can't be valid celeb
            // Push second again to stack if second do not know first 
            if (M[first][second]==1 && M[second][first]!=1) {
                celebs.push(second);
            }
            
            // Else second knows first - second can't be valid celeb
            // Push first again to stack
            else {
                celebs.push(first);
            }
        }
        
        int celeb = celebs.pop(); // Potential candidate for celeb
        
        // Now check if celeb is really a celeb
        for (int i=0;i<n;i++) {
            if (M[celeb][i]==1) // If celeb knows ith person
                return -1;
            if (i!=celeb && M[i][celeb]==0) // If celeb is not known by ith person
                return -1;
        }
        
        return celeb;
    }
}