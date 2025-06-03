class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> freqStack;
    int maxFreq;
    public FreqStack() {
        maxFreq = 0;
        freq = new HashMap<>();
        freqStack = new HashMap<>();
    }
    
    public void push(int val) {
        int curFreq = freq.getOrDefault(val, 0) + 1;
        freq.put(val, curFreq);
        maxFreq = Math.max(maxFreq, curFreq);
        if(freqStack.containsKey(curFreq) == false){
            freqStack.put(curFreq, new Stack<>());
        }
        freqStack.get(curFreq).push(val);
    }
    
    public int pop() {
        int mostFreq = freqStack.get(maxFreq).pop();
        freq.put(mostFreq, maxFreq-1);
        if(freqStack.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return mostFreq;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */