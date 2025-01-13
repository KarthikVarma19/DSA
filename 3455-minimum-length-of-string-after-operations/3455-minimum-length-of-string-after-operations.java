class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        int len = 0;
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
            len++;
            if(freq[ch-'a'] == 3){
                freq[ch-'a'] = 1;
                len -= 2;
            }
        }

        return len;
    }
}