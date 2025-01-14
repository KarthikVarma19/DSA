class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        long a = 0;
        long b = 0;
        long one = 1;
        int ans[] = new int[n];
        for(int i=0; i < n ; i++){
            a |= one << A[i];
            b |= one << B[i];
            ans[i] = Long.bitCount(a&b);
        }
        return ans;
    }
}