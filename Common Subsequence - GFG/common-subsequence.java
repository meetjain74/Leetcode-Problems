// { Driver Code Starts

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next ();
            String b = sc.next ();
            
            if (new Sol().commonSubseq(a, b))
                System.out.println (1);
                
            else
                System.out.println (0);
    		   
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends



class Sol
{
    Boolean commonSubseq (String a, String b)
    {
        HashSet<Character> set = new HashSet<>();
        for (char ch: a.toCharArray()) {
            set.add(ch);
        }
        
        for (char ch: b.toCharArray()) {
            if (set.contains(ch))
                return true;
        }
        
        return false;
    }
}