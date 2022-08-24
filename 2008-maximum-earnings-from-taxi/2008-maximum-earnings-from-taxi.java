class Ride implements Comparator<Ride> {
    int start;
    int end;
    int tip;
    
    Ride() {}
    
    Ride(int start,int end,int tip) {
        this.start=start;
        this.end=end;
        this.tip=tip;
        this.tip = this.end-this.start+this.tip;
    }
    
    //Sort on start time
    public int compare(Ride a,Ride b) {
        if (a.start==b.start) {
            if (a.end==b.end)
                return b.tip-a.tip;
            return a.end-b.end;
        }
        return a.start-b.start;
    }
    
    public String toString() {
        return "["+start+" "+end+" "+tip+"]";
    }
}

class Solution {
    public long maxTaxiEarnings(int n, int[][] r) {
        ArrayList<Ride> rides = new ArrayList<>();
        for (int i=0;i<r.length;i++) {
            Ride a = new Ride(r[i][0],r[i][1],r[i][2]);
            rides.add(a);
        }
        Collections.sort(rides,new Ride());
        
        long dp[] = new long[rides.size()];
        Arrays.fill(dp,-1);
        return solve(rides,0,dp);   
    }
    
    private long solve(ArrayList<Ride> rides,int index,long[] dp) {
        if (index==rides.size())
            return 0;
        
        if (dp[index]!=-1)
            return dp[index];
        
        // Pick current job
        Ride curr = rides.get(index);
        long pick = curr.tip;
        long max = 0;
        int i = getNextRide(rides,curr.end,index+1,rides.size()-1);
        for (;i<rides.size();i++) {
            if (dp[i]!=-1) {
                max = Math.max(max,dp[i]);
                break;
            }
            long temp = solve(rides,i,dp);
            max = Math.max(max,temp);
        }
        pick += max;
        
        // Not pick current job
        long notpick = solve(rides,index+1,dp);
        
        return dp[index]=Math.max(pick,notpick);
    }
    
    public int getNextRide(ArrayList<Ride> rides,int endTime,int start,int end) {
        int low = start;
        int high = end;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (rides.get(mid).start==endTime && 
                (mid!=start && rides.get(mid-1).start!=endTime)) {
                return mid;
            }
            else if (rides.get(mid).start<endTime) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
}