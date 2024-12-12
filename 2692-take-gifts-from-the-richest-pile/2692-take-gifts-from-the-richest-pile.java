class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        long sum = 0;
        for(int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
            sum += gifts[i];
        }
        for(int i=0;i<k;i++){
            int top = pq.remove();
            int bal = (int)Math.floor(Math.sqrt(top));
            pq.add(bal);
            sum -= top;
            sum += bal;
        }
        return sum;
    }
}