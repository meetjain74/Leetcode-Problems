// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            ArrayList <Integer> res = new Solution().nearlySorted(arr, num, k);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> nums = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i: arr) {
            nums.add(i);
            
            if (nums.size()>k) {
                // Ans for each index lies in range [index-k,index+k]
                ans.add(nums.poll());
            }
        }
        
        while (nums.size()!=0) {
            ans.add(nums.poll());
        }
        
        return ans;
    }
}
