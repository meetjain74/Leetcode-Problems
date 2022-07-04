class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if (low==high)
            return ans;
        
        // BFS 
        // Go to elements in the following fashion - 
        // 1 2 3 4 5 6 7 8 9 12 23 34 45 56 67 78 89 123 234 345 .........
        Queue<Integer> q = new LinkedList<>();
        for (int i=1;i<=9;i++) {
            q.add(i);
        }
        
        while (!q.isEmpty()) {
            int num = q.poll();
            
            if (num>=low && num<=high)
                ans.add(num);
            
            if (num>high) // Out of range elements further - hence break
                break;
            
            int lastDigit = num%10;
            if (lastDigit<9) {
                num = num*10+lastDigit+1;
                q.add(num);
            }
        }
        
        return ans;
    }
}