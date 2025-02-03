class Solution {
    public int findMax(int piles[]){
        int max = -1;
        for(int p: piles){
            if(p > max){
                max = p;
            }
        }
        return max;
    }
    public int findTime(int piles[], int capacity){
        int hrs = 0;
        for(int p: piles){
            hrs += Math.ceil((double)p/(double)capacity);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxAns = findMax(piles);
        int low = 1;
        int high = maxAns;
        int ans = maxAns;
        while(low <= high){
            int mid = low + (high - low)/2;
            int timeReq = findTime(piles, mid);
            if(timeReq <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}