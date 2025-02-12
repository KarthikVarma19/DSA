class Solution {
    public int getDigitSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int max[] = new int[82];
        int result = -1;
        for(int num: nums){
            int digitSum = getDigitSum(num);
            if(max[digitSum] == 0){
                max[digitSum] = num;
            }
            else{
                int currentSum = max[digitSum] + num;
                max[digitSum] = Math.max(max[digitSum], num);
                result = Math.max(result, currentSum);
            }
        }
        if(result == 0){
            return -1;
        }
        return result;
    }
}