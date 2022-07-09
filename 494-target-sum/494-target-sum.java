class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Divide array into two subsets S1 and S2
        // Assign +ve to S1 and -ve to S2 
        // This is similar to (S1-S2==target)
        // S1+S2=arraySum
        // S1 = (arraySum+target)/2
        
        int sum = sumOfArray(nums);
        int s1 = (sum+target)/2;
        
        if ((sum+target)%2==1 || target>sum || s1<0)
            return 0; // Not possible
        
        // Count no of zeroes in array
        // As zeroes can go to both parts S1 and S2
        int count=0;
        for (int num: nums) {
            if (num==0)
                count++;
        }
        
        // Count no of subsets with sum s1
        return (int)Math.pow(2,count)*countSubsetSum(nums,s1);
    }
    
    private int sumOfArray(int arr[]) {
	    int sum = 0;
	    for (int a:arr) {
	        sum += a;
	    }
	    return sum;
	}
    
    private int countSubsetSum(int nums[],int sum) {
        int n=nums.length;
        
        // Size*Sum
        // dp[i][j] represents count of subsets with sum j
        // considering the first i elements of array
        int dp[][] = new int[n+1][sum+1];
        
        // dp[i][0] is 1 because take no elements 
        for (int i=0;i<=n;i++) {
            dp[i][0]=1;
        }
        
        // dp[0][j] is 0 because cannot create sum j with no elements
        
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=sum;j++) {
                
                int curr = nums[i-1];
                if (curr>j || curr==0) {
                    // Ignore this element and zeroes
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // Either ignore this element or take this element
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-curr];
                }
            }
        }
        
        return dp[n][sum];
    }
}