class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean timeSeen[] = new boolean[24*60]; //1440
        for (String t: timePoints) {
            int hour = (t.charAt(0)-'0')*10+(t.charAt(1)-'0');
            int minutes = (t.charAt(3)-'0')*10+(t.charAt(4)-'0');
            minutes = hour*60+minutes;
            if (timeSeen[minutes]) //Time already seen
                return 0;
            timeSeen[minutes]=true;
        }
        
        Integer firstSeenTime = null;
        Integer prevSeenTime = null;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0;i<1440;i++) {
            if (timeSeen[i]) {
                if (firstSeenTime==null) {
                    firstSeenTime=i;
                    prevSeenTime=i;
                }
                else {
                    int currDiff=Math.min(i-prevSeenTime,1440-i+prevSeenTime);
                    minDiff = Math.min(minDiff,currDiff);
                    prevSeenTime=i;
                }
            }
        } 
        
        // Also check difference with firstSeenTime
        minDiff = Math.min(minDiff,1440-prevSeenTime+firstSeenTime);
        
        return minDiff;
    }
}