class Solution {
    
    class Element implements Comparable<Element> {
        char ch;
        int count;
        
        public Element(char ch,int count) {
            this.ch=ch;
            this.count=count;
        }
        
        // Descending on count
        public int compareTo(Element x) {
            return x.count-this.count;
        }
        
        public String toString() {
            return ch+":"+count;
        }
    }
    
    public String reorganizeString(String s) {
        // Get frequency of each characters
        int freq[] = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch-'a']++;
        }
        
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (char ch='a';ch<='z';ch++) {
            if (freq[ch-'a']!=0)
                pq.add(new Element(ch,freq[ch-'a']));
        }
        
        String ans = "";
        
        Element block = pq.poll(); // Current blocking element
        ans += block.ch;
        block.count--;
        
        while (pq.size()!=0) {
            Element x = pq.poll();
            ans += x.ch;
            x.count--;
            
            if (block.count>0) {
                pq.add(block);
            }
            block = x;
        }
        
        if (block.count>0) {
            return "";
        }
        
        return ans;
    }
}