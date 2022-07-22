class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int forces[] = new int[n]; // Force on every domino
        
        int force = 0;
        // Iterating from left to right
        // Considering right pushes only
        for (int i=0;i<n;i++) {
            char ch = dominoes.charAt(i);
            if (ch=='R') {
                force = n; // Max force at this point
            }
            else if (ch=='L') {
                force = 0; // Left right balance each other
            }
            else { //ch='.'
                // Reducing force impact by distance
                // If previous force 0, no impace here
                force = Math.max(0,force-1);
            }
            forces[i]=force;
        }
        
        force=0;
        // Iterating from right to left
        // Considering left pushes only
        for (int i=n-1;i>=0;i--) {
            char ch = dominoes.charAt(i);
            if (ch=='L') {
                force = n; // Max force at this point
            }
            else if (ch=='R') {
                force = 0; // Left right balance each other
            }
            else { //ch='.'
                // Reducing force impact by distance
                // If previous force 0, no impace here
                force = Math.max(0,force-1); 
            }
            forces[i] -= force;
        }
        
        //Making answer
        StringBuilder ans = new StringBuilder(); // Final state
        
        for (int i=0;i<n;i++) {
            if (forces[i]<0)
                ans.append("L");
            else if (forces[i]>0)
                ans.append("R");
            else //forces[i]==0
                ans.append(".");
        }
        
        return ans.toString();
    }
}