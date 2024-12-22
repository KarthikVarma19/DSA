class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> -(a-b));
        for(int stone: stones){
            pq.add(stone);
        }
        while(pq.size()>1){
            int x = pq.remove(), y = pq.remove();
            if(x == y) continue;
            pq.add(Math.abs(y-x));

        }
        if(pq.isEmpty()) return 0;
        return pq.remove();
    }
}