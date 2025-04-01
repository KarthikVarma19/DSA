class Solution {
    private int boq;
    private int adj;
    public int minDays(int[] bloomDay, int m, int k) {
        boq = m;
        adj = k;
        int n = bloomDay.length;
        // Impossible to Make the Bouqets
        long need = boq * adj;
        // System.out.println(need + " "+ n);
        if(boq > n || adj > n || boq * adj > n){
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = 0;
        for(int i = 0; i < n; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int ans = findMinDay(mini, maxi, bloomDay);
        return ans;
    }
    public int findMinDay(int low, int high, int arr[]){
        while(low <= high){
            int mid = (low + high) >>> 1;
            if(findifPossibletoMakeBoquets(mid, arr)){
                // find the min answer 
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        // low will be my answer
        return low;
    }
    public boolean findifPossibletoMakeBoquets(int day, int arr[]){
        int countAdj = 0;
        int totalMade = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day){
                countAdj++;
            }else{
                totalMade += (countAdj/adj);
                countAdj = 0;
            }
        }
        totalMade  += (countAdj/adj);
        return (totalMade >= boq);
    }

}