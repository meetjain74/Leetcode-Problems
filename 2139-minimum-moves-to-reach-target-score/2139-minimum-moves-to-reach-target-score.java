class Solution {
    public int minMoves(int target, int maxDoubles) {
        int op = 0;
        while (target!=1) {
            if (target%2==0 && maxDoubles!=0) {
                target = target/2;
                maxDoubles--;
            }
            else if (target%2!=0) {
                target -= 1;
            }
            else {
                op += (target-1);
                break;
            }
            op++;
        }
        
        return op;
    }
}