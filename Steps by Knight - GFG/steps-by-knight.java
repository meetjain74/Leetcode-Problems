// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        int[][] dirs = {{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        
        int minSteps = 0;
        
        queue.add(KnightPos);
        visited[KnightPos[0]][KnightPos[1]]=true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i=0;i<size;i++) {
                int[] curr=queue.poll();
                
                // check if it is target point ry
                if (curr[0]==TargetPos[0] && curr[1]==TargetPos[1])
                    return minSteps;
                    
                for (int[] dir: dirs) {
                    int x = dir[0]+curr[0];                    
                    int y = dir[1]+curr[1];
                    
                    if (x<1 || x>N ||y<1 || y>N || visited[x][y]) 
                        continue;
					
                    queue.add(new int[]{x,y});
                    visited[x][y]=true;
                }
            }
            minSteps++;
        }
        
        return -1;
    }
}