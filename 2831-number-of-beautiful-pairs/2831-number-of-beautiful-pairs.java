class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int beautifulPairs = 0;
        for(int i = 0; i < n; i++){
            int firstDigit = getFirstDigit(nums[i]);
            for(int j = i+1; j < n; j++){
                int lastDigit = getLastDigit(nums[j]);
                if(gcd(firstDigit, lastDigit) == 1){
                    beautifulPairs++;
                }
            }
        }   
        return beautifulPairs;
    }
    public int getLastDigit(int num){
        int last = num % 10;
        return last;
    }
    public int getFirstDigit(int num){
        int first =  num;
        while(num != 0){
            first = num%10;
            num /= 10;
        }
        return first;
    }
    public int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}