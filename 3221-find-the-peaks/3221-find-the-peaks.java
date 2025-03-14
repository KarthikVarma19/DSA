class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        // since first and last can't be peak let us skip those
        for(int i = 1; i < mountain.length-1; i++){
            int cur = mountain[i];
            int left = mountain[i-1];
            int right = mountain[i+1];
            if(cur > left && cur > right){
                ans.add(i);
            }
        }
        return ans;
    }
}