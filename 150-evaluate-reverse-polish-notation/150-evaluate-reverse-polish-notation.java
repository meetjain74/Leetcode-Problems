class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for (String token: tokens) {
            if (!token.equals("+") && !token.equals("-") && 
                !token.equals("*") && !token.equals("/")) {
                int val = Integer.parseInt(token);
                operands.push(val);
            }
            
            else {
                int op1 = operands.pop();
                int op2 = operands.pop();
                int result=0;
                
                switch (token) {
                    case "+" : result = op1+op2;
                               break;
                    case "-" : result = op2-op1;
                               break;
                    case "*" : result = op1*op2;
                               break;
                    case "/" : result = op2/op1;
                               break;
                }
                
                operands.push(result);
            }
        }
        
        return operands.pop();
    }
}