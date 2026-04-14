class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int[] result = new int[temperatures.length];
      java.util.Stack<Integer> stack = new Stack<>();
      for (int i = temperatures.length - 1; i >= 0; i--) {
        if(stack.isEmpty()) {
            stack.push(i);
            result[i] = 0;
        }
        else {
            
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
      }  
      return result;
    }
}
