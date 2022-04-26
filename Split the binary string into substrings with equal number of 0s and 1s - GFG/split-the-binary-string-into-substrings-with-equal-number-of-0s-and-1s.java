// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends
//User function Template for Java

class Solution {
    public static int maxSubStr(String str) {
       
        int count = 0, ans = 0;
       
        for(int i = 0 ; i < str.length() ; i++){
            
            int x = str.charAt(i) - '0';
            if(x == 0)
                count ++;
            else
                count --;
            
            if(count == 0)
                ans++;
        }
        if(ans == 0 || count != 0)
            return -1;
        return ans;
    }
}

// { Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.maxSubStr(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}  // } Driver Code Ends