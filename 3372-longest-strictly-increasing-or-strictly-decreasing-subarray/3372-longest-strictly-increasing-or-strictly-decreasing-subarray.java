class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int n = arr.length;
        int incrLen = 1, decrLen = 1, maxLen = 1;
        for(int index = 1; index < n; index++){
            if(arr[index-1] < arr[index]){
                incrLen++;
                decrLen = 1;
            }
            else if(arr[index-1] > arr[index]){
                decrLen++;
                incrLen = 1;
            }
            else{
                incrLen = 1;
                decrLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incrLen, decrLen));
        }
        return maxLen;
    }
}