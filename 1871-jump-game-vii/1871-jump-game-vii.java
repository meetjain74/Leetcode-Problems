class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int farthest=0; // Farthest index we reached till now
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr==n-1)
                return true;

            int start = Math.max(curr+minJump,farthest);
            int end = Math.min(curr+maxJump,n-1);
            for (int i=start;i<=end;i++) {
                if (s.charAt(i)=='0')
                    q.add(i);
            }
            farthest=end+1;
        }
        
        return false;
    }
}