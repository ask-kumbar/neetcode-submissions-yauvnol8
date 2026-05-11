class Solution {
    int[] sMap = new int[52];
    int[] tMap = new int[52];
    String result = "";


    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        for (int i = 0; i < t.length(); i++) {
            tMap[getIndex(t.charAt(i))]++;
        }

        int sContains = 0;

        int l = 0;
        int r;
        for (r = 0; r < s.length(); r++) {
            sMap[getIndex(s.charAt(r))]++;
            if (sContains != t.length() && tMap[getIndex(s.charAt(r))] == sMap[getIndex(s.charAt(r))]) {
                sContains += tMap[getIndex(s.charAt(r))];
            }
            while(l <= r && sMap[getIndex(s.charAt(l))] > tMap[getIndex(s.charAt(l))]) {
                sMap[getIndex(s.charAt(l))]--;
                if (sMap[getIndex(s.charAt(l))] < tMap[getIndex(s.charAt(l))]) {
                    sContains--;
                }
                l++;

            }
            if(sContains == t.length()) {
                if (result == "" || (r - l + 1) < result.length()) result = s.substring(l, r + 1);
            }



        }

        return result;
    }

    public int getIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return 26 + (c - 'A');
        }


    }


}
