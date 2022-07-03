// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            long ans = new Solution().findgroups(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long findgroups(int[] arr, int n) {
        
        long rem0 = 0;
        long rem1 = 0;
        long rem2 = 0; 
        
        for (int num: arr) {
            if (num%3==0)
                rem0++;
            else if (num%3==1)
                rem1++;
            else
                rem2++;
        }
        
        //  For groups of 2
        long groupsOfTwo=0;
        // Pick both elements from rem0 group (nC2) 
        groupsOfTwo += rem0*(rem0-1)/2; 
        // Pick one element from rem1 and other from rem2 group (nC1*nC1)
        groupsOfTwo += rem1*rem2;
        
        
        
        //  For groups of 3
        long groupsOfThree=0;
        // Three elements from rem0 group (nC3)
        groupsOfThree += rem0*(rem0-1)*(rem0-2)/6;
        // Three elements from rem1 group (nC3)
        groupsOfThree += rem1*(rem1-1)*(rem1-2)/6;
        // Three elements from rem2 group (nC3)
        groupsOfThree += rem2*(rem2-1)*(rem2-2)/6;
        // One element from each of the three groups ((nC1)*(nC1)*(nC1))
        groupsOfThree += rem2*rem1*rem0;
        
        
        // Total groups of 2 and 3
        return groupsOfTwo + groupsOfThree;
    }
}
