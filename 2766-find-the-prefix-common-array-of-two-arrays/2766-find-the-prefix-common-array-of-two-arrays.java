class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashSet<Integer> hs = new HashSet<>();
        int ans[] = new int[n];
        for( int i = 0; i < n; i++){
            hs.add(A[i]);
            hs.add(B[i]);
            ans[i] = (2 * (i+1)) - hs.size();
        }
        return ans;
    }
}