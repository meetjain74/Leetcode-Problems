class Solution {
    
    class Element implements Comparable<Element> {
        int value;
        int count;
        
        public Element(int value,int count) {
            this.value=value;
            this.count=count;
        }
        
        // Ascending order of count
        public int compareTo(Element x) {
            int countDiff = this.count-x.count;
            int valDiff = x.value-this.value;
            return countDiff==0 ? valDiff : countDiff;
        }
        
        public String toString() {
            return value+" "+count;
        }
    }
    
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Element> elems = new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            elems.add( new Element(e.getKey(),e.getValue()) );
        }
        
        int[] res = new int[nums.length];
        int i=0;
        while (elems.size()!=0) {
            Element x = elems.poll();
            for (int j=1;j<=x.count;j++) {
                res[i++]=x.value;
            }
        }
        
        return res;
    }
}