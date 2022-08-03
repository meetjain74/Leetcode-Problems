class MyCalendar {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    
    public MyCalendar() {
        
    }
     
    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        Integer ceil = map.ceilingKey(start);
        if (floor!=null) {
            if (map.get(floor)>end || map.get(floor)>start)
                return false;
        }
        if (ceil!=null) {
            if (end>ceil)
                return false;
        }
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */