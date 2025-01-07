class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        int leftPointer = 0, rightPointer = numbers.length - 1; 
        while(leftPointer < rightPointer){
            int sum = numbers[leftPointer] + numbers[rightPointer];
            if(sum == target){
                ans[0] = leftPointer + 1;
                ans[1] = rightPointer + 1;
                return ans; 
            }
            else if(sum < target){
                leftPointer++;
            }
            else{
                rightPointer--;
            }
        }
        return ans;
    }
}