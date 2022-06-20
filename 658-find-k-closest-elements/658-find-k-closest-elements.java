class Solution {
    
    class Element implements Comparable<Element> {
        int key; // |a-x|
        int val; // a
        
        public Element(int key,int val) {
            this.key=key;
            this.val=val;
        }
        
        // Descending of key and value
        public int compareTo(Element b) {
            int diff = b.key-this.key;
            return diff==0 ? b.val-this.val : diff;
        }
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Element> closest = new PriorityQueue<>();
        for (int num: arr) {
            int key = Math.abs(num-x);
            closest.add(new Element(key,num));
            
            if (closest.size()>k) {
                closest.poll();
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (closest.size()!=0) {
            ans.add(closest.poll().val);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}