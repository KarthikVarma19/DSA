class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    char ch = word.charAt(0);
                    board[i][j] = '.';
                    if(solve(1, board, word, i, j) == true){
                        return true;
                    }
                    board[i][j] = ch;
                }
            }
        }
        return false;
    }
    public static int dir[][] = {{-1, 0}, {1, 0}, {0, 1}, {0,-1}};
    public boolean solve(int index, char board[][], String word, int row, int col){
        if(index == word.length()){
            return true;
        }
        char ch = word.charAt(index);
        for(int i = 0; i < 4; i++){
            int newRow = row + dir[i][0], newCol = col + dir[i][1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length){
                if(board[newRow][newCol] == ch && board[newRow][newCol] != '.'){
                    board[newRow][newCol] = '.';
                    if(solve(index+1, board, word, newRow, newCol) == true) return true;
                    board[newRow][newCol] = ch;
                }
            }
        }
        return false;
    }
}