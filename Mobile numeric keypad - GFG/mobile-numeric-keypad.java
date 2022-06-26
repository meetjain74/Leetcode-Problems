// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    // Possible moves for knight from each number (Corresponding index)
    String[] moves = {"80","124","1235","236","1457","24685","3569","478","75809","869"};
    
	public long getCount(int n)
	{
		// Your code goes here
		if (n==1)
            return 10;
        
        long ans = 0;
        
        // Count stores number of that num at each level
        long count[] = new long[10];
        Arrays.fill(count,1); // At level 1
        
        for (int move=2;move<=n;move++) {
            // At every level
            long temp[] = new long[10];
            for (int i=0;i<10;i++) {
                String curr = moves[i];
                for (int j=0,len=curr.length();j<len;j++) {
                    int x = curr.charAt(j)-'0';
                    temp[x] = (temp[x] + count[i]);
                }
            }
            count = Arrays.copyOf(temp,10);
        }
        
        for (long c: count) {
            ans+=c;
        }
        
        return ans;
		
	}
}

/*

Mobile keypad - 

1 2 3 
4 5 6
7 8 9
# 0 *

*/