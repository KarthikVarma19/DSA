class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int prefix[][] = new int[n][m];
        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += matrix[i][j] - '0';
                if(matrix[i][j] == '0'){
                    sum = 0;
                }
                prefix[i][j] = sum;
            }
        }
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, largestHistogram(prefix[i]));
        }
        return maxArea;
    }
    // 0, 1, 2, 3, 4
    // 3, 1, 3, 2, 2
    // -1,-1, 1, 1, 1
    public int largestHistogram(int arr[]){
        int n = arr.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && (arr[st.peek()] > arr[i])){
                // area = current_height * (nse - pse - 1)
                int height = st.pop();
                int nse = i;
                int pse = -1;
                if(!st.isEmpty()){
                    pse = st.peek();
                }
                int area = arr[height] * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);

        }
        while(!st.isEmpty()){
            int height = st.pop();
            int nse = n;
            int pse = -1;
            if(!st.isEmpty()){
                pse = st.peek();
            }
            int area = arr[height] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}