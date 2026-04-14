class Solution {
    public int evalRPN(String[] tokens) {
        java.util.Stack<Integer> operandStack = new Stack<>();

        for (String token : tokens){
            switch (token) {
                case "+", "-", "/", "*" -> {
                    int b = operandStack.pop();
                    int a = operandStack.pop();
                    int result = switch (token) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        case "/" -> a / b;
                        default -> throw new IllegalStateException("Unexpected value: " + token);
                    };
                    operandStack.push(result);
                }
                default -> operandStack.push(Integer.parseInt(token));
            }
    }
        return operandStack.pop();
    }
}
