class Solution {
    public int calculate(String s) {
        List<String> postfix = infixToPostfix(s);
        return evaluatePostfix(postfix);
    }
    
    public List<String> infixToPostfix(String s) {
        List<String> postfix = new ArrayList<>();
        
        Stack<Character> operators = new Stack<>();
        operators.push('(');
        s += ')';
        
        int num=0;
        
        boolean isCounting=false; // Is counting number
        boolean isUnary=true; // Is operator unary
        
        for (char ch: s.toCharArray()) {
            if (Character.isWhitespace(ch))
                continue;
            
            if (isUnary) {
                isUnary=false;
                if (ch=='+' || ch=='-')
                    postfix.add("0");
            }
            
            if (Character.isDigit(ch)) {
                isCounting=true;
                num=num*10+(ch-'0');
            }
            else {
                if (isCounting) {
                    isCounting=false;
                    postfix.add(Integer.toString(num));
                    num=0;
                }
                
                if (ch=='(') {
                    isUnary=true;
                    operators.push('(');
                }
                else if (ch==')') {
                    // Pop from stack until ( reaches
                    while(operators.peek() != '(') {
                        postfix.add(Character.toString(operators.pop()));
                    }
                    operators.pop(); // pop '('
                }
                else {
                    // Precedence of incoming operator in stack should be highest
                    // Pop from stack until top have low precedence 
                    // than incoming operator
                    while (!operators.isEmpty() && prec(ch)<=prec(operators.peek())) {
                        postfix.add(Character.toString(operators.pop()));
                    }
                    operators.push(ch);
                }
            }
        }
        
        return postfix;
    }
    
    // Returns precedence of operator
    private int prec(char op) {
        if (op=='+' || op=='-')
            return 2;
        if (op=='*' || op=='/')
            return 3;
        if (op=='(')
            return 1;
        return 0; // default
    }
    
    public int evaluatePostfix(List<String> tokens) {
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