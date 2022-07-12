// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Pair implements Comparable<Pair>{
    int index;
    double ratio; // value/weight
    
    Pair(int index,double ratio) {
        this.index=index;
        this.ratio=ratio;
    }
    
    // Descending order of ratio
    public int compareTo(Pair p) {
        if (p.ratio==this.ratio)
            return 0;
        else if (p.ratio>this.ratio)
            return 1;
        else
            return -1;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i=0;i<arr.length;i++) {
            double ratio = (arr[i].value*1.0) / (arr[i].weight);
            pq.add(new Pair(i,ratio));
        }
        
        double ans = 0;
        while (W!=0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            int currWt = arr[curr.index].weight;
            if (currWt<W) {
                ans = ans + arr[curr.index].value;
                W = W - arr[curr.index].weight;
            }
            else {
                ans = ans + curr.ratio*W;
                W = 0;
            }
        }
        
        return ans;
    }
}