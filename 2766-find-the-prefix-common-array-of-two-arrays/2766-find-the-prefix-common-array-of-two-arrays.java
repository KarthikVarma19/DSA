class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans[] = new int[A.length];
        int count = 0;
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                hm.put(A[i], hm.get(A[i])+1);
                count++;
            }
            else{
                hm.put(A[i], 1);
            }
            if(hm.containsKey(B[i])){
                hm.put(B[i], hm.get(B[i]+1));
                count++;
            }
            else{
                hm.put(B[i],1);
            }
            ans[i] = count;
        }
        return ans;
    }
}