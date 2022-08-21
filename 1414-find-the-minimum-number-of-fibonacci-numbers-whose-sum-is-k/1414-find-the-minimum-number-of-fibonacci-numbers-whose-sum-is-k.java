class Solution {
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int a = 1;
        int b = 1;
        set.add(1);
        int c = a+b;
        while (c<=k) {
            set.add(c);
            a=b;
            b=c;
            c=a+b;
        }
        
        int count = 0;
        while (k!=0) {
            k -= set.floor(k);
            count++;
        }
        
        return count;
    }
}