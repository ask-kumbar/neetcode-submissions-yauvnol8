class Solution {
    public int findJudge(int n, int[][] trust) {
        int row = trust.length;
        int column = trust[0].length;
        int temp = trust[0][1];
        for (int i = 1; i < row; i++){
            if (trust[i][1] != temp) {
                return -1;
            }
        }
        return temp;
    }
}