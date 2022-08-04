class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentFuel = 0; // fuel so far in car
        int ans = 0;
        int totalFuel = 0; // Total fuel required till now
        
        for (int i=0;i<gas.length;i++) {
            int fuel = gas[i]-cost[i]; // fuel provided by station i
            currentFuel += fuel;
            if (currentFuel<0) {
                // Start journey from next station
                currentFuel=0;
                ans=i+1;
            }
            
            totalFuel += fuel;
        }
        
        return totalFuel<0?-1:ans;
    }
}