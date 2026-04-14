class Solution {
    public String simplifyPath(String path) {
        java.util.Stack<String> stack = new java.util.Stack<>();
        String[] directories = path.split("/");
        for (String dir : directories) {
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            } else if (!dir.equals("")) {
                stack.push(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}