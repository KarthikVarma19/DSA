class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean mark[] = new boolean[nums.length];
        permutation(nums,mark,ans,new ArrayList<>());
        return ans;
    }
    public void permutation(int nums[], boolean mark[], List<List<Integer>> ans, ArrayList<Integer> p){
        for(int i=0;i<nums.length;i++){
            if(mark[i] == false){
                p.add(nums[i]);
                mark[i] = true;
                permutation(nums,mark,ans,p);
                p.remove(p.size()-1);
                mark[i] = false;
            }
        }
        if(p.size() == nums.length){
            ans.add(new ArrayList<Integer>(p));
        }
    }
}