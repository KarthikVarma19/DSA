class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char ans[] = new char[n];
        for(int i = 0; i < n; i++){
            if(nums[i].charAt(i) == '1'){
                ans[i] = '0';
            }else{
                ans[i] = '1';
            }
        }
        
        return new String(ans);
    }
}