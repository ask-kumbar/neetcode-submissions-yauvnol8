class Solution {

        public void createVariableEncoding(int n, java.io.ByteArrayOutputStream out) {
            if (n == 0) {
                out.write(0);
            }
            while ((n & 0x7F) != 0) {
                int val = n & 0x7F;
                n = n >> 7;
                val = n > 0 ? val | 0x80 : val;
                out.write(val);
            }
        }
        public String encode(List<String> strs) {
            java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
            int len = strs.size();
            createVariableEncoding(len, out);
            for (int i = 0; i < strs.size(); i++) {
                createVariableEncoding(strs.get(i).length(), out);
                for (char ch : strs.get(i).toCharArray()) {
                    createVariableEncoding((int)ch, out);

                }
            }

            String result = Base64.getEncoder().encodeToString(out.toByteArray());
            System.out.println(result);
            return result;
        }

        public int[] variableDecode(int index, byte[] in) {
            int[] returnVal = new int[]{index, 0};
            while (index < in.length) {
                byte bt = in[index];
                returnVal[1] = returnVal[1] | ((bt & 0x7F) << ((index - returnVal[0]) * 7));
                index++;
                if ((bt & 0x80) == 0) {
                    break;
                }
            }
            returnVal[0] = index;
            return returnVal;
        }

        public List<String> decode(String str) {
            byte[] in = Base64.getDecoder().decode(str);
            System.out.println(in[0]);
            int i = 0;
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            int[] returnVal = variableDecode(i, in);
            i = returnVal[0];
            int n = returnVal[1];

            for (int j = 0; j < n; j++) {
                returnVal = variableDecode(i, in);
                i = returnVal[0];
                int l = returnVal[1];
                for (int k = 0; k < l; k++) {
                    returnVal = variableDecode(i, in);
                    i = returnVal[0];
                    sb.append((char)returnVal[1]);
                }
                result.add(sb.toString());
                sb.setLength(0);
            }
            return result;
        }

        

}
