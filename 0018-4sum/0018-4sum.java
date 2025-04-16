class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // since we are using two pointers approach
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                int k = j + 1;
                int l = n - 1;
                while(k < l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if(sum == target){
                        List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(ls);
                        k++;
                        l--;
                        // skip the duplicates
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }else if(sum > target){
                        l--;
                    }else{
                        k++;
                    }
                }
                
            }
        }
        return ans;
    }
}