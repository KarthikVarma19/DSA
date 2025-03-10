class Solution {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for(int num: nums){
            if(num < smallest){
                smallest = num;
            }
            if(num > largest){
                largest = num;
            }
        }
        return gcd(smallest, largest);
    }
    public int gcd(int a, int b){
        while(a != 0){
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}