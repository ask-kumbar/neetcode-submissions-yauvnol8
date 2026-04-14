class Solution {
    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length-1);
        return nums;
        
    }

    public void quickSort(int[] nums, int low, int high){
        if(low < high){
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot-1);
            quickSort(nums, pivot+1, high);
        }
    }

    public void swapArrayIndexes(int[] nums, int i, int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low + 1, j = high;
        while(i <= j){
            while(i <= j && nums[i] <= pivot){
                i++;
            }
            while(i <= j && nums[j] >= pivot){
                j--;
            }
            if(i < j){
                swapArrayIndexes(nums, i, j);
            }

            
        }
        swapArrayIndexes(nums, low, j);
        return j;
    }
}