// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.makeProductOne(arr,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int makeProductOne(int[] arr, int N) {
        // code here
        int ans=0;
        int product = 1;
        int zeroCount = 0;
        
        for (int i: arr) {
            if (i<0) {
                ans = ans + (-1-i);
                product = -1*product;
            }
            else if (i>0) {
                ans = ans + (i-1);
            }
            else { //if i==0
                ans = ans + 1; 
                zeroCount++;
            }
        }
        
        if (product==-1 && zeroCount==0) 
            ans=ans+2;
            
        return ans;
    }
};