class Solution {
    public int maxCandies(
        int[] status, 
        int[] candies, 
        int[][] keys, 
        int[][] containedBoxes, 
        int[] initialBoxes
    ) {
        Queue<Integer> q = new LinkedList<>();
        int n = status.length;
        boolean taken[] = new boolean[n];
        boolean boxFound[] = new boolean[n];
        boolean canOpen[] = new boolean[n];

        for(int i = 0; i < n; i++){
            canOpen[i] = (status[i] == 1);
        }

        int ans = 0;

        for(int eachBox: initialBoxes){
            boxFound[eachBox] = true;
            if(canOpen[eachBox]){
                q.add(eachBox);
                taken[eachBox] = true;
                ans += candies[eachBox];
            }
        }

        while(!q.isEmpty()){
            int bigBox = q.poll();
            for(int key: keys[bigBox]){
                canOpen[key] = true;
                if(!taken[key] && boxFound[key]){
                    q.add(key);
                    taken[key] = true;
                    ans += candies[key];
                }
            }
            for(int box: containedBoxes[bigBox]){
                boxFound[box] = true;
                if(!taken[box] && canOpen[box]){
                    q.add(box);
                    taken[box] = true;
                    ans += candies[box];
                }
            }
        }

        return ans;
    }
}