class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long high = 0;
        long low = 0;
        for(int w: weights){
            high += w;
            low = Math.max(low, w);
        }
        while(low <= high){
            long mid = (low + high) >>> 1;
            if(isPossible(mid, weights, days) <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return (int)low;
    }
    public int isPossible(long max, int w[], int days){
        int cur = 0;
        int daysneeded = 1;
        for(int i = 0; i < w.length; i++){
            if((cur+w[i]) > max){
                daysneeded++;
                cur = w[i];
            }else{
                cur += w[i];
            }
        }
        return daysneeded;
    }
}