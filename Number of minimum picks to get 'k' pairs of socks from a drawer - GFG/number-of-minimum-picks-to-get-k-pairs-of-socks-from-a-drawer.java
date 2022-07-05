// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n, k, ans;
            n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            k = sc.nextInt();
            Solution obj = new Solution();
            ans = obj.find_min(a, n, k);
            System.out.println(ans);
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int find_min(int[] a, int n, int k) {
        int totalPairs = 0;
	    
	    // To make 1 pair of socks
	    // Take one from each N different color socks 
	    // Now the next (n+1)th sock will guarantee a pair 
	    
	    // To make k pair of socks
	    
	    // Divide socks into two groups 
	    // Group 1 should contain at least one sock of each color 
	    // Hence group 1 contains 1 sock for odd no of socks available 
	    // and 2 socks for even no of socks available 
	    // Group 2 contains the remaining socks which doesn't belong to group 1
	    // Group 2 contains even no of socks of each color (including 0)
	    // Suppose no of pairs group 2 can form is g2Pairs
	    
	    // There are two cases now
	    // g2Pairs>=k & g2Pairs<k
	    
	    // If g2Pairs>=k i.e no of pairs group 2 can create is more than or eqaul to k
	    // Choose 2*(k-1) socks from group 2 
	    // Now choose N socks from group 1 (Each color sock once)
	    // Now these 2*(k-1)+N socks guarantee that there are (k-1) pairs of socks 
	    // This is because when we choose 2*(k-1) socks from group 2 if even no of
	    // socks of particular color is chosen, it makes a pair and if odd no of socks
	    // of a color is chosen the N socks of all color from group 2 will make pair complete
	    // Hence in the worst case we will have k-1 pairs available with us
	    // Now Choose 1 more to complete the Kth pair 
	    
	    // If g2Pairs<k
	    // The group 2 does not have enough socks to form k pairs
	    // Take all socks from g2Pairs 
	    // Now these 2*(g2Pairs) socks guarantee that there are g2Pairs pairs of socks
	    // Now choose N socks from group 1 (Each color sock once)
	    // Now Choose (k-g2Pairs) more to complete all the K pairs
	    
	    int g2Pairs = 0;
	    
	    for (int s:a) {
	        totalPairs += s/2;
	        
	        if (s%2==0) //even
	            g2Pairs += (s-2)/2;
	        else //odd
	            g2Pairs += (s-1)/2;
	        
	    }
	    
	    if (totalPairs<k) {
	        return -1; // Not possible to pick k pairs of socks
	    }
	    
	    if (g2Pairs>=k) {
	        return 2*(k-1)+n+1;
	    }
	    else {
	        return 2*g2Pairs+n+(k-g2Pairs);
	    }
    }
}