class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        
        // Stores prefixSum mod k and last index 
        HashMap<Integer,Integer> prefixSums = new HashMap<>();
        int sum = 0;
        prefixSums.put(0,-1);
        
        for (int i=0;i<n;i++) {
            sum = sum+nums[i];
            int rem = sum%k;
            
            if (prefixSums.containsKey(rem)) {
                int lastIndex = prefixSums.get(rem);
                if (i-lastIndex>1)
                    return true;
            }
            else {
                prefixSums.put(rem,i);
            }
        }
        
        return false;
    }
    
    // Time limit exceeded on this code
    private boolean method1(int[] nums,int k) {
        int n=nums.length;
        int[] prefixSum = new int[n];
        int sum=0;
        for (int i=0;i<n;i++) {
            sum+=nums[i];
            prefixSum[i]=sum;
        }
        
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                // Subarray i to j
                int subArraySum = prefixSum[j]-( i==0 ? 0 : prefixSum[i-1] );
                if (subArraySum%k==0)
                    return true;
            }
        }
        
        return false;
    }
}