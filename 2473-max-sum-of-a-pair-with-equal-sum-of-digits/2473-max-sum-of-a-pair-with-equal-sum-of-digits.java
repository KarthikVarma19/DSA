class Solution {
    public int getSum(int num){
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        int max[] = new int[100];
        int sum[] = new int[100];
        for(int num: nums){
            int digitSum = getSum(num);
            if(max[digitSum] == 0){
                max[digitSum] = num;
            }
            else{
                sum[digitSum] = Math.max(sum[digitSum], max[digitSum] + num);
                max[digitSum] = Math.max(max[digitSum], num);
            }
        }
        int maxi = -1;
        for(int i = 0; i < 100; i++){
            maxi = Math.max(maxi, sum[i]);
        }
        if(maxi == 0) return -1;
        return maxi;
    }
}