class Solution {
    public int findMaximumXOR(int[] nums) {
        // The maximum valus is 2^31 - 1 i.e 31 1's
        // The maximum XOR possible is 2^31 - 1 from two numbers - 0 and 2^31-1
        
        // We need to find these 31 bits from given array giving maximum XOR
        
        // Store the result in variable max
        int max = 0;
        int mask = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=30;i>=0;i--) {
            
            // Setting 1's from 31 digit to 0
            // 100....0(31'st bit 1) then 110...0 then 111.....0 and so on till 111....1
            mask |= 1<<i;
            
            // Consider all different combinations of first i bits possible which are present
            for (int j=0;j<nums.length;j++) {
                set.add(mask & nums[j]);
            }
            
            // Temporary max variable in which setting i'th bit as 1 and rest as old maximum
            int tempMax = max | (1<<i);
            
            // Iterating over set
            for (Integer t: set) {
                
                // If t^tempMax contains in set that is we have two numbers whose XOR is tempMax
                // This is beacuse if
                // a XOR c = b then we can say that a XOR b = c as well as b XOR c = a
                if (set.contains(t^tempMax)) {
                    max = tempMax;
                    break;
                }                
            }
            
            // Clearing the set for next iteration
            set.clear();
        }
        
        return max;
    }
}