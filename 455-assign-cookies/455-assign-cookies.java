class Solution {
    public int findContentChildren(int[] g, int[] s) {
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
}