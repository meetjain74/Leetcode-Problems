class Solution {
    public int singleNumber(int[] nums) {
        // 32 bit array to store the result in binary
        int ansBinary[] = new int[32];
        
        for (int i=0;i<nums.length;i++) {
            int num = nums[i];
            
            int j=0;
            // Count all bits at all positions and update the count array i.e ansBinary
            while (num!=0) {
                int leftBit = (num&1);
                ansBinary[j] += leftBit;
                j++;
                num = num>>>1;
            }
        }
          
        // Every element in the array is either 3N or 3N+1
        int ans = 0;
        int pow = 1;
        for (int i=0;i<32;i++) {
            ansBinary[i] %= 3;
            ans += ansBinary[i]*pow;
            pow = pow<<1;
        }

        return ans;
    }
}