class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        // since first and last can't be peak let us skip those
        for(int i = 1; i < mountain.length-1; i++){
            if(mountain[i] >  mountain[i-1] && mountain[i] > mountain[i+1]){
                ans.add(i);
            }
        }
        return ans;
    }
}