class Solution {
    public int numRabbits(int[] answers) {
        // Map to store rabbits have same color as you and how much found till yet
        HashMap<Integer,Integer> map = new HashMap<>();
        int rabbits = 0;
        for (int i=0;i<answers.length;i++) {
            int x = answers[i];
            if (x==0) {
                rabbits++;
                continue;
            }
            
            // If rabbit have same color with x rabbits
            // Only x rabbits can have same color with x rabbits
            if (map.containsKey(x+1)) {
                if (map.get(x+1)<=x) {
                    // Not found x rabbits yet
                    // One rabbit found- increment
                    map.put(x+1,map.get(x+1)+1);
                    continue;
                }
                else {
                    // Already found x rabbits
                    // New color rabbit
                    rabbits += (x+1);
                    map.put(x+1,1);
                    continue;
                }
            }
            
            rabbits += (x+1);
            map.put(x+1,1);
        }
        
        return rabbits;
    }
}