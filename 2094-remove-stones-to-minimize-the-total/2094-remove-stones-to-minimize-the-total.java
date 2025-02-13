class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int totSum = 0;
        for(int pile: piles){
            pq.add(pile);
            totSum += pile;
        }
        while(!pq.isEmpty() && k > 0){
            int maxPile = pq.poll();
            int half = (int)Math.floor(maxPile/2);
            int curPile = maxPile - half;
            totSum -= (maxPile-curPile);
            pq.add(curPile);
            //System.out.println(pq + " " + totSum);
            k--;
        }
        return totSum;
    }
}