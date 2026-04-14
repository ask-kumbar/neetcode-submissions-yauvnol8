class FreqStack {

    private java.util.Map<Integer, Integer> freq;
    private java.util.Map<Integer, java.util.Stack<Integer>> freqStack;
    private int maxFreq;
    public FreqStack() {
        freq = new java.util.HashMap<>();
        freqStack = new java.util.HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int currentFreq = freq.get(val);
        
        if (currentFreq > maxFreq) {
            maxFreq = currentFreq;
        }
        
        if (!freqStack.containsKey(currentFreq)) {
            freqStack.put(currentFreq, new java.util.Stack<>());
        }
        freqStack.get(currentFreq).push(val);
        
    }

    public int pop() {
        int val = freqStack.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        if (freqStack.get(maxFreq).isEmpty()) {
            freqStack.remove(maxFreq);
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */