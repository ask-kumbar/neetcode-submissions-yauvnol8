class Solution {
    public String addBinary(String a, String b) {
        StringBuilder out = new StringBuilder();
        int minLen = Math.min(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < minLen; i++) {
            if (a.charAt(a.length() - 1 - i) == '1' && b.charAt(b.length() - 1 - i) == '1') {
                if (carry == 1) {
                    out.append('1');
                }
                else {
                    out.append('0');
                    carry = 1;
                }
            }
            else if (a.charAt(a.length() - 1 - i) == '0' && b.charAt(b.length() - 1 - i) == '0'){
                if (carry == 1) {
                    out.append('1');
                    carry = 0;
                }
                else {
                    out.append('0');

                }
            }
            else {
                if (carry == 1) {
                    out.append('0');
                }
                else {
                    out.append('1');
                }
            }
        }
        String temp ;
        if (a.length() > minLen) {
            temp = a;
        }
        else {
            temp = b;
        }

        int len = temp.length() - minLen - 1;
        while(len >= 0){
            if (carry == 1) {
                if(temp.charAt(len) == '1'){
                    out.append('0');
                }
                else {
                    out.append('1');
                    carry = 0;
                }
            }
            else {
                out.append(temp.charAt((len)));
            }
            len--;
        }
        if (carry == 1)out.append('1');
            
        return String.valueOf(out.reverse());
    }
    }
