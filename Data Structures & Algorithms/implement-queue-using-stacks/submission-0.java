class MyQueue {
    private java.util.Stack<Integer> stack1 ;
    private java.util.Stack<Integer> stack2 ;
    public MyQueue() {

            stack1 = new Stack<>();
            stack2 = new Stack<>();
    }

    public void push(int x) {
            stack1.push(x);
    }

    public int pop() {
        if (stack2.size() == 0) {
            if (stack1.size() != 0){
                int j = stack1.size();
                for (int i = 0; i < j; i++) {
                    stack2.push(stack1.pop());
                }
            }
            else {
                return -1;
            }
        }

            return stack2.pop();
    }

    public int peek() {
        if (stack2.size() == 0) {
            if (stack1.size() != 0){
                int j = stack1.size();
                for (int i = 0; i < j; i++) {
                    stack2.push(stack1.pop());
                }
            }
            else {
                return -1;
            }
        }

        return stack2.peek();
    }

    public boolean empty() {
        return (stack1.size() == 0 && stack2.size() == 0);
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */