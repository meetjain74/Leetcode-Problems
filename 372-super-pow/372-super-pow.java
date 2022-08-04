class Solution {
    int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        a%=MOD;
        int result = 1;
        
        for (int digit: b) {
            result = (pow(result,10)*pow(a,digit))%MOD;
        }
        
        return result;
    }
    
    private int pow(int x,int n) {
        int ans = 1;
        while (n!=0) {
            int last_bit = (n&1);
            if (last_bit==1)
                ans = (ans*x)%MOD;
            x = (x*x)%MOD;
            n = n>>>1;
        }
        
        return ans;
    }
}