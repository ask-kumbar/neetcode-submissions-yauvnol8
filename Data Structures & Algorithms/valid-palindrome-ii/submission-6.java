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
        if (s.charAt(i) != s.charAt(j)) {
            if (deleted){
                return false;
            }
            return validate(s, true, i+1, j) || validate(s, true, i, j-1);
        }
        return validate(s, deleted, i+1, j-1);
                
                 
    }
}