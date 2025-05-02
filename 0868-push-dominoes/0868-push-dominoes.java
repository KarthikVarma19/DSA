class Solution {
    public String pushDominoes(String dom) {
        char ch[] = dom.toCharArray();
        int n = ch.length;
        int forces[] = new int[n];
        int force = 0;
        for(int i = 0 ;i < n; i++){
            if(ch[i] == 'R'){
                force = n;
            }else if(ch[i] == 'L'){
                force = 0;
            }else{
                force = Math.max(force-1, 0);
            }
            forces[i] = force;
        }
        force = 0;
        char ans[] = new char[n];
        for(int i = n-1; i >= 0; i--){
            if(ch[i] == 'L'){
                force = n;
            }else if(ch[i] == 'R'){
                force = 0;
            }else{
                force = Math.max(force-1, 0);
            }
            forces[i] -= force;
            if(forces[i] > 0){
                ans[i] = 'R';
            }else if(forces[i] < 0){
                ans[i] = 'L';
            }else{
                ans[i] = '.';
            }
        }
        
        return new String(ans);
    }
}