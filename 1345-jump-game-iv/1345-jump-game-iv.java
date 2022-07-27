class Solution {
    public int minJumps(int[] arr) {
        boolean visited[] = new boolean[arr.length];
        
        // Map to store list of indezxes with same value
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            int num = arr[i];
            if (!graph.containsKey(num)) {
                graph.put(num,new ArrayList<>());
            }
            List<Integer> curr = graph.get(num);
            curr.add(i);
        }
        
        // BFS
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[0]=true;
        q.add(0);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                int curr = q.poll();
                if (curr==arr.length-1)
                    return steps;
                
                for (int index: graph.get(arr[curr])) {
                    if (index!=curr && !visited[index]) {
                        visited[index]=true;
                        q.add(index);
                    }
                }
                graph.get(arr[curr]).clear();
                
                if (curr-1>=0 && !visited[curr-1]) {
                    visited[curr-1]=true;
                    q.add(curr-1);
                }
                
                if (curr+1<arr.length && !visited[curr+1]) {
                    visited[curr+1]=true;
                    q.add(curr+1);
                }       
            }
            steps++;
        }
        
        return -1;
    }
}