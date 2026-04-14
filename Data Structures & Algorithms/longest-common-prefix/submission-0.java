class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs){
           int len = Math.min(prefix.length(), str.length());
           int i = 0;
           while (i < len && prefix.charAt(i) == str.charAt(i)){
               i++;
           }
           if (i == 0) {
                return "";
           }
           prefix = str.substring(0, i);
        }
        return prefix;
    }
}