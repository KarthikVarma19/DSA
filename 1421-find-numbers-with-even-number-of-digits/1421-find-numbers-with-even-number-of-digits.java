class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){
            int log10 = (int)Math.log10(num);
            log10 += 1;
            if(log10 % 2 == 0) count++;
        }
        return count;
    }

}