class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int minIndex = 0;
        int maxIndex = 0;
        
        for (int i=1;i<n;i++) {
            if (nums[i]<min) {
                min = nums[i];
                minIndex = i;
            }
            
            if (nums[i]>max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        
        int start=-1;
        int end=n;
        int deletions;
        
        int deleteFromOppSides = Math.min(minIndex-start+end-maxIndex,
                                         end-minIndex+maxIndex-start);
        int deleteFromRight = end-Math.min(minIndex,maxIndex);
        int deleteFromLeft = Math.max(minIndex,maxIndex)-start;
        
        deletions = Math.min(deleteFromOppSides,
                            Math.min(deleteFromRight,deleteFromLeft));
        
        return deletions;
    }
}