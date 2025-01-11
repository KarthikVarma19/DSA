class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        int freq[] = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a'] += 1;
        }
        int oddCountCharacters = 0;
        for(int i=0;i<26;i++){
            if((freq[i] & 1) == 1){
                oddCountCharacters += 1;
            }
        }
        if(oddCountCharacters <= k){
            return true;
        }
        return false;
    }
}