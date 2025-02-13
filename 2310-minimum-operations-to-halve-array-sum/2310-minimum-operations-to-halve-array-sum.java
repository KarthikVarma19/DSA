class Solution {
    public int halveArray(int[] nums) {
        double initSum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(double num: nums){
            pq.add(num);
            initSum += num;
        }
        double half = initSum/2.0;
        int ops = 0;
        while(half > 0) {
            double peek = pq.poll();
            double newVal = peek/2.0;
            pq.add(newVal);
            half -=  newVal;
            ops++;
        }
        return ops;
    }
}