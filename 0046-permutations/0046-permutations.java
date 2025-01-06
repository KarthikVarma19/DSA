class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        recuPermute(ans,nums,0);
        return ans;
    }
    private void recuPermute(List<List<Integer>> ans, int[] nums, int index){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            recuPermute(ans, nums, index+1);
            swap(nums,i,index);
        }
    }
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}