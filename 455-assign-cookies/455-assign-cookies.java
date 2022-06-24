class Solution {
    public int findContentChildren(int[] g, int[] s) {
        return method2(g,s);
    }
    
    private int method1(int[] g,int[] s) {
        PriorityQueue<Integer> cookies = new PriorityQueue<>();
        PriorityQueue<Integer> greeds = new PriorityQueue<>();
        
        for (int x: g) {
            greeds.add(x);
        }
        
        for (int x: s) {
            cookies.add(x);
        }
        
        int children = 0;
        while (!cookies.isEmpty() && !greeds.isEmpty()) {
            int cookie = cookies.poll();
            int greed = greeds.poll();
            
            if (cookie>=greed) {
                children++;
            }
            else {
                greeds.add(greed);
            }
        }
        
        return children;
    }
    
    private int method2(int[] g,int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childrenIndex=0;
        for (int i=0;i<s.length && childrenIndex<g.length;i++) {
            if (g[childrenIndex]<=s[i]) {
                childrenIndex++;
            }
        }
        return childrenIndex;
    }
}