class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> d = new ArrayDeque<>();
        Arrays.sort(deck); // O(nlogn)
        d.add(deck[deck.length-1]);
        for(int i = deck.length-2; i >= 0; i--){
            int cur = deck[i];
            int rl = d.removeLast();
            d.addFirst(rl);
            d.addFirst(cur);
        }
        int ans[] = new int[d.size()];
        for(int i = 0; i < deck.length; i++){
            ans[i] = d.removeFirst();
        }
        return ans;

    }
}