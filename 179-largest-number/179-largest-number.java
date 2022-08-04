class Solution {
    public String largestNumber(int[] nums) {
        Integer[] l = new Integer[nums.length];
        for (int i=0;i<nums.length;i++) {
            l[i]=nums[i];
        }
        
        Arrays.sort(l,new Comparator<Integer>(){
            public int compare(Integer a,Integer b) {
                String s1 = a+""+b;
                String s2 = b+""+a;
                if (s1.compareTo(s2)>0)
                    return -1;
                else
                    return 1;
            }
        });
        
        
        // If, after being sorted, the largest number is `0`, 
        // the entire number is zero
        if (l[0]==0)
            return "0";
        
        StringBuilder res = new StringBuilder();
        for (Integer num: l) {
            res.append(num);
        }
        
        return res.toString();
    }
}