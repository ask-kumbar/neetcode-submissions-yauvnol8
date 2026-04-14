class Solution {
    public boolean isPalindrome(String s) {
        String alphanumeric = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0;
        int j = alphanumeric.length() - 1;
        while(i < j) {
            if (alphanumeric.charAt(i) != alphanumeric.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
