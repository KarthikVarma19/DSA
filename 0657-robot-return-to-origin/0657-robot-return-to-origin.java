class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0, j = 0;
        for(char ch: moves.toCharArray()){
            if(ch == 'U'){
                i++;
            }
            else if(ch == 'D'){
                i--;
            }
            else if(ch == 'L'){
                j++;
            }
            else if(ch == 'R'){
                j--;
            }
        }
        return (i == 0 && j == 0);
    }
}