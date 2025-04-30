class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums){
            if(evenDigits(num) == true){
                count++;
            }
        }
        return count;
    }
    public boolean evenDigits(int val){
        String num = String.valueOf(val);
        return num.length()%2==0;
    }
}