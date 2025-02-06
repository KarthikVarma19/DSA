class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int tuples = 0;
        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--){
                int prod = nums[i] * nums[j];
                Set<Integer> st = new HashSet<>();
                for(int k = i + 1; k < j; k++){
                    if(prod%nums[k] == 0){
                        if(st.contains(prod/nums[k]) == true){
                            tuples++;
                        }
                    }
                    st.add(nums[k]);
                }
            }
        }
        return (tuples) * 8;
    }
}