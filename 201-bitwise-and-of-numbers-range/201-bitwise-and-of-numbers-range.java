class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Consider numbers in binary in the range left to right
        // If at any bit position, 0 occurs then the answer will also contain 0
        // at that position
        
        // Find common prefix between left and right
        // This will be the answer 
        
        // Shift both left and right until both becomes equal i.e common prefix
        
        int shift = 0; //Count of shift right
        while (left!=right) {
            left=left>>1;
            right=right>>1;
            shift++;
        }
        
        return left<<shift;
    }
}