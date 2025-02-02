class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int tot = 0;
        for(int d: machines){
            tot += d;
        }
        if(tot == 0 || n == 1) return 0;
        int target = tot/n;
        if(target < 1 || tot % n != 0) return -1;
        int move[] = new int[n];
        int result = 0;
        int prev = 0; 
        int next = 0;
        for(int i = 0; i < n - 1; i++){
            //grabbing from next machine it's his responsibility to donate
            if(machines[i] < target){
                machines[i+1] -= target - machines[i];
                next = target - machines[i];
                machines[i] = target;
                result = Math.max(result, next);
                prev = next;
                next = 0;
            }
            //donating to the next machine it's my responsibility to donate
            else{
                prev += machines[i] - target;
                machines[i+1] += machines[i] - target;
                machines[i] = target;
                result = Math.max(result, prev);
                prev = 0;
                next = 0;
            }

        }
        return result;

    }
}