class Solution {
    public void gameOfLife(int[][] board) {
        int ni[] = {1, 1, 1, 0, 0, -1, -1, -1};
        int nj[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = board.length;
        int m = board[0].length;
        int temp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // live neighbours and died neighbours
                int ln = 0, dn = 0;
                for(int d = 0; d < 8; d++){
                    int curi = i + ni[d], curj = j + nj[d];
                    if(curi >= 0 && curi < n && curj >= 0 && curj < m){
                        if(board[curi][curj] == 1){
                            ln++;
                        }else{
                            dn++;
                        }
                    }else{
                        dn++;
                    }
                }
                // live cell
                if(board[i][j] == 1){
                    if(ln < 2){
                        temp[i][j] = 0;
                    }else if(ln > 3){
                        temp[i][j] = 0;
                    }else{
                        temp[i][j] = 1;
                    }
                }
                else{
                    if(ln == 3){
                        temp[i][j] = 1;
                    }else{
                        temp[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = temp[i][j];
            }
        }
    }
}