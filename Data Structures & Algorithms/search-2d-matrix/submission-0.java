class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        int r = matrix.length * matrix[0].length - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int nr = mid / columnLen;
            int nc = mid % columnLen;
            if (matrix[nr][nc] == target) {
                return true;
            }
            else if (matrix[nr][nc] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
        
    }
}
