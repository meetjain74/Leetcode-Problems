class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        // Find count of oevrlapping intervals which can be removed
        
        // Sort in ascending order of start
        Arrays.sort(points,new Comparator<>() {
            public int compare(int[] a,int[] b) {
                return a[0]>b[0] ? 1 : -1;
            }
        });
        
        int[] prev = points[0]; // Previous balloon
        int count = 0; // Balloons to remove
        for (int i=1;i<points.length;i++) {
            int[] curr = points[i];
            if (curr[0]>prev[1]) { //Non overlapping
                prev=curr;
            }
            else if (curr[1]>prev[1]) { // Overlapping
                // Current also lie outside of prev
                // Remove current balloon
                count++;
            }
            else { // Overlapping
                // Current lies inside prev
                // Remove prev balloon
                prev = curr;
                count++;
            }
        }
        
        int arrows = n-count; // Arrows required to burst balloons
        return arrows;
    }
}