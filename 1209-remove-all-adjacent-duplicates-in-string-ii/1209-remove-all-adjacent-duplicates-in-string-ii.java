class Pair {
    char ch;
    int count;
    
    Pair(char ch,int count) {
        this.ch=ch;
        this.count=count;
    }
    
    public String toString() {
        return this.ch+" "+this.count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (char ch:s.toCharArray()) {
            Pair p = new Pair('#',0);
            if (!stack.isEmpty())
                p=stack.peek();
            
            if (p.ch==ch) {
                if (p.count+1==k)
                    stack.pop();
                else
                    p.count++;
            }
            else {
                stack.push(new Pair(ch,1));
            }
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i=0;i<p.count;i++) {
                ans = p.ch+ans;
            }
        }
        
        return ans;
    }
}