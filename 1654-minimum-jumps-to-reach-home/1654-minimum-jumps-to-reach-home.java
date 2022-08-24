class Loc {
    int pos;
    boolean back;
    
    Loc(int pos,boolean back) {
        this.pos=pos;
        this.back=back;
    }
}

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int f: forbidden) {
            set.add(f);
        }
        
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0,true));
        set.add(0);
        int minSteps=0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                Loc curr = q.poll();
                if (curr.pos==x) {
                    return minSteps;
                }

                // First backward then forward
                if (!set.contains(curr.pos-b) && curr.back && curr.pos-b>=0) {
                    q.add(new Loc(curr.pos-b,false));
                    set.add(curr.pos-b);
                }
                if (!set.contains(curr.pos+a) && curr.pos+a<=10000) {
                    q.add(new Loc(curr.pos+a,true));
                    set.add(curr.pos+a);
                }             
            }
            minSteps++;
        }
        
        return -1;
    }
}