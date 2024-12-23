class MedianFinder {
    PriorityQueue<Integer> maxHeapLeft;
    PriorityQueue<Integer> minHeapRight;
    public MedianFinder() {
        maxHeapLeft = new PriorityQueue<>(Comparator.reverseOrder());
        minHeapRight = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeapRight.add(num);
        maxHeapLeft.add(minHeapRight.remove());
        if(minHeapRight.size() < maxHeapLeft.size()){
            minHeapRight.add(maxHeapLeft.remove());
        }
    }
    
    public double findMedian() {
        if(minHeapRight.size() == maxHeapLeft.size()){
            return (minHeapRight.peek() + maxHeapLeft.peek())/2.0;
        }
        return minHeapRight.peek()/1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */