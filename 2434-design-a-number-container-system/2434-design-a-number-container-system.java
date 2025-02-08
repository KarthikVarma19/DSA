class NumberContainers {

    HashMap<Integer,Integer> container;
    HashMap<Integer,TreeSet<Integer>> minIndex;

    public NumberContainers() {
        container = new HashMap<>();
        minIndex = new HashMap<>();
    }
    
    public void change(int index, int number) {
        //Container
        if(container.containsKey(index)){
            int prev = container.get(index);
            TreeSet<Integer> pq = minIndex.get(prev);
            //Remove the Index From PrevNumber
            pq.remove(index);
            //Delete the Container
            if(pq.size() == 0){
                container.remove(index);
            }
        }
        container.put(index, number);
        //MinIndex
        if(minIndex.containsKey(number) == false){
            minIndex.put(number, new TreeSet<>());
        }
        TreeSet<Integer> pq = minIndex.get(number);
        pq.add(index);
    }
    
    public int find(int number) {
        if(minIndex.containsKey(number) == false){
            return -1;
        }
        TreeSet<Integer> pq = minIndex.get(number);
        if(pq.size() == 0) return -1;
        int min = pq.first();
        return min;
    }
}