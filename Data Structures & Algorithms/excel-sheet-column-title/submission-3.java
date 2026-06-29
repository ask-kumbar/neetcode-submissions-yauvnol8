class Solution {
    public String convertToTitle(int columnNumber) {
        int number = columnNumber;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (number > 0) {
            if(i == 0) {
                int dec = number % 26 == 0? 26 : number % 26;
                sb.append((char)('A' + dec - 1));
                number -= dec;
            }
            else {
                int digit = (number / (int)Math.pow(26, i)) ;
                digit = digit > 26 ? (digit % 26) : digit;
                sb.append((char)('A'+ digit - 1));
                number -= digit * Math.pow(26, i);

            }
            i++;
            
        }
        return sb.reverse().toString();
    }
}