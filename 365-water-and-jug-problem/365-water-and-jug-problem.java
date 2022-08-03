class Solution {
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if (jug1+jug2==target)
            return true;
        if (jug1+jug2<target)
            return false;
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        HashSet<Integer> visited = new HashSet<>();
        int[] steps = {jug1,jug2,-jug1,-jug2};
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int step: steps) {
                int total = curr+step;
                if (total==target)
                    return true;
                if (total<0 || total>jug1+jug2 || visited.contains(total))
                    continue;
                
                visited.add(total);
                q.add(total);
            } 
        }
        
        return false;
    }
}