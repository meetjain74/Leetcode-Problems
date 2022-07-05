class Solution {
    public boolean isHappy(int n) {
        if (n==1)
            return true;
        
        HashSet<Integer> visited = new HashSet<>();
        visited.add(n);
        
        int current = n;
        while(true) {
            current = getDigitSquareSum(current);
            if (current==1)
                return true;
            
            if (!visited.add(current))
                break;
        }
        
        return false;
    }
    
    private int getDigitSquareSum(int n) {
        int result = 0;
        while (n!=0) {
            int rem = n%10;
            n = n/10;
            result += rem*rem;
        }
        return result;
    }
}