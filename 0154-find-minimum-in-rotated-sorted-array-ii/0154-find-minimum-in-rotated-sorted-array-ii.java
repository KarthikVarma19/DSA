class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            //If Array Contains Dupplicates 
            if(arr[mid] == arr[low] && arr[mid] == arr[high]){
                low += 1;
                high -= 1;
                ans = Math.min(ans, arr[mid]);
            }
            //if Left Array is Sorted
            else if(arr[low] <= arr[mid]){
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            }
            //if Right Array is Sorted
            else{
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}