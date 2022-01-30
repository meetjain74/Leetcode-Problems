class Solution {
    public void nextPermutation(int[] nums) {
        int temp;
        int index=nums.length-1;
        while (index>0 && nums[index]<=nums[index-1])
            index--;
        index=index-1; //Index is -1 in case of descending order array
        
        if (index>=0) {
            int j=nums.length-1;
            while (nums[index]>=nums[j])
                j--;
            swap(nums,index,j);
        }
        
        // Reverse array after index i.e index+1
        int start=index+1;
        int end=nums.length-1;
        while (start<end)
            swap(nums,start++,end--);
    }
    
    public void swap(int nums[],int x,int y) {
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}