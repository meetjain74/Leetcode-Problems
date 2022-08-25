class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        for (int num: nums1) {
            sum1 += num;
        }
        
        int sum2 = 0;
        for (int num: nums2) {
            sum2 += num;
        }
        
        if (sum1<sum2) {
            return minOperations(nums2,nums1,sum2,sum1);
        }
        
        return minOperations(nums1,nums2,sum1,sum2);
    }
    
    public int minOperations(int[] nums1,int[] nums2,int sum1,int sum2) {
        //nums1 sum is bigger than nums2
        int diff = sum1-sum2;
        
        // Decrease elements to 1 in nums1-> Sum1 decreases by (nums1[i]-1)
        // i.e diff decreases by (nums1[i]-1)
        // Increase elements to 6 in nums2-> Sum2 increases by (6-nums2[i])
        // i.e diff decreases by (6-nums2[i])
        
        // if convert all nums1 to 1 and convert all nums2 to 6
        int p = nums1.length*1;
        int q = nums2.length*6;
        if (p>q)
            return -1; //Not possible
        
        // Store count of these values- (nums1[i]-1) and (6-nums2[i])
        int[] count = new int[6];
        for (int num: nums1) {
            count[num-1]++;
        }
        
        for (int num: nums2) {
            count[6-num]++;
        }
        
        int res = 0;
        for (int i=5;i>0 && diff>0;i--) {
            int take = Math.min(count[i],diff/i+(diff%i==0?0:1));
            diff -= take*i;
            res += take;
        }
        
        return res;
    }
}