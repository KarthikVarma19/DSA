class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Priority Queue to keep track of minimum time required to reach each cell
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0}); // {time, row, col}
        
        // Minimum time to reach each cell, initialize to a large value
        int[][] minTime = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        minTime[0][0] = 0;
        
        // Possible moves: down, up, right, left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];
            
            // If we reached the bottom-right corner, return the time
            // if (row == n - 1 && col == m - 1) {
            //     return minTime[n-1][m-1];
            // }
            
            // Explore all 4 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    // Calculate the earliest time we can move to the new cell
                    int nextTime = Math.max(time, moveTime[newRow][newCol])+1;
                    
                    // If this is a quicker way to reach the new cell, update and add to the queue
                    if (nextTime < minTime[newRow][newCol]) {
                        minTime[newRow][newCol] = nextTime;
                        pq.offer(new int[]{nextTime, newRow, newCol});
                    }
                }
            }
        }
        
        // If we exhaust the queue without reaching (n - 1, m - 1), return -1 (unreachable)
        return minTime[n-1][m-1];
    }
}