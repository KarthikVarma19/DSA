class Solution {
    public int[] constructDistancedSequence(int n) {
        int seq[] = new int[(2*n)-1];
        boolean map[] = new boolean[n+1];
        fill(seq, 0, n, map);
        return seq;
    }
    public boolean fill(int seq[], int pos, int n, boolean map[]){
        if(pos >= seq.length){
            return true;
        }
        if(seq[pos] != 0){
            return fill(seq, pos+1, n, map);
        }
        for(int num=n; num >= 1; num--){
            if(map[num] == true) continue;
            map[num] = true;
            seq[pos] = num;
            if(num == 1){
                if(fill(seq, pos+1,n, map) == true){
                    return true;
                }
            }else{
                int j = seq[pos] + pos;
                if(j < seq.length && seq[j] == 0){
                    seq[j] = num;
                    if(fill(seq, pos+1, n, map) == true){
                        return true;
                    }
                    seq[j] = 0;
                }
            }
            map[num] = false;
            seq[pos] = 0;
        }
        return false;
    }
}