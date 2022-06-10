class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Each hour he can eat at most one complete pile or sit idle
        // The eating speed is k which can lie between 1 and maximum of piles[]

        int low = 1;
        int high = piles[0];
        for (int i=1;i<piles.length;i++) {
            high = Math.max(high,piles[i]);
        }
        
        int ans = low; // Handles the case when no answer between low and high
        while (low<=high) {
            int mid = low + (high-low)/2;
            long hours = getNumOfHours(piles,mid);
            
            if (hours<=h) {
                // At current speed, all bananas can be eaten 
                // in less than or equal to h hours
                
                ans = mid; // Can be a valid answer
                high = mid-1; // But try for more less than current
            }
            else if (hours>h) {
                // Need to increase eating speed
                low = mid+1;
            }
        }
        return ans;
    }
    
    // Returns the number of hours taken to eat all bananas from all piles
    // if the eating speed is k
    private long getNumOfHours(int[] piles, int k) {
        long hours = 0;
        for (int i=0;i<piles.length;i++) {
            // Hours required to completely eat ith pile
            int reqHours = piles[i]/k + (piles[i]%k==0 ? 0 : 1);
            hours = hours + reqHours;
        }
        return hours;
    }
}