class Solution {
    public int countPrimes(int n) {
        // Using sieve of erastosthones
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        
        for (int i=2;i<n;i++) {
            if (prime[i]) {
                int curr = i+i;
                while (curr<n) {
                    prime[curr]=false;
                    curr=curr+i;
                }
            }
        }
        
        int count = 0; // Count primes strictly less than n
        for (int i=2;i<n;i++) {
            if (prime[i])
                count++;
        }
        
        return count;
    }
}