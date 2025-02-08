class NumberContainers {

    private HashMap<Integer,Integer> indexToNumber;
    private HashMap<Integer,PriorityQueue<Integer>> numberToMinIndex;
    
    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToMinIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        indexToNumber.put(index, number);
        if(numberToMinIndex.containsKey(number) == false){
            numberToMinIndex.put(number, new PriorityQueue<>());
        }
        numberToMinIndex.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numberToMinIndex.containsKey(number)){
            return -1;
        }
        PriorityQueue<Integer> minIndicies = numberToMinIndex.get(number);
        while(!minIndicies.isEmpty()){
            int peek = minIndicies.peek();
            if(indexToNumber.get(peek) == number){
                return peek;
            }
            minIndicies.poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */