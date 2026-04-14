class Solution {
    public void reverseString(char[] s) {
        int pt1 = 0;
        int pt2 = s.length - 1;
        while(pt1 < pt2){
            char temp = s[pt1];
            s[pt1] = s[pt2];
            s[pt2] = temp;
            pt1++;
            pt2--;
        }

    }
}