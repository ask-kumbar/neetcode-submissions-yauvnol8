class MinStack {

    private java.util.Stack<Integer> stack;
    private java.util.Stack<Integer> minVal;
    public MinStack() {
        stack = new Stack<>();
        minVal = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minVal.isEmpty()) {
            minVal.push(val);
        }
        else if (minVal.peek() >= val) {
            minVal.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            if (!minVal.isEmpty() && minVal.peek() == val) {
                minVal.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        if (!minVal.isEmpty()) {
            return minVal.peek();
        }
        return -1;
    }
}
