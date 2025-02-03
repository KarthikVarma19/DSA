class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length;
        int k = 1;
        int ans = 1;
        while(k < n){
            int incrLen = 1;
            while(k < n && arr[k-1] < arr[k]){
                k++;
                incrLen++;
            }
            int decrLen = 1;
            while(k < n && arr[k-1] > arr[k]){
                k++;
                decrLen++;
            }
            while(k < n && arr[k-1] == arr[k]){
                k++;
            }
            if(decrLen > incrLen){
                incrLen = decrLen;
            }
            if(incrLen > ans){
                ans = incrLen;
            }
        }
        return ans;
    }
}