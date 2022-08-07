class Solution {
    int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        int a=1;
        int e=1;
        int i=1;
        int o=1;
        int u=1;
        
        for (int p=2;p<=n;p++) {
            int newa = ((e+i)%MOD+u)%MOD;
            int newe = (a+i)%MOD;
            int newi = (e+o)%MOD;
            int newo = i;
            int newu = (i+o)%MOD;
            
            a = newa;
            e = newe;
            i = newi;
            o = newo;
            u = newu;
        }
        
        return (((((a+e)%MOD+i)%MOD)+o)%MOD+u)%MOD;
    }
}