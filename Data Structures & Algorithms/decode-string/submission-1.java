class Solution {
    public String decodeString(String s) {
        java.util.Stack<String> stack = new Stack<>();
        String out = "";
        for (char c : s.toCharArray()) {
            switch (c) {
                case ']':
                    String a = "";
                    while (!stack.isEmpty() && !Objects.equals(stack.peek(), "[")) {
                        a = stack.pop() + a; 
                    }
                    stack.pop();
                    String repeatVal = "";
                    while(!stack.isEmpty() && stack.peek().matches("[0-9]")) {
                        repeatVal = stack.pop() + repeatVal;
                    }
                    a = a.repeat(Integer.parseInt(repeatVal));
                    stack.push(String.valueOf(a));
                    break;
                default :
                    stack.push(String.valueOf(c));
                    break;
            }
        }
        while(!stack.isEmpty())
        {
            out = stack.pop() + out;
        }

        return out;
    }
}