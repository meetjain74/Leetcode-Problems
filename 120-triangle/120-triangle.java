class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        
        // Move from last second row to top
        for (int r=rows-2;r>=0;r--) {
            List<Integer> curr = triangle.get(r);
            List<Integer> next = triangle.get(r+1);
            
            int size = curr.size();
            for (int i=0;i<size;i++) {
                int pathSum = curr.get(i) + Math.min(next.get(i),next.get(i+1));
                curr.set(i,pathSum);
            }
        }
        
        return triangle.get(0).get(0);
    }
}