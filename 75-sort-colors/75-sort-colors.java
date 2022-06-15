class Solution {
    public void sortColors(int[] nums) {
        sort2(nums);
    }
    
    public void sort1(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==0)
                count0++;
            else if (nums[i]==1)
                count1++;
            else
                count2++;
        }
        
        int i=0;
        while (count0!=0) {
            nums[i++]=0;
            count0--;
        }
        while (count1!=0) {
            nums[i++]=1;
            count1--;
        }
        while (count2!=0) {
            nums[i++]=2;
            count2--;
        }
    }
    
    // Using two pointer approach
    public void sort2(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        for (int i=0;i<n;i++) {
            if (nums[i]==0) {
                swapAtIndex(nums,i,low++);
            }
            else if (nums[i]==2 && i<high) {
                swapAtIndex(nums,i,high--);
                i--;
            }
        }
    }
    
    private void swapAtIndex(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}