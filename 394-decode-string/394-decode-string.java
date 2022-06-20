class Solution {
    public String decodeString(String s) {
        // System.out.println(isNumeric("698er"));
        // return "ac";
        
        Stack<String> stack = new Stack<>();
        
        String num = "";
        for (char ch: s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num=num+ch;
            }
            else if (ch=='[') {
                stack.push(num);
                num="";
            }
            else if (Character.isLowerCase(ch)) {
                stack.push(Character.toString(ch));
            }
            else { // ch is ]
                // Pop until number reaches
                String temp = "";
                while ( !isNumeric(stack.peek()) ) {
                    temp = stack.pop()+temp;
                }
                int repeat = Integer.parseInt(stack.pop());
                String res = "";
                while (repeat!=0) {
                    res+=temp;
                    repeat--;
                }
                stack.push(res);
            }
        }
        
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop()+ans;
        }
        return ans;
    }
    
    private boolean isNumeric(String str) { 
        try {  
            Integer.parseInt(str);  
            return true;
        } 
        catch(NumberFormatException e){  
            return false;  
        }  
    }
}