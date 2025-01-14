class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[] = new int[50];
        int ans[] = new int[A.length];
        int count = 0;
        for(int i=0;i<A.length;i++){
            if(freq[A[i]] != 0){
                freq[A[i]]++;
                count++;
            }
            else{
                freq[A[i]] = 1;
            }
            if(freq[B[i]] != 0){
                freq[B[i]]++;
                count++;
            }
            else{
                freq[B[i]] = 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}