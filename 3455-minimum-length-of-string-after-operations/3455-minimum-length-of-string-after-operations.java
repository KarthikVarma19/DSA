class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        int len = 0;
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
            len++;
            //once you found three character in the string then you can remove 2 of them 
            if(freq[ch-'a'] == 3){
                freq[ch-'a'] -= 2;
                len -= 2;
            }
        }
        return len;
    }
}