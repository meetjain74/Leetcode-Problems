class Job implements Comparator<Job> {
    int start;
    int end;
    int profit;
    
    Job() {}
    
    Job(int start,int end,int profit) {
        this.start=start;
        this.end=end;
        this.profit=profit;
    }
    
    //Sort on start time
    public int compare(Job a,Job b) {
        if (a.start==b.start) {
            if (a.end==b.end)
                return b.profit-a.profit;
            return a.end-b.end;
        }
        return a.start-b.start;
    }
    
    public String toString() {
        return "["+start+" "+end+" "+profit+"]";
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i=0;i<startTime.length;i++) {
            Job j = new Job(startTime[i],endTime[i],profit[i]);
            jobs.add(j);
        }
        Collections.sort(jobs,new Job());
        
        int dp[] = new int[jobs.size()];
        Arrays.fill(dp,-1);
        return solve(jobs,0,dp);    
    }
    
    private int solve(ArrayList<Job> jobs,int index,int[] dp) {
        if (index==jobs.size())
            return 0;
        
        if (dp[index]!=-1)
            return dp[index];
        
        // Pick current job
        Job curr = jobs.get(index);
        int pick = curr.profit;
        int max = 0;
        int i = getNextJob(jobs,curr.end,index+1,jobs.size()-1);
        for (;i<jobs.size();i++) {
            if (dp[i]!=-1) {
                max = Math.max(max,dp[i]);
                break;
            }
            int temp = solve(jobs,i,dp);
            max = Math.max(max,temp);
        }
        pick += max;
        
        // Not pick current job
        int notpick = solve(jobs,index+1,dp);
        
        return dp[index]=Math.max(pick,notpick);
    }
    
    public int getNextJob(ArrayList<Job> jobs,int endTime,int start,int end) {
        int low = start;
        int high = end;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (jobs.get(mid).start==endTime && 
                (mid!=start && jobs.get(mid-1).start!=endTime)) {
                return mid;
            }
            else if (jobs.get(mid).start<endTime) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
}