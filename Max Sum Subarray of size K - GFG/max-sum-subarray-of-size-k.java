// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int low = 0;
        int high = K-1;
        
        long maxSum=0;
        for (int i=low;i<=high;i++) {
            maxSum += Arr.get(i);
        }
        
        long prevSum = maxSum;
        for (int i=low+1;i<=N-K;i++) {
            prevSum = prevSum - Arr.get(i-1) + Arr.get(i+K-1);
            maxSum = Math.max(maxSum,prevSum);
        }
        
        return maxSum;
    }
}