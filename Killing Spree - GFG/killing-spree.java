// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            long ans = ob.killinSpree(N);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long killinSpree(long n)
    {
        long low = 0;
        long high = (long)Math.sqrt(n);
        
        while (low<=high) {
            long mid = low+(high-low)/2;
            
            // Power required to kill first mid persons
            long power = mid*(mid+1)*(2*mid+1)/6;
            if (power==n)
                return mid;
            else if (power>n)
                high=mid-1;
            else
                low=mid+1;
        }
        
        return high;
    }
}
