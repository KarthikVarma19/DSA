class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(); //Need Largest SO Maintain Min-Heap
        for(int num: nums){
            if(pq.size() >= k){
            if(pq.peek() > num){
                continue;
            }
            pq.remove();
        }
        pq.add(num);
        }
    }
    
    public int add(int val) {
        if(pq.size() >= k){
            if(pq.peek() > val){
                return pq.peek();
            }
            pq.remove();
        }
        pq.add(val);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */