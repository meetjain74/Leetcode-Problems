class Solution {
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if (jug1+jug2<target)
            return false;
        
        // If target is multiple of gcd of both capacities
        // Then possible
        return target % gcd(jug1,jug2) == 0;
    }
    
    private int gcd(int a,int b) {
        if (b==0)
            return a;
        return gcd(b,a%b);
    }
}