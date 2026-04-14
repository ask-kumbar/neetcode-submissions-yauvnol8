class StockSpanner {

    int numOfDays;
    java.util.Stack<int[]> stack;
    List<Integer> result;
    public StockSpanner() {
        numOfDays = 0;
        stack = new Stack<>();
        result = new ArrayList<>();

    }

    public int next(int price) {
        if (price > 0) {
            int val = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                val += result.get(stack.peek()[1]);
                stack.pop();
            }
            stack.push(new int[]{price, numOfDays});
            numOfDays ++;
            result.add(val);
            return val;
        }
        return -1;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */