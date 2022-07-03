class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(1);

        for(int i=1;i<n;i++) {
            int temp = q.poll();
            while(!q.isEmpty() && q.peek()==temp) // Pop duplicate
                temp = q.poll();

            if (temp<Integer.MAX_VALUE/2) q.add(temp*2);
            if (temp<Integer.MAX_VALUE/3) q.add(temp*3);
            if (temp<Integer.MAX_VALUE/5) q.add(temp*5);
        }
        return q.poll();
    }
}