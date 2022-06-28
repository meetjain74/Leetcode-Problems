class Solution {
    public int minSwaps(String s) {
        int swaps = 0;
        int close = 0; // close brackets
        for (char ch: s.toCharArray()) {
            if (ch==']')
                close++;
            else if (ch=='[')
                close--;
            
            // Swaps stores the maximum no of close brackets at a time
            swaps = Math.max(swaps,close);
        }
        
        // By swapping one bracket, two close brackets are managed 
        return (swaps+1)/2;
    }
}

    
