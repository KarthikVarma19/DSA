class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(++freq[nums[i]],max);
        }
        int count = 0;
        for(int i=1;i<101;i++){
            if(freq[i] == max){
                count++;
            }
        }
        return count*max;
    }
}