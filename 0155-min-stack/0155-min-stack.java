class Pair{
        int element;
        int minElement;
        Pair(int element, int minElement){
            this.element = element;
            this.minElement = minElement;
        }
    }
    
class MinStack {
    Stack<Pair> minStack;
    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push(new Pair(val, val));
        }else{
            Pair topElement = minStack.peek();
            if(topElement.minElement > val){
                minStack.push(new Pair(val, val));
            }else{
                minStack.push(new Pair(val , topElement.minElement));
            }
        }
    }
    
    public void pop() {
        if(minStack.isEmpty()) return;
        minStack.pop();
    }

    public int top() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek().element;
    }
    
    public int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek().minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */