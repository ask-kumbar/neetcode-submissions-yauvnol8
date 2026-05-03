class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //System.out.println(s1 + s2.charAt(1));
        if (s1.length() > s2.length()) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++){
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (map1[i] == map2[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            map2[index]++;
            if (map1[index] == map2[index]) {
                matches++;
            } else if (map1[index] + 1 == map2[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            map2[index]--;
            if (map1[index] == map2[index]) {
                matches++;
            } else if (map1[index] - 1 == map2[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;    
        }
}
