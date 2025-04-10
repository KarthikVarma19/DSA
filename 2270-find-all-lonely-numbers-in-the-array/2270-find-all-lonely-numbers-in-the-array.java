class Solution {
    public List<Integer> findLonely(int[] nums) {
        Set<Integer> st = new HashSet<>();
        Set<Integer> dp = new HashSet<>();
        for(int each: nums){
            if(st.contains(each)){
                dp.add(each);
            }else{
                st.add(each);
            }
        }
        int n = nums.length;
        
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int cur = nums[i];
            if(dp.contains(cur)){
                continue;
            }else{
                if(!st.contains(cur+1) && !st.contains(cur-1)){
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
}