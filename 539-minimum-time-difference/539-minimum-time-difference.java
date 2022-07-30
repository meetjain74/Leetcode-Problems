class Time implements Comparable<Time> {
    int hour;
    int minutes;
    
    Time(int hour,int minutes) {
        this.hour=hour;
        this.minutes=minutes;
    }
    
    public int compareTo(Time t) {
        return this.hour==t.hour?this.minutes-t.minutes:this.hour-t.hour;
    }
    
    public String toString() {
        return hour+":"+minutes;
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Time> times = new ArrayList<>();
        for (String t: timePoints) {
            int hour = (t.charAt(0)-'0')*10+(t.charAt(1)-'0');
            int minutes = (t.charAt(3)-'0')*10+(t.charAt(4)-'0');
            times.add(new Time(hour,minutes));
        }
        
        Collections.sort(times);
        int min=Integer.MAX_VALUE; // Minimum minutes
        for (int i=0;i<times.size();i++) {
            Time t1 = times.get(i);
            Time t2 = times.get((i+1)%times.size());
            
            int current = diff(t1,t2);
            min = Math.min(min,current);
        }
        
        return min;
    }
    
    //t2-t1
    private int diff(Time t1,Time t2) {
        if (t1.compareTo(t2)>0) {
            return diff(t1,new Time(23,59))+diff(new Time(0,0),t2)+1;
        }
        
        if (t1.hour==t2.hour) {
            return t2.minutes-t1.minutes;
        }
        else {
            int minutes = (t2.hour-t1.hour-1)*60;
            minutes += (60-t1.minutes);
            minutes += t2.minutes;
            return minutes;
        }
    }
}