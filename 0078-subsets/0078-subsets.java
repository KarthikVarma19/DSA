class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < (1<<n); i++){
            List<Integer> ss = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(((i>>j)&1) == 1){
                    ss.add(nums[j]);
                }
            }
            ans.add(ss);
        }
        return ans;
    }
}