class Solution {
    public int maximumCount(int[] nums) {
        int negEle = 0, posEle = 0;
        for(int num: nums){
            if(num < 0){
                negEle++;
            }
            else if(num > 0){
                posEle++;
            }
        }
        return Math.max(negEle, posEle);
    }
}