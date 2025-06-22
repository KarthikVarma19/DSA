class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int splitLength = (n + k - 1)/k;
        String ans[] = new String[splitLength];
        int p = 0;
        String fills = "" + fill;
        for(int i = 0; i < n; i += k){
            if(i + k <= n){
                ans[p] = s.substring(i, i + k);
            } else {
                String subs = s.substring(i, n);
                subs = subs + fills.repeat(k-subs.length());
                ans[p] = subs;
            }
            p++;
        }
        return ans;

    }
}