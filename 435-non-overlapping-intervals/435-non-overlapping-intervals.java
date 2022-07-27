class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // Sort in ascending order of start
        Arrays.sort(intervals,new Comparator<>() {
            public int compare(int[] a,int[] b) {
                return a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1];
            }
        });
        
        int[] prev = intervals[0]; // Previous interval
        int count = 0; // Intervals to remove
        for (int i=1;i<intervals.length;i++) {
            int[] curr = intervals[i];
            if (curr[0]>=prev[1]) { //Non overlapping
                prev=curr;
            }
            else if (curr[1]>prev[1]) { // Overlapping
                // Current also lie outside of prev
                // Remove current interval
                count++;
            }
            else { // Overlapping
                // Current lies inside prev
                // Remove prev interval
                prev = curr;
                count++;
            }
        }
        
        return count;
    }
}