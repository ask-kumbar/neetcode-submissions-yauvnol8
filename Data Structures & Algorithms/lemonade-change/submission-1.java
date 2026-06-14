class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[2];
        if ( bills[0] != 5){
            return false;
        }

        change[0] = 1;

        for (int i = 1; i < bills.length; i++) {
            if (bills[i] == 10) {
                if(change[0] < 1){
                    return false;
                }
                change[0]--;
                change[1]++;
            }
            else if (bills[i] == 20){
                if(change[1] < 1) {
                    if(change[0] < 3){
                        return false;
                    }
                    change[0] -= 3;
                }
                else {
                    if (change[0] < 1) {
                        return false;
                    }
                    change[1]--;
                    change[0]--;
                }
            }
            else{
                change[0]++;
            }
        }
        return true;

    }
}