class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        // impossible to split 
        if(k > n) return -1;
        // low is max of all 
        long low = nums[0];
        // high is sum of all
        long high = 0;
        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }

        while(low <= high){
            long mid = (low + high) >>> 1;
            int splits = numberOfSplits(nums, mid);
            if(splits > k){
                low = mid + 1;
            }
            // minimizing the largest sum of split
            else{
                high = mid - 1;
            }
        }
        return (int)low;
    }
    public int numberOfSplits(int arr[], long mid){
        int splits = 1;
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            if((sum + arr[i]) <= mid){
                sum += arr[i];
            }else{
                splits += 1;
                sum = arr[i];
            }
        }
        return splits;
    }
}