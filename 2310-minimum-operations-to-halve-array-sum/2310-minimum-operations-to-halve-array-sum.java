class Solution {
    public int halveArray(int[] nums) {
        double initSum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(double num: nums){
            pq.add(num);
            initSum += num;
        }
        double curSum = initSum;
        int ops = 0;
        while(!pq.isEmpty() && (curSum > (initSum/2))){
            double peek = pq.poll();
            double newVal = peek/2.0;
            pq.add(newVal);
            curSum -=  newVal;
            ops++;
        }
        return ops;
    }
}