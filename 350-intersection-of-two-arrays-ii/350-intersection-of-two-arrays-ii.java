class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>array1 = new HashMap<>();
        ArrayList<Integer>result = new ArrayList<Integer>();
        
        for(int n:nums1){
            if(array1.containsKey(n))
                array1.put(n,array1.get(n)+1);
            else
               array1.put(n,1);
            
        }
        
        for(int n:nums2){
            if(array1.containsKey(n)){
                result.add(n);
                if(array1.get(n)>1)
                    array1.put(n,array1.get(n)-1);
                else
                    array1.remove(n);
            } 
        }
        
        int finalArray[] = new int[result.size()];
        int idx = 0;
        for(int i:result){
            finalArray[idx++] = i;
        }
        
        return finalArray;
    }
}