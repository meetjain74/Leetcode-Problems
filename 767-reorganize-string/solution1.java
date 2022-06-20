class Solution {
    
    class Element implements Comparable<Element> {
        char ch;
        int count;
        
        public Element(char ch,int count) {
            this.ch=ch;
            this.count=count;
        }
        
        // Descending on count and ascending on ch
        public int compareTo(Element x) {
            if (x.count==this.count)
                return this.ch-x.ch;
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
        while(pq.size()!=0) {
            Element x = pq.poll();
            if (x.count==1) {
                ans=ans+x.ch;
            }
            else {
                if (pq.size()==0) {
                    // Not possible to reorganize string
                    return "";
                }
                Element y = pq.poll();
                ans=ans+x.ch+y.ch;
                y.count-=1;
                x.count-=1;
                
                if (y.count>0) {
                    pq.add(y);
                }
                
                if (x.count>0) {
                    pq.add(x);
                }
            }
        }
        
        return ans;
    }
}
