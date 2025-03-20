class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cl = 0;
        int cr = 0;
        int em = 0;
        for(char ch: moves.toCharArray()){
            if(ch == '_'){
                em++;
            }else if(ch == 'L'){
                cl++;
            }else{
                cr++;
            }
        }
        if(cl > cr){
            cl += em;
            cl -= cr;
            cr = 0;
            return cl;
        }else{
            cr += em;
            cr -= cl;
            cl = 0; 
        }
        return cr;
    }
}