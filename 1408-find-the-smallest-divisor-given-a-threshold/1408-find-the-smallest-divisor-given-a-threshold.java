class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long low = 1, high = 0; 
        for(int num: nums){
            high += num;
        }  
        while(low <= high){
            long mid = (low + high) >>> 1;
            if(isPossible(mid, nums, threshold) == true){
                // ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int)low;
    }
    public boolean isPossible(long mid, int arr[], int th){
        long tot = 0;
        for(int i = 0; i < arr.length; i++){
            tot += (arr[i] + mid -1)/mid;
        }
        // System.out.println(mid + " "+ tot);
        return tot <= (long)th;
    }

}