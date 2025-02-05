class Solution {
    public boolean search(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            //to control overflow
            int mid = low + (high-low)/2;
            //if array contains duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                //we may loose on of the candidate so checking if one of them is our target
                if(arr[low] == target){
                    return true;
                }
                low += 1;
                high -= 1;
            }
            //if mid is my target
            else if(arr[mid] == target){
                return true;
            }
            //left is sorted
            else if(arr[low] <= arr[mid]){
                //if target lies left side
                if(arr[low] <= target && target <= arr[mid]){
                    high = mid - 1;
                }
                //not then target lies right side
                else{
                    low = mid + 1;
                }
            }
            //right is sorted
            else{
                //if target lies right side
                if(arr[mid] <= target && target <= arr[high]){
                    low = mid + 1;
                }
                //not then target lies in left side
                else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}