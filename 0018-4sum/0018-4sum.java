class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                Set<Long> hs = new HashSet<>();
                for(int k = j+1; k < n; k++){
                    long sum = nums[i]+nums[j];
                    sum += nums[k];
                    long rem = target - sum;
                    if(hs.contains(rem)){
                        List<Integer> ls = Arrays.asList(nums[i], nums[j], nums[k], (int)rem);
                        Collections.sort(ls);
                        // ls.sort(Integer::compareTo);
                        ans.add(ls);
                    }
                    hs.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> finalans = new ArrayList<>(ans);
        return finalans;
    }
}