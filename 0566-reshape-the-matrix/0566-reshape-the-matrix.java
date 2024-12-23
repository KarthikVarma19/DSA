class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if((r*c) != (mat.length*mat[0].length)) return mat;
        int newMat[][] = new int[r][c];
        int ri = 0, ci = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                newMat[ri][ci] = mat[i][j];
                ci++;
                if(ci == c){
                    ci = 0;
                    ri++;
                }
            }
        }
        return newMat;
    }
}