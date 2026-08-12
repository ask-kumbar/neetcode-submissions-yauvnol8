class Solution {
    List<String> output;
    public List<String> generateParenthesis(int n) {
        output = new ArrayList<>();
        generateBrackets(n, 0, 0, new StringBuilder());
        return output;
    }

    public void generateBrackets(int n, int open, int close, StringBuilder sb) {
        if (open == n && close == n) {
            output.add(sb.toString());
            return;
        }
        
        if (open < n) {
            sb.append('(');
            generateBrackets(n, open + 1, close, sb);
            sb.setLength(sb.length() - 1);
        }
        if (open > close && close < n) {
            sb.append(')');
            generateBrackets(n, open, close + 1, sb);
            sb.setLength(sb.length() - 1);
        }
        
    }
}
