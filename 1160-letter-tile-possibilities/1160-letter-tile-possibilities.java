class Solution {
    int ans;
    public int numTilePossibilities(String tiles) {
        int hash[] = new int[26];
        for(char ch: tiles.toCharArray())
            hash[ch-'A']++;
        
        ans = 0;
        solve(hash);
        return ans;
    }
    private void solve(int hash[]){
        for(int i = 0; i < 26; i++){
            if(hash[i] == 0) continue;
            ans++;
            hash[i]--;
            solve(hash);
            hash[i]++;
        }
    }
}