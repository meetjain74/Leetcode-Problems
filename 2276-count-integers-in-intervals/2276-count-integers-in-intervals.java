class CountIntervals {
    int count = 0;
    
    //map to store [start,finish] interval
    TreeMap<Integer,Integer> map = new TreeMap<>();

    public CountIntervals() {
        
    }
    
    public void add(int left, int right) {
        int l = left;
        int r = right;
        
        while ( !(map.floorKey(r)==null || map.get(map.floorKey(r))<l) ) {
            int smallerLeft = map.floorKey(r);
            int smallerRight = map.get(smallerLeft);
            
            // Remove this smaller interval
            count -= (smallerRight-smallerLeft+1);
            map.remove(smallerLeft);
            
            // merge
            l = Math.min(l,smallerLeft);
            r = Math.max(r,smallerRight);
        }
        
        map.put(l,r);
        count += r-l+1;
    }
    
    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */