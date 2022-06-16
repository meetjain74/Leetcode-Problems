class Solution {
    public int firstMissingPositive(int[] nums) {
        return method3(nums);
    }
    
    private int method1(int[] nums) {
        TreeSet<Integer> vals = new TreeSet<>();
        for (int i: nums) {
            if (i>0)
                vals.add(i);
        }
        
        for (int i=1;i<=nums.length;i++) {
            if (!vals.contains(i))
                return i;
        }
        
        return nums.length+1;
    }
    
    private int method2(int[] nums) {
        boolean[] visited = new boolean[nums.length+1];
        for(int i: nums) {
           if(i>0 && i<=nums.length) {
               visited[i] = true;
           }
        }

        for(int i=1;i<=nums.length;i++) {
            if(!visited[i]) 
                return i;
        }
        
        return nums.length+1;
    }
    
    // Using swap sort
    private int method3(int[] nums) {
        int i=0;
        while (i<nums.length) {
            if (nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]) {
                swapAtIndex(nums,i,nums[i]-1);
            }
            else {
                i++;
            }
        }
        
        for (int j=0;j<nums.length;j++) {
            if (nums[j]!=j+1)
                return j+1;
        }
    
        return nums.length+1;
    }
    
    private void swapAtIndex(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}