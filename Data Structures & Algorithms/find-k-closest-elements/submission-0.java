class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new ArrayDeque<>();
        int l = 0;
        int len = 0;
        for (int r = 0; r < arr.length; r++){
            if (len < k) {
                q.add(arr[r]);
                len++;
            }
            else {
                if (Math.abs(x - arr[l]) > Math.abs(x - arr[r])) {
                    q.poll();
                    q.add(arr[r]);
                    l++;
                }
            }
        }
        return new ArrayList<>(q);
    }
}