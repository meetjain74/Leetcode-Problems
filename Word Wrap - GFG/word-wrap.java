class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int dp[][] = new int[nums.length][k+1];
        for (int i=0;i<nums.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,k,0,k,dp);
    }
    
    
    private int helper(int[] nums,int k,int index,int rem,int dp[][]) {
        if (index==nums.length)
            return 0;
            
        if (nums[index]>k || (nums[index]==k && rem==k)) // Ignore this word
            return helper(nums,k,index+1,rem,dp);
            
        if (nums[index]==k) // Take new line
            return (rem+1)*(rem+1) + helper(nums,k,index+1,k,dp);
            
        if (dp[index][rem]!=-1)
            return dp[index][rem];
            
        int cost = 0;
        int h1=0,h2=0;
        if (nums[index]>rem) {
            // Word requires more characters than remaining in line
            // Add word in new line 
            
            // Remaining in next line- (k-nums[index]-1) where 1 for space after word
            h1 = helper(nums,k,index+1,k-nums[index]-1,dp);
            cost = (rem+1)*(rem+1) + h1;
        }
        else if (nums[index]==rem) {
            // Word can be added in current line - Explore both cases
            
            // Add word in next line
            h1 = helper(nums,k,index+1,k-nums[index]-1,dp);
            h1 = (rem+1)*(rem+1) + h1;
            
            // Add word in current line
            h2 = helper(nums,k,index+1,k,dp);
            
            cost = Math.min(h1,h2); // Minimum cost
        }
        else {
            // Word can be added in current line - Explore both cases
            
            // Add word in next line
            h1 = helper(nums,k,index+1,k-nums[index]-1,dp);
            h1 = (rem+1)*(rem+1) + h1;
            
            // Add word in current line
            h2 = helper(nums,k,index+1,rem-nums[index]-1,dp);
            
            cost = Math.min(h1,h2); // Minimum cost
        }
        
        return dp[index][rem]=cost;
    }
}
