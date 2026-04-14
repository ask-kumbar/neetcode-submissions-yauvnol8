class Solution {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else {
                char ch1;
                if (stack.size() != 0){
                    ch1 = stack.pop();
                }
                else{
                    return false;
                }
                
                switch (ch){
                    case ')':    
                        if (ch1 == '(') {
                            continue;
                        }
                        return false;
                
                    case '}':
                        if (ch1 == '{') {
                            continue;
                        }
                        return false;
                    case ']':
                        if (ch1 == '[') {
                            continue;
                        }
                        return false;
                }
            }
        }
        if (stack.size() != 0){
            return false;
        }
        return true;
    }
    }
