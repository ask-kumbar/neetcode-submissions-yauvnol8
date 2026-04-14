class Solution {
    public int calPoints(String[] operations) {
        java.util.Stack<String> stack = new Stack<>();
            for (String str : operations) {
                switch (str) {
                    case "+":
                        int operand2 = Integer.parseInt(stack.pop());
                        int operand1 = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(operand1));
                        stack.push(String.valueOf(operand2));
                        stack.push(String.valueOf(operand1 + operand2));
                        break;
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        int operand = Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(operand));
                        stack.push(String.valueOf(2 * operand));
                        break;
                    default:
                        stack.push(str);
                        break;

                }
            }

            int score = 0;
            while(!stack.isEmpty()) {
                score += Integer.parseInt(stack.pop());
            }
            return score;
    }
}