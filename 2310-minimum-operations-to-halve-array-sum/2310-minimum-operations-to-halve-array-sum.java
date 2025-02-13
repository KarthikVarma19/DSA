class Solution {
    public int halveArray(int[] nums) {
        double initSum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(double num: nums){
            pq.add(num);
            initSum += num;
        }
        double minSum = initSum;
        int ops = 0;
        while(!pq.isEmpty() && (minSum > (initSum/2))){
            double peek = pq.poll();
            double newVal = peek/2.0;
            pq.add(peek/2.0);
            minSum -=  newVal;
            ops++;
        }
        return ops;
    }
}