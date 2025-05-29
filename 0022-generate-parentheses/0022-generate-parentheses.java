class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char par[] = new char[2 * n];
        // anslist, n, currentIndex, noOfOpenings, string in char array 
        genPar(ans, n, 0, 0, par);
        return ans;
    }
    public void genPar(List<String> ans, int n, int i, int opens, char par[]){
        // if number of openings === closing then add to list and return 
        if(i == (2 * n)){
            ans.add(new String(par));
            return;
        }
        if(opens < n){
            par[i] = '(';
            genPar(ans, n, i + 1, opens+1, par);
        }
        int closes = i-opens;
        if(closes < opens){
            par[i] = ')';
            genPar(ans, n, i + 1, opens, par);
        }
    }
}