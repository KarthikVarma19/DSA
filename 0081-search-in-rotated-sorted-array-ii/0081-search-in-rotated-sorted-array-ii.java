class Solution {
    public boolean search(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                if(arr[low] == target) return true;
                low++;
                high--;
            }
            else if(arr[mid] == target){
                return true;
            }
            //left is sorted
            else if(arr[low] <= arr[mid]){
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}