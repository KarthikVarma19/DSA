class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high) >>> 1;
            int miss = arr[mid]-(mid+1);
            if(miss >= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return k + high + 1;
    }
}