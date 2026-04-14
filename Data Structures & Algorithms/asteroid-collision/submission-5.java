class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        java.util.Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()){
                stack.push(asteroid);
            }
            else {
                while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0) && java.lang.Math.abs(asteroid) > java.lang.Math.abs(stack.peek())) {
                    stack.pop();
                }

                if (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0) && java.lang.Math.abs(asteroid) == java.lang.Math.abs(stack.peek())) {
                    stack.pop();
                    continue;
                }
                else if (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0) && java.lang.Math.abs(asteroid) < java.lang.Math.abs(stack.peek())) {
                    continue;
                }
                else {
                    stack.push(asteroid);
                }

            }

        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}