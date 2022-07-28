class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i=0;
        
        // Insert intervals less than newInterval
        while (i<n && intervals[i][1]<newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals 
        while (i<n && intervals[i][0]<=newInterval[1]) {
            int newStart = Math.min(intervals[i][0],newInterval[0]);
            int newEnd = Math.max(intervals[i][1],newInterval[1]);
            newInterval[0] = newStart;
            newInterval[1] = newEnd;
            i++;
        }
        
        // Add new interval
        res.add(newInterval);
        
        // Add remaining intervals
        while (i<n) {
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int[res.size()][]);
    }
}