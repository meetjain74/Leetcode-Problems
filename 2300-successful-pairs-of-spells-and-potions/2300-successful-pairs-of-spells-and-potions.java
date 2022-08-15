class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] number = new int[n];
        Arrays.sort(potions);
        
        for (int i=0;i<n;i++) {
            number[i] = getPotions(potions,spells[i],success);
        }
        
        return number;
    }
    
    private int getPotions(int[] potions,int strength,long success) {
        int low = 0;
        int high = potions.length-1;
        
        int index = potions.length;
        while (low<=high) {
            int mid = low+(high-low)/2;
            long temp = (long)potions[mid]*strength;
            if (temp>=success) {
                index=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        
        return potions.length-index;
    }
}