class Solution {
    public int mirrorReflection(int p, int q) {
        int m = 1; // Total no of rooms
        int n = 1; // Total no of reflections
        
        // Meets a receptor when m*p == n*q
        while (m*p!=n*q) {
            n++; //Increase no of reflection
            // Update room if reflection reaches out of room
            m = n*q/p;
        }
        
        // Now m*p==n*q
        // Three cases for each of the receptors
        
        // If total no of reflections are even it reaches left side and receptor 2
        if (n%2==0)
            return 2;
        
        // Now total no of reflections are odd it reaches right
        // Two cases- receptor 0 or receptor 1
        
        // If total no of rooms is even then receptor 0 else receptor 1
        if (m%2==0)
            return 0;
        else
            return 1;
    }
}

