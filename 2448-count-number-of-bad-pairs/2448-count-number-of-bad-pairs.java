class Solution {
    public long countBadPairs(int[] nums) {
        long badPairCount = 0; 
        HashMap<Integer,Integer> bpCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int valToIndexMinus = nums[i] - i;
            int befCount = bpCount.getOrDefault(valToIndexMinus, 0);
            bpCount.put(valToIndexMinus, befCount+1);
            badPairCount += i - befCount;
        }
        return badPairCount;
    }
}