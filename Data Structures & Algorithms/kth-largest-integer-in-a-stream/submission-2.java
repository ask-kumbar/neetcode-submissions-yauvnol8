class KthLargest {

    int count;
    int capacity;
    int[] array;

    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        this.array = new int[this.capacity];
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void insert(int val) {
        if (this.count == this.capacity) {
            if (val > this.array[0]) {
                this.array[0] = val;
                percolateDown(0);
            }
        }
        else {
            this.count++;
            int index = this.count - 1;
            while (parent(index) >= 0 && this.array[parent(index)] > val) {
                this.array[index] = this.array[parent(index)];
                index = parent(index);
            }
            this.array[index] = val;
        }
    }

    public int leftChild(int index) {
        int value = 2 * index + 1;
        if (value >= this.count) {
            return -1;
        }
        return value;
    }

    public int rightChild(int index) {
        int value = 2 * index + 2;
        if (value >= this.count) {
            return -1;
        }
        return value;
    }

    public int parent(int index){
        if (index <= 0 || index >= this.count) {
            return -1;
        }
        return (index - 1) / 2;
    }


    public int add(int val) {
        insert(val);
        return this.array[0];
    }

    public void percolateDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int min = index;
        if (left != -1 && this.array[left] < this.array[min]) {
                min = left;
        }
        if (right != -1 && this.array[right] < this.array[min]) {
            min = right;
        }

        if (index != min) {
            int temp = this.array[index];
            this.array[index] = this.array[min];
            this.array[min] = temp;
            percolateDown(min);
        }
    }
}
