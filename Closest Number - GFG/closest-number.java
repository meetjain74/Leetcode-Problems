// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.closestNumber(N,M));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int closestNumber(int N , int M) {
        boolean bool = false;
        if (M<0) {
            N=-N;
            M=-M;
            bool=true;
        }
        
        // code here
        int x = N/M;
        int a = M*x;
        int b = M*(x+1);
        if (N<0)
            b = M*(x-1);
        
        int diffA = N>0 ? N-a : a-N;
        int diffB = N>0 ? b-N : N-b;
        
        //System.out.println(x+" "+a+" "+b+" "+diffA+" "+diffB);
        
        if (diffA>diffB)
            return bool?-b:b;
        if (diffB>diffA)
            return bool?-a:a;
            
        if (Math.abs(a)>Math.abs(b))
            return bool?-a:a;
    
        return bool?-b:b;
    }
};