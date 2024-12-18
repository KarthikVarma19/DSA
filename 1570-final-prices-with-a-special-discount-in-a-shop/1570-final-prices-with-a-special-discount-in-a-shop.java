class Solution {
    public int[] finalPrices(int[] prices) {
        int nse[] = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for(int i=prices.length-1;i>=0;i--){
            int cur = prices[i];
            while(!st.isEmpty() && st.peek() > cur){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = prices[i];
            }
            else{
                nse[i] = prices[i] - st.peek();
            }
            st.push(cur);
        }
        return nse;
    }
}