class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        // Applying binary search on maximum working time
        
        // Lowest working time is maximum amount of time for each job
        int low = getMax(jobs); 
                                                       
        // Highest working time is sum of all time for all jobs
        int high = getSum(jobs);
        
        int ans = low;
        while (low<=high) {
            int mid = low + (high-low)/2;
            
            if (isPossible(jobs,new int[k],0,mid)) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
    
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i=1,size=nums.length;i<size;i++) {
            max = Math.max(max,nums[i]);
        }
        return max;
    }
    
    private int getSum(int[] nums) {
        int sum=0;
        for (int i=0,size=nums.length;i<size;i++) {
            sum += nums[i];
        }
        return sum;
    }
    
    // Returns true if it is possible to allot the given jobs to all the k workers
    // if the maximum working time of each worker is given
    // The alloted array represents the amount of time of job alloted to each worker
    // i.e alloted[i] represents amount of time of job alloted to ith worker
    private boolean isPossible(int[] jobs,int[] alloted,int index,int maxTime) {
        int availableWorkers = alloted.length;
        
        if (index==jobs.length)
            return true;
        
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<availableWorkers;i++) {
            // Do not permute the same alloted time on every worker
            // If checked once, leave the others
            if ( !set.contains(alloted[i]) ) {
                set.add(alloted[i]);
                
                if (alloted[i]+jobs[index] <= maxTime) {
                    alloted[i] += jobs[index];
                    if (isPossible(jobs,alloted,index+1,maxTime))
                        return true;
                    alloted[i] -= jobs[index];
                }
            }
        }
        
        return false;
    }
}