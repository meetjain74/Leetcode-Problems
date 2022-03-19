class Solution {
    public int[] singleNumber(int[] nums) {
        int num1=0,num2=0;
        int xor=0; // represents xor of all numbers
        for (int i=0;i<nums.length;i++) {
            xor = xor^nums[i];
        }
        
        // Get the position of first set bit from right
        int pos = 0;
        int temp = xor;
        while ((temp&1)!=1) {
            temp = temp>>1;
            pos++;
        }
        
        // Mask with pos bit set to 1
        int mask = 1<<pos;
        
        for (int i=0;i<nums.length;i++) {
            if ((nums[i]&mask)>0) 
                num1 = num1^nums[i];
        }
        
        num2 = num1^xor;
        
        return new int[]{num1,num2};
    }
}