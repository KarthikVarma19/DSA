class Solution {
    class pair{
        int i;
        int j;
        pair(int a, int b){ 
            this.i = a;
            this.j = b;
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        //Pre Processed the elements position in hashamp
        HashMap<Integer,pair> hm = new HashMap<>();
        int rowSum[] = new int[n];
        int colSum[] = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
                hm.put(mat[i][j], new pair(i, j));
            }
        }

        for(int i = 0; i < arr.length; i++){
            pair p = hm.get(arr[i]);
            int x = p.i, y = p.j;
            colSum[y] -= arr[i];
            rowSum[x] -= arr[i];
            if(colSum[y] == 0|| rowSum[x] == 0) return i;
        }
        return 0;
    }
}