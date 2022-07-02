class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n+1]; // No of people who trust you
        int outdegree[] = new int[n+1]; // No of people you trust
        
        for (int[] t: trust) {
            indegree[t[1]]++;
            outdegree[t[0]]++;
        }
        
        for (int i=1;i<=n;i++) {
            if (indegree[i]==n-1 && outdegree[i]==0)
                return i;
        }
        
        return -1;
    }
}