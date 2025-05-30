class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, new ArrayList<>(), ans, nums);
        return ans;
    }
    public void solve(int i, ArrayList<Integer> ds, List<List<Integer>> ans, int nums[]){
        ans.add(new ArrayList<>(ds));
        for(int ind = i; ind < nums.length; ind++){
            if(i != ind && nums[ind] == nums[ind-1]) continue;
            ds.add(nums[ind]);
            solve(ind+1, ds, ans, nums);
            ds.remove(ds.size()-1);
        }

    }
}