class Pair {
    int key;
    int value;
    
    Pair(int key,int value) {
        this.key=key;
        this.value=value;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public int getValue() {
        return this.value;
    }
}

class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        
        Stack<Pair> st = new Stack<>();
        int ans = 0;
        st.push(new Pair(nums[n-1],0));
        
        for (int i=n-2;i>=0;i--) {
            int current = nums[i];
            int count = 0;
            while (!st.isEmpty() && current>st.peek().getKey()) {
                count = Math.max(count+1,st.peek().getValue());
                st.pop();
            }
            ans = Math.max(ans,count);
            st.push(new Pair(current,count));
        }
        
        return ans;
    }
}