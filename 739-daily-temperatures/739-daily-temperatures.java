class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        // Similar to Next greater element
        int answer[] = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0); // Push Index 0 
        
        for (int i=1;i<n;i++) {
            int curr = temperatures[i];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!s.isEmpty() && temperatures[s.peek()]<curr) {
                answer[s.peek()] = i-s.pop();
            }
            s.push(i);
        }
        
        return answer;
    }
}