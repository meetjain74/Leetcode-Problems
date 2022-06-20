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
            return this.count-x.count;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Element> elems = new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            elems.add( new Element(e.getKey(),e.getValue()) );
            
            if (elems.size()>k) {
                elems.poll();
            }
        }
        
        int res[] = new int[k];
        for (int i=0;i<k;i++) {
            res[i]=elems.poll().value;
        }
        
        return res;
    }
}