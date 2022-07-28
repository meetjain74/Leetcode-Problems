class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i=0; // Points first list
        int j=0; // Points second list
        
        while (i<firstList.length && j<secondList.length) {
            // Check if current intervals of both list intersect
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);
            if (start<=end) {
                res.add(new int[]{start,end});
            }
            
            if (firstList[i][1]<secondList[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return res.toArray(new int[0][]);
    }
}