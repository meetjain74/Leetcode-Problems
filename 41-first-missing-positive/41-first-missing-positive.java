class Solution {
    public int firstMissingPositive(int[] nums) {
        return method2(nums);
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
}