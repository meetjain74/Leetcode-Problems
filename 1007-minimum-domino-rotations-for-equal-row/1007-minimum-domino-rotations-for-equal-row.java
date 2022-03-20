class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num1 = tops[0];
        int num2 = bottoms[0];
        
        int swaps1T = 0; // For num1 top
        int swaps1B = 0; // For num1 bottom
        int swaps2T = 0; // For num2 top
        int swaps2B = 0; // For num2 bottom
        
        for (int i=0;i<tops.length;i++) {
            if (tops[i]==num1 && bottoms[i]!=num1) swaps1B++;
            else if (bottoms[i]==num1 && tops[i]!=num1) swaps1T++;
            else if (tops[i]==num1 && bottoms[i]==num1) ;
            else num1=-1;
            
            if (tops[i]==num2 && bottoms[i]!=num2) swaps2B++;
            else if (bottoms[i]==num2 && tops[i]!=num2) swaps2T++;
            else if (tops[i]==num2 && bottoms[i]==num2) ;
            else num2=-1;
            
            if (num1==-1 && num2==-1) return -1;
        }
        
        if (num1==-1) return Math.min(swaps2B,swaps2T);
        else if (num2==-1) return Math.min(swaps1B,swaps1T);
        else return Math.min(Math.min(swaps1B,swaps1T),Math.min(swaps2B,swaps2T));
    }
}