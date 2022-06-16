class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes=0;
        int count=0;
        for (int i: nums) {
            count+=i;
            if (i==0) {
                maxOnes=Math.max(maxOnes,count);
                count=0;
            }
        }
        maxOnes=Math.max(maxOnes,count);
        return maxOnes;
    }
}