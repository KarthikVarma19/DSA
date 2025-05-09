class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isValid(i, j, ch, board) == true){
                            board[i][j] = ch;
                            if(solve(board) == true) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(int row, int col, char ch, char[][] board){
        for(int i = 0; i < 9; i++){
            //row
            if(board[row][i] == ch) return false;
            //col
            if(board[i][col] == ch) return false;
            //grid
            if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == ch) return false;
        }
        return true;
    }
}