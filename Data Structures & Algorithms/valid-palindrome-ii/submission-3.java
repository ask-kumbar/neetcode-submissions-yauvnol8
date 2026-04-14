class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        return validate(s, false, i, j);
    }

    public boolean validate(String s, boolean deleted, int i, int j){
        if (i >= j) {
            return true;
        }
        boolean val1 = false;
        boolean val2 = false;
        if (s.charAt(i) != s.charAt(j)) {
            if (deleted){
                return false;
            }
            if(s.charAt(i + 1) == s.charAt(j)){
                val1 = validate(s, true, i+1, j);
            }
            if(s.charAt(i) == s.charAt(j-1)){
                val2 = validate(s, true, i, j-1);
            }
            return val1 || val2;
        }
        return validate(s, deleted, i+1, j-1);
                
                 
    }
}