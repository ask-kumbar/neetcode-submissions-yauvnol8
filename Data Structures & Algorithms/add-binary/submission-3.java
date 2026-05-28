class Solution {
    public String addBinary(String a, String b) {
        StringBuilder out = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int diga = i >= 0 ? a.charAt(i) - '0' : 0;
            int digb = j >= 0 ? b.charAt(j) - '0': 0;
            
            int res = diga + digb + carry;
            out.append(res % 2);
            carry = res / 2;
            i--;
            j--;
        }
        return String.valueOf(out.reverse());
    }
    }
