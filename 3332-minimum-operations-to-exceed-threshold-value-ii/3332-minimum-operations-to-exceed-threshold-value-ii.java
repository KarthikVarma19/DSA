class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num: nums){
            if(num <= k){
                pq.add(num);
            }
        }
        int ops = 0;
        while(pq.size() > 1 && pq.peek() < k){
            long e1 = pq.poll(), e2 = pq.poll();
            pq.add(Math.min(e1,e2)*2+Math.max(e1,e2));
            ops += 1;
        }
        return ops;
    }
}