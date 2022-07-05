class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] output = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for (int num:nums) {
            if (num<0) {
                output[neg]=num;
                neg+=2;
            }
            else {
                output[pos]=num;
                pos+=2;
            }
        }
        return output;
    }
}